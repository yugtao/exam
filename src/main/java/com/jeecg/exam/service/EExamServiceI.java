package com.jeecg.exam.service;
import com.jeecg.exam.entity.EExamEntity;
import com.jeecg.exam.entity.EPlaceEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface EExamServiceI extends CommonService{
 	public void delete(EExamEntity entity) throws Exception;
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(EExamEntity eExam,
	        List<EPlaceEntity> ePlaceList) throws Exception;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(EExamEntity eExam,
	        List<EPlaceEntity> ePlaceList) throws Exception;
	        
	/**
	 * 删除一对多
	 * 
	 */
	public void delMain (EExamEntity eExam) throws Exception;
}
