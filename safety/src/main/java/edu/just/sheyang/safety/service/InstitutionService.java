package edu.just.sheyang.safety.service;

import javax.servlet.http.HttpServletRequest;

public interface InstitutionService {
    public String getCountry(HttpServletRequest request);
    public String get(HttpServletRequest request,String country);
}
