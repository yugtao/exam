<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="eStudentList" checkbox="true" pagination="true" fitColumns="true" title="考生信息报名审核表" sortName="id" actionUrl="eStudentController.do?getOrgStu" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="用户id"  field="userId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="报名单位"  field="sOrg"  queryMode="single"  dictionary="t_s_depart,id,departname"  width="120"></t:dgCol>
   <t:dgCol title="报名职业"  field="sWork"  queryMode="single"  dictionary="e_work,id,w_name"  width="120"></t:dgCol>
   <t:dgCol title="学员姓名"  field="sStudient"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="学员性别"  field="sSex"  queryMode="single"  dictionary="e_sex"  width="120"></t:dgCol>
   <t:dgCol title="出生年月"  field="sBirthday"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="民族"  field="sNation"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="籍贯"  field="sJiguan"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="户口"  field="sHukou"  hidden="true"  queryMode="single"  dictionary="e_politics"  width="120"></t:dgCol>
   <t:dgCol title="政治面貌"  field="sPolitics"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="学历"  field="sEducation"  queryMode="single"  dictionary="e_edu"  width="120"></t:dgCol>
   <t:dgCol title="学位"  field="sDegree"  queryMode="single"  dictionary="e_degree"  width="120"></t:dgCol>
   <t:dgCol title="毕业学校"  field="sSchool"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="专业"  field="sMajor"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="毕业年月"  field="sGDate"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="婚姻状况"  field="sMarry"  hidden="true"  queryMode="single"  dictionary="e_marry"  width="120"></t:dgCol>
   <t:dgCol title="本人身份"  field="sIndntity"  hidden="true"  queryMode="single"  dictionary="e_identity"  width="120"></t:dgCol>
   <t:dgCol title="现工作单位"  field="sOrgNow"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="现职务"  field="sJobNow"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="参加工作时间"  field="sWorkDate"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="身份证号"  field="sCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="通讯地址"  field="sAdress"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="联系电话"  field="sTel"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="笔试成绩"  field="sWrittenScore"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="面试成绩"  field="sInterviewScore"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="总成绩"  field="sTotalScore"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="排名"  field="sRank"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="sRemarks"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="审核状态"  field="sStatus"  query="true"  queryMode="single"  dictionary="e_s_status"  width="120"></t:dgCol>
   <t:dgCol title="审核人"  field="sAuditor"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="报名时间"  field="sCreateDate"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="审核不通过原因"  field="sReason"  hidden="true"  queryMode="single"  width="500"></t:dgCol>
   <%-- <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="eStudentController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/> --%>
	<t:dgToolBar title="审核及记分" icon="icon-edit" url="eStudentController.do?goaudi" funname="update"></t:dgToolBar>
  <%--  <t:dgToolBar title="批量删除"  icon="icon-remove" url="eStudentController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar> --%>
   <%-- <t:dgToolBar title="查看" icon="icon-search" url="eStudentController.do?goUpdate" funname="detail"></t:dgToolBar> --%>
   <%-- <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
		<t:dgToolBar title="审核通过" icon="icon-edit" funname="doPass"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
		//自定义按钮-审核通过
	 	function doPass(title,url,gridname){
	 		pass();
	 	}
   
		//自定义按钮-审核通过
	 	function doPass2(id,index){
	 		pass2(id);
	 	}
		//自定义按钮-审核不通过
	 	function doNotpass(id,index){
	 		notpass(id);
	 	}
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'eStudentController.do?upload', "eStudentList");
}

//导出
function ExportXls() {
	JeecgExcelExport("eStudentController.do?exportXls","eStudentList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("eStudentController.do?exportXlsByT","eStudentList");
}

 </script>
