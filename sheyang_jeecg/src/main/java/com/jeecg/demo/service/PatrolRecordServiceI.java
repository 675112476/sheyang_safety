package com.jeecg.demo.service;
import com.jeecg.demo.entity.PatrolRecordEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface PatrolRecordServiceI extends CommonService{
	
 	public void delete(PatrolRecordEntity entity) throws Exception;
 	
 	public Serializable save(PatrolRecordEntity entity) throws Exception;
 	
 	public void saveOrUpdate(PatrolRecordEntity entity) throws Exception;
 	
}
