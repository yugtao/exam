package com.jeecg.exam.controller;
import com.jeecg.exam.entity.EUserEntity;
import com.jeecg.exam.service.EUserServiceI;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.common.TreeChildCount;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import java.io.OutputStream;
import org.jeecgframework.core.util.BrowserUtils;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.TemplateExcelConstants;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jeecgframework.core.util.ResourceUtil;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.Map;
import java.util.HashMap;
import org.jeecgframework.core.util.ExceptionUtil;


/**   
 * @Title: Controller  
 * @Description: 注册用户信息表
 * @author onlineGenerator
 * @date 2018-11-07 21:48:00
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/eUserController")
public class EUserController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(EUserController.class);

	@Autowired
	private EUserServiceI eUserService;
	@Autowired
	private SystemService systemService;


	/**
	 * 注册用户信息表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/exam/eUserList");
	}
	/**
	 * 前往我的信息页
	 * 
	 * @return
	 */
	@RequestMapping(params = "myInfo")
	public ModelAndView myInfo(HttpServletRequest request) {
		TSUser user = ResourceUtil.getSessionUser();
		String userId = user.getId();
		List<EUserEntity> findByProperty = eUserService.findByProperty(EUserEntity.class, "userId", userId);
		if (!findByProperty.isEmpty()) {
			EUserEntity eUser = findByProperty.get(0);
			request.setAttribute("eUserPage", eUser);
		}
		return new ModelAndView("com/jeecg/exam/student/myInfo");
	}
	
	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(EUserEntity eUser,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(EUserEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, eUser, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.eUserService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除注册用户信息表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(EUserEntity eUser, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		eUser = systemService.getEntity(EUserEntity.class, eUser.getId());
		message = "注册用户信息表删除成功";
		try{
			eUserService.delete(eUser);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "注册用户信息表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除注册用户信息表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "注册用户信息表删除成功";
		try{
			for(String id:ids.split(",")){
				EUserEntity eUser = systemService.getEntity(EUserEntity.class, 
				id
				);
				eUserService.delete(eUser);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "注册用户信息表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加注册用户信息表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(EUserEntity eUser, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		if(StringUtil.isEmpty(eUser.getId())) {
		message = "个人信息表添加成功";
		}else {
			message = "个人信息表更新成功";
		}
		TSUser user = ResourceUtil.getSessionUser();
		String userId = user.getId();
		eUser.setUserId(userId);
		try{
			eUserService.saveOrUpdate(eUser);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "个人信息表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新注册用户信息表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(EUserEntity eUser, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "注册用户信息表更新成功";
		EUserEntity t = eUserService.get(EUserEntity.class, eUser.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(eUser, t);
			eUserService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "注册用户信息表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 注册用户信息表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(EUserEntity eUser, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(eUser.getId())) {
			eUser = eUserService.getEntity(EUserEntity.class, eUser.getId());
			req.setAttribute("eUserPage", eUser);
		}
		return new ModelAndView("com/jeecg/exam/eUser-add");
	}
	/**
	 * 注册用户信息表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(EUserEntity eUser, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(eUser.getId())) {
			eUser = eUserService.getEntity(EUserEntity.class, eUser.getId());
			req.setAttribute("eUserPage", eUser);
		}
		return new ModelAndView("com/jeecg/exam/eUser-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","eUserController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(EUserEntity eUser,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(EUserEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, eUser, request.getParameterMap());
		List<EUserEntity> eUsers = this.eUserService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"注册用户信息表");
		modelMap.put(NormalExcelConstants.CLASS,EUserEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("注册用户信息表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,eUsers);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(EUserEntity eUser,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"注册用户信息表");
    	modelMap.put(NormalExcelConstants.CLASS,EUserEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("注册用户信息表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
    	"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<EUserEntity> listEUserEntitys = ExcelImportUtil.importExcel(file.getInputStream(),EUserEntity.class,params);
				for (EUserEntity eUser : listEUserEntitys) {
					eUserService.save(eUser);
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(e.getMessage());
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return j;
	}
	
	
}
