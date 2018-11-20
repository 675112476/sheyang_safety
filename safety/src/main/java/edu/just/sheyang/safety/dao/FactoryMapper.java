package edu.just.sheyang.safety.dao;

import edu.just.sheyang.safety.model.Factory;
import edu.just.sheyang.safety.utils.MyMapper;

public interface FactoryMapper extends MyMapper<Factory> {
    public String getRiskByFactory(String factory);
}