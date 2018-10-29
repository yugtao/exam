package com.jeecg.exam.service.impl;
import com.jeecg.exam.service.EExamServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.exam.entity.EExamEntity;
import com.jeecg.exam.entity.EPlaceEntity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import java.util.ArrayList;
import java.util.UUID;
import java.io.Serializable;

import java.util.Map;
import java.util.HashMap;
import org.jeecgframework.minidao.util.FreemarkerParseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.jeecgframework.core.util.ResourceUtil;

@Service("eExamService")
@Transactional
public class EExamServiceImpl extends CommonServiceImpl implements EExamServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
 	public void delete(EExamEntity entity) throws Exception{
 		super.delete(entity);
 	}
	public void addMain(EExamEntity eExam,
	        List<EPlaceEntity> ePlaceList) throws Exception{
			//保存主信息
			this.save(eExam);
		
			/**保存-考场信息*/
			for(EPlaceEntity ePlace:ePlaceList){
				//外键设置
				ePlace.setExamId(eExam.getId());
				this.save(ePlace);
			}
	}

	public void updateMain(EExamEntity eExam,
	        List<EPlaceEntity> ePlaceList) throws Exception {
		//保存主表信息
		if(StringUtil.isNotEmpty(eExam.getId())){
			try {
				EExamEntity temp = findUniqueByProperty(EExamEntity.class, "id", eExam.getId());
				MyBeanUtils.copyBeanNotNull2Bean(eExam, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(eExam);
		}
		//===================================================================================
		//获取参数
		Object id0 = eExam.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-考场信息
	    String hql0 = "from EPlaceEntity where 1 = 1 AND examId = ? ";
	    List<EPlaceEntity> ePlaceOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-考场信息
		if(ePlaceList!=null&&ePlaceList.size()>0){
		for(EPlaceEntity oldE:ePlaceOldList){
			boolean isUpdate = false;
				for(EPlaceEntity sendE:ePlaceList){
					//需要更新的明细数据-考场信息
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-考场信息
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-考场信息
			for(EPlaceEntity ePlace:ePlaceList){
				if(oConvertUtils.isEmpty(ePlace.getId())){
					//外键设置
					ePlace.setExamId(eExam.getId());
					this.save(ePlace);
				}
			}
		}
	}

	public void delMain(EExamEntity eExam) throws Exception{
		//删除主表信息
		this.delete(eExam);
		//===================================================================================
		//获取参数
		Object id0 = eExam.getId();
		//===================================================================================
		//删除-考场信息
	    String hql0 = "from EPlaceEntity where 1 = 1 AND examId = ? ";
	    List<EPlaceEntity> ePlaceOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(ePlaceOldList);
		
	}
 	
}