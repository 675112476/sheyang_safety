package edu.just.sheyang.safety.service;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public interface InstitutionService {
    public String getCountry(HttpServletRequest request);
    public String get(HttpServletRequest request,String country);
    public String getRiskpoints(HttpServletRequest request,String factory);
    public String insertrisks(String[] date,String[] factory,String[] risk_point,String[] is_control,HttpServletRequest request);
    public String insertrecords(String patrol_name,String patrol_phone,String time,String patrol_factory,String address,String measures,HttpServletRequest request) throws ParseException;
}
