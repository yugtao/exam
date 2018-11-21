<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="eWorkList" checkbox="true" pagination="true" fitColumns="true" title="职位表" sortName="id" actionUrl="eWorkController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属考试"  field="wExam"  query="true"  queryMode="single"  dictionary="e_exam,id,e_name"  width="120"></t:dgCol>
   <t:dgCol title="所属单位"  field="wOrg"  query="true"  queryMode="single"  dictionary="t_s_depart,id,departname"  width="120"></t:dgCol>
   <t:dgCol title="岗位名称"  field="wName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="岗位类别"  field="wType"  queryMode="single"  dictionary="e_wtype"  width="120"></t:dgCol>
   <t:dgCol title="招聘人数"  field="wCount"  queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="报名人数"  field="wBCount"  queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="学历要求"  field="wAskEducation"  hidden="true"  queryMode="single"  dictionary="e_edu"  width="120"></t:dgCol>
   <t:dgCol title="学位要求"  field="wAskDegree"  hidden="true"  queryMode="single"  dictionary="e_degree"  width="120"></t:dgCol>
   <t:dgCol title="专业"  field="wAskMajor"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="年龄"  field="wAskAge"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="职称"  field="wAskTitle"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="其他要求"  field="wAskOther"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="资格审查通过人数"  field="wPassCount"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="未通过人数"  field="wPassNot"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="职位状态"  field="wStatus"  query="true"  queryMode="single"  dictionary="ew_status"  width="80"></t:dgCol>
   <t:dgCol title="笔试人数"  field="wWriCount"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="笔试开考比例"  field="wWriPro"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="面试人数"  field="wIntCount"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="面试开考比例"  field="wIntPro"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="实际招收人数"  field="wRCount"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="解释"  field="wReason"  hidden="true"  queryMode="single"  width="250"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="eWorkController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="eWorkController.do?goAdd" funname="add"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="eWorkController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="eWorkController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="eWorkController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'eWorkController.do?upload', "eWorkList");
}

//导出
function ExportXls() {
	JeecgExcelExport("eWorkController.do?exportXls","eWorkList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("eWorkController.do?exportXlsByT","eWorkList");
}

 </script>
