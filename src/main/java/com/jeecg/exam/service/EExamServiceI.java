package com.jeecg.exam.service;
import com.jeecg.exam.entity.EExamEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface EExamServiceI extends CommonService{
	
 	public void delete(EExamEntity entity) throws Exception;
 	
 	public Serializable save(EExamEntity entity) throws Exception;
 	
 	public void saveOrUpdate(EExamEntity entity) throws Exception;
 	
}
