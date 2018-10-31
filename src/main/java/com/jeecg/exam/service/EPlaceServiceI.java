package com.jeecg.exam.service;
import com.jeecg.exam.entity.EPlaceEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface EPlaceServiceI extends CommonService{
	
 	public void delete(EPlaceEntity entity) throws Exception;
 	
 	public Serializable save(EPlaceEntity entity) throws Exception;
 	
 	public void saveOrUpdate(EPlaceEntity entity) throws Exception;
 	
}
