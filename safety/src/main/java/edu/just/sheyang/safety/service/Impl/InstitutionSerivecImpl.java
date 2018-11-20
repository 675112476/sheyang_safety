package edu.just.sheyang.safety.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import edu.just.sheyang.safety.dao.*;
import edu.just.sheyang.safety.model.Institution;
import edu.just.sheyang.safety.model.Patrol_record;
import edu.just.sheyang.safety.model.Riskpoints;
import edu.just.sheyang.safety.model.T_s_depart;
import edu.just.sheyang.safety.service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class InstitutionSerivecImpl implements InstitutionService {
    @Autowired
    private  InstitutionMapper institutionMapper;
    @Autowired
    private IndustryMapper industryMapper;
    @Autowired
    private T_s_departMapper t_s_departMapper;
    @Autowired
    private FactoryMapper factoryMapper;
    @Autowired
    private RiskpointsMapper riskpointsMapper;
    @Autowired
    private Patrol_recordMapper patrol_recordMapper;

    @Override
    public String getCountry(HttpServletRequest request) {
        String callback = request.getParameter("callback");
        List<T_s_depart> t_s_departList=t_s_departMapper.selectAll();
        String pid=null;
        for(T_s_depart t_s_depart:t_s_departList){
            if(t_s_depart.getParentdepartid()==null){
                pid=t_s_depart.getId();
            }
        }
        JSONObject jsonObject=new JSONObject();
        List countries=new ArrayList();
        for(T_s_depart t_s_depart:t_s_departList){
            if(!(t_s_depart.getParentdepartid()==null)&&t_s_depart.getParentdepartid().equals(pid)){
                countries.add(t_s_depart.getDepartname());
                System.out.println(t_s_depart.getDepartname());
            }
        }
        jsonObject.put("countries",countries);
        String result=callback+"("+jsonObject.toString()+")";
        return  result;
    }

    @Override
    public String get(HttpServletRequest request,String country) {
        System.out.println("country:"+country);
        String callback = request.getParameter("callback");
        List<T_s_depart> t_s_departList=t_s_departMapper.selectAll();
        String org_code=null;
        for(T_s_depart t_s_depart:t_s_departList){
            if(t_s_depart.getDepartname().equals(country)){
                org_code=t_s_depart.getOrgCode();
                System.out.println("org_code:"+org_code);
            }
        }
        List<Institution> institutionList=institutionMapper.selectAll();
        String fid=null;
        for(Institution institution:institutionList){
            if(institution.getSysOrgCode().equals(org_code)&&institution.getParentId()==null){
                fid=institution.getId();
                System.out.println("target:"+institution.getPersonName());
            }
        }
        JSONArray jsonArray=new JSONArray();
        JSONObject JsonObject=new JSONObject();
        JsonObject.put("target",fid);
        jsonArray.add(JsonObject);
        for(Institution institution:institutionList){
            JSONObject jsonObject=new JSONObject();
            String parentId=institution.getParentId();
            if(parentId==null||parentId.equals("")){
                parentId="0";
            }
            String industry_id=institution.getIndustry();
            List<String> results=new ArrayList<>();
            if(industry_id==null){
                results.add("");
            }else{
                String [] industry_ids=industry_id.split(",");
                List<String> ids=Arrays.asList(industry_ids);
                System.out.println("ids:"+ids);
                results=industryMapper.getIndustry(ids);
            }
            jsonObject.put("name",institution.getPersonName());
            jsonObject.put("dp",institution.getDepartDisplay());
            jsonObject.put("id",institution.getId());
            jsonObject.put("fid",parentId);
            jsonObject.put("industry",results);
            jsonArray.add(jsonObject);
        }
        String result=callback+"("+jsonArray.toString()+")";
        return  result;
    }

    @Override
    public String getRiskpoints(HttpServletRequest request, String factory) {
        String callback = request.getParameter("callback");
        System.out.println("factory:"+factory);
        String risk_display=factoryMapper.getRiskByFactory(factory);
        System.out.println("risk_display"+risk_display);
        String []risks=null;
        if(risk_display==null){
        }else {
            risks = risk_display.split(",");
        }
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("risks",risks);
        String result=callback+"("+jsonObject.toString()+")";
        System.out.println(result);
        return result;
    }

    @Override
    public String insertrisks(String[] date, String[] factory, String[] risk_point, String[] is_control) {
        String result="";
        for(int i=0;i<date.length;i++){
            Riskpoints riskpoint=new Riskpoints(factory[i],risk_point[i],is_control[i],date[i]);
            try {
                riskpointsMapper.insert(riskpoint);
                result="<script> alert('危险点信息提交成功，如存在危险点不可控，请继续填写整改措施，最终提交巡查记录.');history.go(-1);</script>";
            }catch (Exception excption){
                result=excption.toString();
            }
        }
        return result;
    }

    @Override
    public String insertrecords(String patrol_name, String patrol_phone, String time, String patrol_factory, String address, String measures,HttpServletRequest request) throws ParseException {
        String result="";
        String callback = request.getParameter("callback");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date datetime=sdf.parse(time);
        Patrol_record patrol_record=new Patrol_record(patrol_name,patrol_phone,datetime,patrol_factory,address,measures);
        try {
            patrol_recordMapper.insert(patrol_record);
            result="成功";
        }catch (Exception excption){
            result=excption.toString();
        }
        return  result=callback;
    }
}
