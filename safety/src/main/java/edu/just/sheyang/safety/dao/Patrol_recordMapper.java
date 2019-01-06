package edu.just.sheyang.safety.dao;

import edu.just.sheyang.safety.model.Patrol_record;
import edu.just.sheyang.safety.utils.MyMapper;

import java.util.List;

public interface Patrol_recordMapper extends MyMapper<Patrol_record> {
    public List<Patrol_record> getriskfactory(String riskponints);
}