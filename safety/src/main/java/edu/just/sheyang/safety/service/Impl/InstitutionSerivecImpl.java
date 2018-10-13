package edu.just.sheyang.safety.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import edu.just.sheyang.safety.dao.IndustryMapper;
import edu.just.sheyang.safety.dao.InstitutionMapper;
import edu.just.sheyang.safety.dao.T_s_departMapper;
import edu.just.sheyang.safety.model.Institution;
import edu.just.sheyang.safety.model.T_s_depart;
import edu.just.sheyang.safety.service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class InstitutionSerivecImpl implements InstitutionService {
    @Autowired
    private  InstitutionMapper institutionMapper;
    @Autowired
    private IndustryMapper industryMapper;
    @Autowired
    private T_s_departMapper t_s_departMapper;

//    @Override
//    public String getInstitution(javax.servlet.http.HttpServletRequest request) {
//        String callback = request.getParameter("callback");
//        List<Institution> institutionList=institutionMapper.selectAll();
//        JSONArray jsonArray=new JSONArray();
//        for(Institution institution:institutionList){
//            JSONObject jsonObject=new JSONObject();
//            String parentId=institution.getParentId();
//            if(parentId==null||parentId.equals("")){
//                parentId="0";
//            }
//            String industry_id=institution.getIndustry();
//            List<String> results=new ArrayList<>();
//            if(industry_id==null){
//                results.add("");
//            }else{
//                System.out.println("industry_id:"+industry_id);
//                String [] industry_ids=industry_id.split(",");
//                List<String> ids=Arrays.asList(industry_ids);
//                System.out.println("ids:"+ids);
//                results=industryMapper.getIndustry(ids);
//            }
//            System.out.println("results:"+results);
//            jsonObject.put("name",institution.getPersonName());
//            jsonObject.put("dp",institution.getDepartDisplay());
//            jsonObject.put("id",institution.getId());
//            jsonObject.put("fid",parentId);
//            jsonObject.put("industry",results);
//            jsonArray.add(jsonObject);
//        }
//        String result=callback+"("+jsonArray.toString()+")";
//        return  result;
//    }

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
}
