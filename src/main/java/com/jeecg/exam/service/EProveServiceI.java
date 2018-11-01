package com.jeecg.exam.service;
import com.jeecg.exam.entity.EProveEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface EProveServiceI extends CommonService{
	
 	public void delete(EProveEntity entity) throws Exception;
 	
 	public Serializable save(EProveEntity entity) throws Exception;
 	
 	public void saveOrUpdate(EProveEntity entity) throws Exception;
 	
}
