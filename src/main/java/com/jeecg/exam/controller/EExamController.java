package com.jeecg.exam.controller;
import com.jeecg.exam.entity.EExamEntity;
import com.jeecg.exam.service.EExamServiceI;
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
 * @Description: 考试表
 * @author onlineGenerator
 * @date 2018-11-01 11:08:16
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/eExamController")
public class EExamController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(EExamController.class);

	@Autowired
	private EExamServiceI eExamService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 考试表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/exam/eExamList");
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
	public void datagrid(EExamEntity eExam,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(EExamEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, eExam, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.eExamService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除考试表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(EExamEntity eExam, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		eExam = systemService.getEntity(EExamEntity.class, eExam.getId());
		message = "考试表删除成功";
		try{
			eExamService.delete(eExam);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "考试表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除考试表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "考试表删除成功";
		try{
			for(String id:ids.split(",")){
				EExamEntity eExam = systemService.getEntity(EExamEntity.class, 
				id
				);
				eExamService.delete(eExam);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "考试表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加考试表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(EExamEntity eExam, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "考试表添加成功";
		try{
			eExamService.save(eExam);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "考试表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新考试表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(EExamEntity eExam, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "考试表更新成功";
		EExamEntity t = eExamService.get(EExamEntity.class, eExam.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(eExam, t);
			eExamService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "考试表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 考试表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(EExamEntity eExam, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(eExam.getId())) {
			eExam = eExamService.getEntity(EExamEntity.class, eExam.getId());
			req.setAttribute("eExamPage", eExam);
		}
		return new ModelAndView("com/jeecg/exam/eExam-add");
	}
	/**
	 * 考试表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(EExamEntity eExam, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(eExam.getId())) {
			eExam = eExamService.getEntity(EExamEntity.class, eExam.getId());
			req.setAttribute("eExamPage", eExam);
		}
		return new ModelAndView("com/jeecg/exam/eExam-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","eExamController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(EExamEntity eExam,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(EExamEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, eExam, request.getParameterMap());
		List<EExamEntity> eExams = this.eExamService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"考试表");
		modelMap.put(NormalExcelConstants.CLASS,EExamEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("考试表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,eExams);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(EExamEntity eExam,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"考试表");
    	modelMap.put(NormalExcelConstants.CLASS,EExamEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("考试表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<EExamEntity> listEExamEntitys = ExcelImportUtil.importExcel(file.getInputStream(),EExamEntity.class,params);
				for (EExamEntity eExam : listEExamEntitys) {
					eExamService.save(eExam);
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
	/**
	 * bootstrap树形列表页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "goHome")
	public ModelAndView goHome(ModelMap model) {
		return new ModelAndView("com/jeecg/exam/examHome");
	}
	/**
	 *首页树形列表获取考试数据
	 * 
	 * @return
	 */
	@RequestMapping(params = "getExamInfo",method ={RequestMethod.GET, RequestMethod.POST})
	public  void getExamInfo(HttpServletRequest request,HttpServletResponse response) {
		    try {
		      String text1="[{\"id\":1,\"pid\":0,\"status\":1,\"name\":\"系统管理\",\"permissionValue\":\"系统\"},{\"id\":2,\"pid\":0,\"status\":1,\"name\":\"字典管理\",\"permissionValue\":\"字典\"},{\"id\":20,\"pid\":1,\"status\":1,\"name\":\"新增系统\",\"permissionValue\":\"新增\"},{\"id\":21,\"pid\":1,\"status\":1,\"name\":\"编辑系统\",\"permissionValue\":\"编辑\"},{\"id\":22,\"pid\":1,\"status\":1,\"name\":\"删除系统\",\"permissionValue\":\"删除\"},{\"id\":33,\"pid\":2,\"status\":1,\"name\":\"系统环境\",\"permissionValue\":\"环境\"},{\"id\":333,\"pid\":33,\"status\":1,\"name\":\"新增环境\",\"permissionValue\":\"新增\"},{\"id\":3333,\"pid\":33,\"status\":1,\"name\":\"编辑环境\",\"permissionValue\":\"编辑\"},{\"id\":233332,\"pid\":33,\"status\":0,\"name\":\"删除环境\",\"permissionValue\":\"删除\"}]";
			  response.getWriter().println(text1);
			 } catch (IOException e) {
				e.printStackTrace();
		  }
     }
}
