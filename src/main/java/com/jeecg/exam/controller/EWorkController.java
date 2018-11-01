package com.jeecg.exam.controller;
import com.jeecg.exam.entity.EWorkEntity;
import com.jeecg.exam.service.EWorkServiceI;
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
 * @Description: 职位表
 * @author onlineGenerator
 * @date 2018-11-01 10:46:00
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/eWorkController")
public class EWorkController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(EWorkController.class);

	@Autowired
	private EWorkServiceI eWorkService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 职位表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/exam/eWorkList");
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
	public void datagrid(EWorkEntity eWork,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(EWorkEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, eWork, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.eWorkService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除职位表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(EWorkEntity eWork, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		eWork = systemService.getEntity(EWorkEntity.class, eWork.getId());
		message = "职位表删除成功";
		try{
			eWorkService.delete(eWork);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "职位表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除职位表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "职位表删除成功";
		try{
			for(String id:ids.split(",")){
				EWorkEntity eWork = systemService.getEntity(EWorkEntity.class, 
				id
				);
				eWorkService.delete(eWork);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "职位表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加职位表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(EWorkEntity eWork, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "职位表添加成功";
		try{
			eWorkService.save(eWork);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "职位表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新职位表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(EWorkEntity eWork, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "职位表更新成功";
		EWorkEntity t = eWorkService.get(EWorkEntity.class, eWork.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(eWork, t);
			eWorkService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "职位表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 职位表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(EWorkEntity eWork, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(eWork.getId())) {
			eWork = eWorkService.getEntity(EWorkEntity.class, eWork.getId());
			req.setAttribute("eWorkPage", eWork);
		}
		return new ModelAndView("com/jeecg/exam/eWork-add");
	}
	/**
	 * 职位表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(EWorkEntity eWork, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(eWork.getId())) {
			eWork = eWorkService.getEntity(EWorkEntity.class, eWork.getId());
			req.setAttribute("eWorkPage", eWork);
		}
		return new ModelAndView("com/jeecg/exam/eWork-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","eWorkController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(EWorkEntity eWork,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(EWorkEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, eWork, request.getParameterMap());
		List<EWorkEntity> eWorks = this.eWorkService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"职位表");
		modelMap.put(NormalExcelConstants.CLASS,EWorkEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("职位表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,eWorks);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(EWorkEntity eWork,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"职位表");
    	modelMap.put(NormalExcelConstants.CLASS,EWorkEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("职位表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<EWorkEntity> listEWorkEntitys = ExcelImportUtil.importExcel(file.getInputStream(),EWorkEntity.class,params);
				for (EWorkEntity eWork : listEWorkEntitys) {
					eWorkService.save(eWork);
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
