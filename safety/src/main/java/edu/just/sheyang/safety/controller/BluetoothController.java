package edu.just.sheyang.safety.controller;

import edu.just.sheyang.safety.dao.InstitutionMapper;
import edu.just.sheyang.safety.service.Impl.InstitutionSerivecImpl;
import edu.just.sheyang.safety.service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class BluetoothController {
    @Autowired
    private InstitutionService institutionService;

    @RequestMapping("/getCountry")
    public String getCountry(HttpServletRequest request){
        String list=institutionService.getCountry(request);
        return  list;
    }
    @RequestMapping("/get")
    public String get(HttpServletRequest request){
        String country=request.getParameter("country");
        String list=institutionService.get(request,country);
        return  list;
    }
}
