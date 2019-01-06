package edu.just.sheyang.safety.dao;

import edu.just.sheyang.safety.model.Risks;
import edu.just.sheyang.safety.utils.MyMapper;

public interface RisksMapper extends MyMapper<Risks> {
    public String getNameById(String id);
}