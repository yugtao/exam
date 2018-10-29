package com.jeecg.exam.service;
import com.jeecg.exam.entity.EWorkEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface EWorkServiceI extends CommonService{
	
 	public void delete(EWorkEntity entity) throws Exception;
 	
 	public Serializable save(EWorkEntity entity) throws Exception;
 	
 	public void saveOrUpdate(EWorkEntity entity) throws Exception;
 	
}
