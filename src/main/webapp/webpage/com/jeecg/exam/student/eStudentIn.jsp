<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>报名信息</title>
<t:base type="jquery,easyui,tools,autocomplete,DatePicker"></t:base>
<SCRIPT type="text/javascript">
        function parse(data){
            	var parsed = [];
		        	$.each(data.rows,function(index,row){
		        		parsed.push({data:row,result:row,value:row.id});
		        	});
        				return parsed;
        }
        /**
         * 选择后回调 
         * 
         * @param {Object} data
         */
        function callBack(data) {
        	$("#user").val(data.userName);
        }
        
         /**
          * 每一个选择项显示的信息
          * 
          * @param {Object} data
          */
        function formatItem(data) {
        	return data.userName + "-->" + " " + data.realName;
        }
          
          function setContentc(){
        	 //alert("表单提交前想干点啥呢");
          }
          function test(data){
        	  console.log(data);
        	  alert(data.msg);
          }

  </SCRIPT>
  </head>
  <body>
<t:formvalid formid="formobj" dialog="false" layout="div" callback="test" action="eStudentController.do?doAdd" beforeSubmit="setContentc">
	 <fieldset class="step" style="padding-bottom: 20px;">
	 <legend>考生信息填写</legend>
	 	<div class="form">
			<label class="Validform_label"> 报名考试: </label> 
			<t:dictSelect field="sExamId" type="list"  dictTable="e_exam" dictField="id" dictText="e_name" datatype="*" dictCondition=" where e_status='2'"  defaultVal="${eStudentPage.sExamId}" hasLabel="false"  title="报名考试" ></t:dictSelect>
			<span class="Validform_checktip"></span>
		</div>
		
		<div class="form">
			<label class="Validform_label"> 报名单位: </label> 
			<t:dictSelect field="sOrg" type="list"  dictTable="t_s_depart" dictCondition=" where description !='1'" dictField="id" dictText="departname" datatype="*"  defaultVal="${eStudentPage.sOrg}" hasLabel="false"  title="报名单位" ></t:dictSelect>
			<span class="Validform_checktip"></span>
		</div>
		
		<div class="form">
			<label class="Validform_label"> 报名职业: </label> 
			<t:dictSelect field="sWork" type="list"  dictTable="e_work" dictField="id" dictText="w_name" datatype="*" defaultVal="${eStudentPage.sWork}" hasLabel="false"  title="报名职业" ></t:dictSelect>  
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 学员姓名: </label> 
			<input id="sStudient" name="sStudient" type="text" datatype="*" value="${eUserPage.realName}"/>
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 学员性别: </label> 
			 <t:dictSelect field="sSex" type="radio"  typeGroupCode="e_sex"  defaultVal="${eUserPage.userSex}" datatype="*" hasLabel="false"  title="学员性别" ></t:dictSelect>  
		    <span class="Validform_checktip"></span>
		</div>
		 <div class="form">
			<label class="Validform_label"> 出生年月： </label> 
			 <input id="sBirthday" name="sBirthday" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  ignore="ignore"  value='<fmt:formatDate value='${eUserPage.userBirthday}' type="date" pattern="yyyy-MM-dd"/>'/>
			<span class="Validform_checktip"></span>
		</div>
		
		<div class="form">
			<label class="Validform_label"> 民族： </label> 
			<input type="text" id="sNation" name="sNation" datatype="*" value="${eUserPage.userNation}" > 
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 籍贯： </label> 
			<input type="text" id="sJiguan" name="sJiguan" datatype="*" value="${eUserPage.userJiguan}" > 
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 户口所在地： </label> 
			<input type="text" id="sHukou" name="sHukou" datatype="*"  value="${eUserPage.userHukou}"> 
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 政治面貌： </label> 
			<t:dictSelect field="sPolitics" type="list"  typeGroupCode="e_politics"  defaultVal="${eUserPage.userPolitics}" hasLabel="false"  title="政治面貌"  datatype="*" ></t:dictSelect>
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 学历: </label> 
			<t:dictSelect field="sEducation" type="list"  typeGroupCode="e_edu"  defaultVal="${eUserPage.userEducation}" hasLabel="false"  title="学历" datatype="*"></t:dictSelect>
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 学位: </label> 
			
			<t:dictSelect field="sDegree" type="list"  typeGroupCode="e_degree"  defaultVal="${eUserPage.userDegree}" hasLabel="false"  title="学位" datatype="*"></t:dictSelect>
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 毕业学校: </label> 
			<input type="text" id="sSchool" name="sSchool" datatype="*"   value="${eUserPage.userSchool}"> 
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 专业: </label> 
			<input type="text" id="sMajor" name="sMajor" datatype="*" value="${eUserPage.userMajor}" > 
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 毕业年月: </label> 
			<input type="text" id="sGDate" name="sGDate" datatype="*" value="${eUserPage.userGDate}" > 
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 婚姻状况: </label> 
			<t:dictSelect field="sMarry" type="list"  typeGroupCode="e_marry" datatype="*" defaultVal="${eUserPage.userMarry}" hasLabel="false"  title="婚姻状况" ></t:dictSelect>
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 本人身份: </label> 
			  <t:dictSelect field="sIndntity" type="list"  typeGroupCode="e_identity" datatype="*" defaultVal="${eUserPage.userIndntity}" hasLabel="false"  title="本人身份" ></t:dictSelect>
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 现工作单位: </label> 
			<input type="text" id="sOrgNow" name="sOrgNow" datatype="*"  > 
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 现职务: </label> 
			<input type="text" id="sJobNow" name="sJobNow" datatype="*"  > 
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 参加工作时间: </label> 
			<input type="text" id="sWorkDate" name="sWorkDate" datatype="*"  value="${eUserPage.userWorkDate}"> 
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 身份证号: </label> 
			<input type="text" id="sCode" name="sCode" value="${eUserPage.userCode}"  datatype="/(^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$)|(^[1-9]\d{5}\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{2}$)/" errormsg="身份证格式不正确" > 
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 通讯地址: </label> 
			<input type="text" id="sAdress" name="sAdress" datatype="*"  value="${eUserPage.userAdress}"> 
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 邮箱:</label> 
			<input type="text" id="sTel" name="sEmail" datatype="e"   value="${eUserPage.userEmail}"> 
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 联系电话:</label> 
			<input type="text" id="sTel" name="sTel" datatype="*" value="${eUserPage.userTel}" > 
			<span class="Validform_checktip"></span>
		</div>
		<div style="text-align:center"><input class="btn" type="submit" value="提交" style="height:30px;width:100px !important;border-radius:5px"></div>
		
	</fieldset>
</t:formvalid>
</body>
</html>
<t:authFilter />