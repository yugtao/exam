package com.jeecg.exam.service;
import com.jeecg.exam.entity.EUserEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface EUserServiceI extends CommonService{
	
 	public void delete(EUserEntity entity) throws Exception;
 	
 	public Serializable save(EUserEntity entity) throws Exception;
 	
 	public void saveOrUpdate(EUserEntity entity) throws Exception;
 	
}
