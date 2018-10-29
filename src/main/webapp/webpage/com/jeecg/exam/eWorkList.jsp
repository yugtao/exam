<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="eWorkList" checkbox="true" pagination="true" fitColumns="true" title="职位表" sortName="id" actionUrl="eWorkController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="职位所属单位"  field="wOrg"  queryMode="single"  dictionary="t_s_depart,id,departname"  width="120"></t:dgCol>
   <t:dgCol title="职位名称"  field="wName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="计划招收人数"  field="wCount"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="实际招收人数"  field="wRCount"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="解释"  field="wReason"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="职位状态"  field="wStatus"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
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
