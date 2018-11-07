<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="eUserList" checkbox="true" pagination="true" fitColumns="true" title="注册用户信息表" sortName="id" actionUrl="eUserController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="用户id"  field="userId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="真实姓名"  field="realName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="学员性别"  field="userSex"  hidden="true"  queryMode="single"  dictionary="e_sex"  width="120"></t:dgCol>
   <t:dgCol title="出生日期"  field="userBirthday"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="民族"  field="userNation"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="籍贯"  field="userJiguan"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="户口"  field="userHukou"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="政治面貌"  field="userPolitics"  hidden="true"  queryMode="single"  dictionary="e_politics"  width="120"></t:dgCol>
   <t:dgCol title="学历"  field="userEducation"  queryMode="single"  dictionary="e_edu"  width="120"></t:dgCol>
   <t:dgCol title="学位"  field="userDegree"  queryMode="single"  dictionary="e_degree"  width="120"></t:dgCol>
   <t:dgCol title="毕业学校"  field="userSchool"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="专业"  field="userMajor"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="毕业年月"  field="userGDate"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="婚姻状况"  field="userMarry"  queryMode="single"  dictionary="e_marry"  width="120"></t:dgCol>
   <t:dgCol title="本人身份"  field="userIndntity"  queryMode="single"  dictionary="e_identity"  width="120"></t:dgCol>
   <t:dgCol title="参加工作时间"  field="userWorkDate"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="身份证号码"  field="userCode"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="联系地址"  field="userAdress"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="电话"  field="userTel"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="邮箱"  field="userEmail"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="eUserController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="eUserController.do?goAdd" funname="add"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="eUserController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="eUserController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="eUserController.do?goUpdate" funname="detail"></t:dgToolBar>
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
	openuploadwin('Excel导入', 'eUserController.do?upload', "eUserList");
}

//导出
function ExportXls() {
	JeecgExcelExport("eUserController.do?exportXls","eUserList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("eUserController.do?exportXlsByT","eUserList");
}

 </script>
