package com.jeecg.demo.service;
import com.jeecg.demo.entity.IndustryEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface IndustryServiceI extends CommonService{
	
 	public void delete(IndustryEntity entity) throws Exception;
 	
 	public Serializable save(IndustryEntity entity) throws Exception;
 	
 	public void saveOrUpdate(IndustryEntity entity) throws Exception;
 	
}
