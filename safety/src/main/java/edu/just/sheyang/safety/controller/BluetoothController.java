package edu.just.sheyang.safety.controller;

import edu.just.sheyang.safety.dao.InstitutionMapper;
import edu.just.sheyang.safety.service.Impl.InstitutionSerivecImpl;
import edu.just.sheyang.safety.service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

@RestController
public class BluetoothController {
    @Autowired
    private InstitutionService institutionService;

    @RequestMapping("/getCountry")
    public String getCountry(HttpServletRequest request){
        String list=institutionService.getCountry(request);
        System.out.println("----getCountry");
        return  list;
    }
    @RequestMapping("/get")
    public String get(HttpServletRequest request){
        String country=request.getParameter("country");
        String list=institutionService.get(request,country);
        System.out.println("----get");
        return  list;
    }
    @RequestMapping("/getriskpoints")
    @ResponseBody
    public String getriskpoints(HttpServletRequest request){
        String factory=request.getParameter("factory");
        String list=institutionService.getRiskpoints(request,factory);
        System.out.println("----getriskpoints");
        return  list;
    }
    @RequestMapping("/insertrisks")
    public String insertrisks(@RequestParam("date") String[] date,@RequestParam("patrol_person") String[] patrol_person,@RequestParam("factory") String[] factory,
                              @RequestParam("risk_point") String[] risk_point,@RequestParam("is_control") String[] is_control,HttpServletRequest request)
    {
        String result=institutionService.insertrisks(date,patrol_person,factory,risk_point,is_control,request);
        System.out.println("----insertrisks");
        return  result;
    }
    @RequestMapping("test")
    public String test(){
        return "123";
    }

    @RequestMapping("/insertrecords")
    public String insertrecords(@RequestParam("patrol_name") String patrol_name,@RequestParam("patrol_phone") String patrol_phone,
                              @RequestParam("time") String time,@RequestParam("patrol_factory") String patrol_factory,
                                @RequestParam("address") String address,@RequestParam("measures") String measures,HttpServletRequest request) throws ParseException {
        String result=institutionService.insertrecords(patrol_name,patrol_phone,time,patrol_factory,address,measures,request);
        System.out.println("----insertrecords");
        return  result;
    }
    @RequestMapping("getrisks")
    public String getrisks(@RequestParam("date") String date, @RequestParam("patrol_person") String patrol_person, @RequestParam("factory") String factory, HttpServletRequest request){
        String result=institutionService.getrisks(date,patrol_person,factory,request);
        System.out.println("----getrisks");
        return result;
    }
    @RequestMapping("getriskfactory")
    public String getriskfactory(String riskpoint,HttpServletRequest request){
        String result=institutionService.getriskfactory(riskpoint,request);
        System.out.println("----getriskfactory");
        return result;
    }

}
