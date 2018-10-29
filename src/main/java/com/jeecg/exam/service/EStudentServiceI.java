package com.jeecg.exam.service;
import com.jeecg.exam.entity.EStudentEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface EStudentServiceI extends CommonService{
	
 	public void delete(EStudentEntity entity) throws Exception;
 	
 	public Serializable save(EStudentEntity entity) throws Exception;
 	
 	public void saveOrUpdate(EStudentEntity entity) throws Exception;
 	
}
