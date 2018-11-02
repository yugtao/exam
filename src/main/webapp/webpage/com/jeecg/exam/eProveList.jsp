<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="eProveList" checkbox="true" pagination="true" fitColumns="true" title="准考证表" sortName="id" actionUrl="eProveController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="考生名"  field="proveStuName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="身份证号"  field="proveCardCode"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="报考单位"  field="proveOrg"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="报考职业"  field="proveWork"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="准考证号"  field="proveCode"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="考场地址"  field="provePlace"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="座位信息"  field="proveSeat"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="考生id"  field="proveStuId"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="考生账户id"  field="proveUserId"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="考试id"  field="proveExamId"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="考试名"  field="proveExamName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="考试时间"  field="proveDate"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="考场"  field="proveRoom"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="eProveController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="eProveController.do?goAdd" funname="add"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="eProveController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="eProveController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="eProveController.do?goUpdate" funname="detail"></t:dgToolBar>
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
	openuploadwin('Excel导入', 'eProveController.do?upload', "eProveList");
}

//导出
function ExportXls() {
	JeecgExcelExport("eProveController.do?exportXls","eProveList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("eProveController.do?exportXlsByT","eProveList");
}

 </script>
