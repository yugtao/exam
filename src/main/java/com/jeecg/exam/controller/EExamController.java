package com.jeecg.exam.controller;
import com.jeecg.exam.entity.EExamEntity;
import com.jeecg.exam.service.EExamServiceI;
import com.jeecg.exam.page.EExamPage;
import com.jeecg.exam.entity.EPlaceEntity;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.io.IOException;
import java.util.Map;


/**   
 * @Title: Controller
 * @Description: 考试表
 * @author onlineGenerator
 * @date 2018-10-29 15:34:56
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
		AjaxJson j = new AjaxJson();
		eExam = systemService.getEntity(EExamEntity.class, eExam.getId());
		String message = "考试表删除成功";
		try{
			eExamService.delMain(eExam);
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
		AjaxJson j = new AjaxJson();
		String message = "考试表删除成功";
		try{
			for(String id:ids.split(",")){
				EExamEntity eExam = systemService.getEntity(EExamEntity.class,
				id
				);
				eExamService.delMain(eExam);
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
	public AjaxJson doAdd(EExamEntity eExam,EExamPage eExamPage, HttpServletRequest request) {
		List<EPlaceEntity> ePlaceList =  eExamPage.getEPlaceList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			eExamService.addMain(eExam, ePlaceList);
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
	public AjaxJson doUpdate(EExamEntity eExam,EExamPage eExamPage, HttpServletRequest request) {
		List<EPlaceEntity> ePlaceList =  eExamPage.getEPlaceList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			eExamService.updateMain(eExam, ePlaceList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新考试表失败";
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
	 * 加载明细列表[考场信息]
	 * 
	 * @return
	 */
	@RequestMapping(params = "ePlaceList")
	public ModelAndView ePlaceList(EExamEntity eExam, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = eExam.getId();
		//===================================================================================
		//查询-考场信息
	    String hql0 = "from EPlaceEntity where 1 = 1 AND examId = ? ";
	    try{
	    	List<EPlaceEntity> ePlaceEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("ePlaceList", ePlaceEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/jeecg/exam/ePlaceList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(EExamEntity eExam,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(EExamEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, eExam);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<EExamEntity> list=this.eExamService.getListByCriteriaQuery(cq, false);
    	List<EExamPage> pageList=new ArrayList<EExamPage>();
        if(list!=null&&list.size()>0){
        	for(EExamEntity entity:list){
        		try{
        		EExamPage page=new EExamPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from EPlaceEntity where 1 = 1 AND examId = ? ";
        	        List<EPlaceEntity> ePlaceEntityList = systemService.findHql(hql0,id0);
            		page.setEPlaceList(ePlaceEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"考试表");
        map.put(NormalExcelConstants.CLASS,EExamPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("考试表列表", "导出人:Jeecg",
            "导出信息"));
        map.put(NormalExcelConstants.DATA_LIST,pageList);
        return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}

    /**
	 * 通过excel导入数据
	 * @param request
	 * @param
	 * @return
	 */
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
			params.setHeadRows(2);
			params.setNeedSave(true);
			try {
				List<EExamPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), EExamPage.class, params);
				EExamEntity entity1=null;
				for (EExamPage page : list) {
					entity1=new EExamEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            eExamService.addMain(entity1, page.getEPlaceList());
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
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
	* 导出excel 使模板
	*/
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(ModelMap map) {
		map.put(NormalExcelConstants.FILE_NAME,"考试表");
		map.put(NormalExcelConstants.CLASS,EExamPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("考试表列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
		"导出信息"));
		map.put(NormalExcelConstants.DATA_LIST,new ArrayList());
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	* 导入功能跳转
	*
	* @return
	*/
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name", "eExamController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	
}
