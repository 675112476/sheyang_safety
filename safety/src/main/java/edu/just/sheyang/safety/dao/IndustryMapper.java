package edu.just.sheyang.safety.dao;

import edu.just.sheyang.safety.model.Industry;
import edu.just.sheyang.safety.utils.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IndustryMapper extends MyMapper<Industry> {
    public List<String> getIndustry(@Param("industryIds") List<String> industryIds);
}