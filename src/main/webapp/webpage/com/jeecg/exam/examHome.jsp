<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="eWorkList" checkbox="false" pagination="true" fitColumns="true" title="发布中的考试" sortName="id" actionUrl="eWorkController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="职位所属单位"  field="wOrg"  queryMode="single"  dictionary="t_s_depart,id,departname"  width="180"></t:dgCol>
   <t:dgCol title="岗位名称"  field="wName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="岗位类别"  field="wType"  queryMode="single"  dictionary="	 e_wtype"  width="80"></t:dgCol>
   <t:dgCol title="招聘人数"  field="wCount"  queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="报名人数"  field="wBCount"  queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="学历要求"  field="wAskEducation"  queryMode="single"  dictionary="e_edu"  width="100"></t:dgCol>
   <t:dgCol title="学位要求"  field="wAskDegree" queryMode="single"  dictionary="e_degree"  width="80"></t:dgCol>
   <t:dgCol title="专业"  field="wAskMajor"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="年龄"  field="wAskAge"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="职称"  field="wAskTitle"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="其他要求"  field="wAskOther"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="资格审查通过人数"  field="wPassCount"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="未通过人数"  field="wPassNot"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="职位状态"  field="wStatus"  hidden="true"  queryMode="single"  dictionary="ew_status"  width="120"></t:dgCol>
   <t:dgCol title="笔试人数"  field="wWriCount"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="笔试开考比例"  field="wWriPro"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="面试人数"  field="wIntCount"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="面试开考比例"  field="wIntPro"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="实际招收人数"  field="wRCount"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="解释"  field="wReason"  hidden="true"  queryMode="single"  width="250"></t:dgCol>
   <t:dgCol title="职业所属考试"  field="wExam"  queryMode="single"  dictionary="e_exam,id,e_name"  width="120"></t:dgCol>
  </t:datagrid>
  </div>
 </div>
 <div>
 	<h4>
 	  我的考试
 	</h4>
 	<ul>
 		<li><span>考试名</span></li>
 		<li><span>报名时间</span></li>
 		<li><span>审核状态</span></li>
 		<li><span>考试时间</span></li>
 	</ul>
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
