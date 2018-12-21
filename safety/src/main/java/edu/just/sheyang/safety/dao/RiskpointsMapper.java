package edu.just.sheyang.safety.dao;

import edu.just.sheyang.safety.model.Riskpoints;
import edu.just.sheyang.safety.utils.MyMapper;

import java.util.List;

public interface RiskpointsMapper extends MyMapper<Riskpoints> {
    public List<String> isControl(String factory, String time);
    public void delete_data(String patrol_person,String factory, String time);
}