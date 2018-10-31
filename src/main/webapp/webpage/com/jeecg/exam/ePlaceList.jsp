<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="ePlaceList" checkbox="true" pagination="true" fitColumns="true" title="考场表" sortName="id" actionUrl="ePlaceController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属考试"  field="examId"  queryMode="single"  dictionary="e_exam,id,e_name"  width="120"></t:dgCol>
   <t:dgCol title="考场名称"  field="pName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="考场地址信息"  field="pInfo"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="考场容纳人数"  field="pCount"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="ePlaceController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="ePlaceController.do?goAdd" funname="add"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="ePlaceController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="ePlaceController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="ePlaceController.do?goUpdate" funname="detail"></t:dgToolBar>
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
	openuploadwin('Excel导入', 'ePlaceController.do?upload', "ePlaceList");
}

//导出
function ExportXls() {
	JeecgExcelExport("ePlaceController.do?exportXls","ePlaceList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("ePlaceController.do?exportXlsByT","ePlaceList");
}

 </script>
