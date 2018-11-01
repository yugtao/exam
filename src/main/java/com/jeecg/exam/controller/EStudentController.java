package com.jeecg.exam.controller;
import com.jeecg.exam.entity.EExamEntity;
import com.jeecg.exam.entity.EPlaceEntity;
import com.jeecg.exam.entity.EProveEntity;
import com.jeecg.exam.entity.EStudentEntity;
import com.jeecg.exam.entity.EWorkEntity;
import com.jeecg.exam.service.EExamServiceI;
import com.jeecg.exam.service.EProveServiceI;
import com.jeecg.exam.service.EStudentServiceI;
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
import org.jeecgframework.core.common.dao.impl.CommonDao;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.common.TreeChildCount;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.CommonService;
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
import org.hibernate.criterion.Restrictions;
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
 * @Description: 考生信息报名审核表
 * @author onlineGenerator
 * @date 2018-11-01 08:46:46
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/eStudentController")
public class EStudentController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(EStudentController.class);

	@Autowired
	private EStudentServiceI eStudentService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private EProveServiceI eProveService;
	@Autowired
	private CommonService commonService;
	@Autowired
	private CommonDao commondao;
	@Autowired
	private EExamServiceI examService;


	/**
	 * 考生信息报名审核表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/exam/eStudentList");
	}
	
	/**
	 * 考生信息报名页面
	 * 
	 * @return
	 */
	@RequestMapping(params = "goStuIn")
	public ModelAndView stuIn(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/exam/student/eStudentIn");
	}
	/**
	 *前往审核状态页面
	 */
	@RequestMapping(params = "goStuList")
	public ModelAndView stuLits(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/exam/student/stu-eStudentList");
	}
	/**
	 *获取我的考试数据
	 */
	@RequestMapping(params = "myList")
	public void myList(EStudentEntity eStudent,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		TSUser user = ResourceUtil.getSessionUser();
		String userId = user.getId();
		CriteriaQuery cq = new CriteriaQuery(EStudentEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, eStudent, request.getParameterMap());
		try{
			cq.add(Restrictions.eq("userId", userId));
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.eStudentService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	/**
	 *生成并打印准考证
	 */
	@RequestMapping(params = "printProve")
	public ModelAndView printProve(HttpServletRequest request,String stu) {
		if (StringUtil.isNotEmpty(stu)) {
			EStudentEntity eStudent = eStudentService.getEntity(EStudentEntity.class,stu);
			EProveEntity eProve = new EProveEntity();
			EExamEntity exam = examService.getEntity(EExamEntity.class, eStudent.getSExamId());
			TSUser user = ResourceUtil.getSessionUser();
			TSDepart depart = commonService.getEntity(TSDepart.class, eStudent.getSOrg());
			EWorkEntity ework = commonService.getEntity(EWorkEntity.class, eStudent.getSWork());
			@SuppressWarnings("unchecked")
			List<EPlaceEntity> EPlaces = commondao.findByProperty(EPlaceEntity.class, "examId", exam.getId());
			for (EPlaceEntity ePlaceEntity : EPlaces) {
				String pCount = ePlaceEntity.getPCount();
				int count = Integer.parseInt(pCount);
				if(count>0) {
					eProve.setProvePlace(ePlaceEntity.getPName());
					eProve.setProveSeat(pCount);
					count = count-1;
					ePlaceEntity.setPCount(count+"");
					commonService.saveOrUpdate(ePlaceEntity);
					break;
				}
			}
			commonService.getEntity(TSDepart.class, eStudent.getSOrg());
			eProve.setProveCardCode(eStudent.getSCode());
			eProve.setProveCode("不知道怎么生成");
			eProve.setProveDate(exam.getEDate());
			eProve.setProveExamId(exam.getId());
			eProve.setProveExamName(exam.getEName());
			eProve.setProveOrg(depart.getDepartname());
			eProve.setProveStuId(eStudent.getId());
			eProve.setProveStuName(eStudent.getSStudient());
			eProve.setProveUserId(user.getId());
			eProve.setProveWork(ework.getWName());
			commonService.save(eProve);
			//req.setAttribute("eStudentPage", eStudent);
		}
		return new ModelAndView("com/jeecg/exam/student/printProve");
	}
	/**
	 *查看审核详情
	 */
	@RequestMapping(params = "goStuInfo")
	public ModelAndView stuInfo(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/exam/student/eStudentInfo");
	}
	
	/**
	 *查看审核列表
	 */
	@RequestMapping(params = "audiList")
	public ModelAndView audiList(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/exam/audi/eStudentList-audi");
	}
	/**
	 *查看考生详情页面
	 */
	@RequestMapping(params = "goaudi")
	public ModelAndView goaudi(EStudentEntity eStudent,HttpServletRequest req) {
		if (StringUtil.isNotEmpty(eStudent.getId())) {
			eStudent = eStudentService.getEntity(EStudentEntity.class, eStudent.getId());
			req.setAttribute("eStudentPage", eStudent);
		}
		return new ModelAndView("com/jeecg/exam/audi/eStudent-audi");
	}
	
	/**
	 * easyui 查看单位下的报名考生列表
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */
	@RequestMapping(params = "getOrgStu")
	public void getOrgStu(EStudentEntity eStudent,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		TSUser user = ResourceUtil.getSessionUser();
		String departid = user.getDepartid();
		CriteriaQuery cq = new CriteriaQuery(EStudentEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, eStudent, request.getParameterMap());
		try{
			cq.add(Restrictions.eq("SOrg", departid));
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.eStudentService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
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
	public void datagrid(EStudentEntity eStudent,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		
		CriteriaQuery cq = new CriteriaQuery(EStudentEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, eStudent, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.eStudentService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除考生信息报名审核表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(EStudentEntity eStudent, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		eStudent = systemService.getEntity(EStudentEntity.class, eStudent.getId());
		message = "考生信息报名审核表删除成功";
		try{
			eStudentService.delete(eStudent);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "考生信息报名审核表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除考生信息报名审核表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "考生信息报名审核表删除成功";
		try{
			for(String id:ids.split(",")){
				EStudentEntity eStudent = systemService.getEntity(EStudentEntity.class, 
				id
				);
				eStudentService.delete(eStudent);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "考生信息报名审核表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加考生信息报名审核表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(EStudentEntity eStudent, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "考生信息报名审核表添加成功";
		TSUser user = ResourceUtil.getSessionUser();
		eStudent.setSStatus("2");
		eStudent.setUserId(user.getId());
		try{
			eStudentService.save(eStudent);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "考生信息报名审核表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新考生信息报名审核表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(EStudentEntity eStudent, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "考生信息报名审核表更新成功";
		EStudentEntity t = eStudentService.get(EStudentEntity.class, eStudent.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(eStudent, t);
			eStudentService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "考生信息报名审核表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 考生信息报名审核表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(EStudentEntity eStudent, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(eStudent.getId())) {
			eStudent = eStudentService.getEntity(EStudentEntity.class, eStudent.getId());
			req.setAttribute("eStudentPage", eStudent);
		}
		return new ModelAndView("com/jeecg/exam/eStudent-add");
	}
	/**
	 * 考生信息报名审核表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(EStudentEntity eStudent, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(eStudent.getId())) {
			eStudent = eStudentService.getEntity(EStudentEntity.class, eStudent.getId());
			req.setAttribute("eStudentPage", eStudent);
		}
		return new ModelAndView("com/jeecg/exam/eStudent-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","eStudentController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(EStudentEntity eStudent,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(EStudentEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, eStudent, request.getParameterMap());
		List<EStudentEntity> eStudents = this.eStudentService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"考生信息报名审核表");
		modelMap.put(NormalExcelConstants.CLASS,EStudentEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("考生信息报名审核表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,eStudents);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(EStudentEntity eStudent,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"考生信息报名审核表");
    	modelMap.put(NormalExcelConstants.CLASS,EStudentEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("考生信息报名审核表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<EStudentEntity> listEStudentEntitys = ExcelImportUtil.importExcel(file.getInputStream(),EStudentEntity.class,params);
				for (EStudentEntity eStudent : listEStudentEntitys) {
					eStudentService.save(eStudent);
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
