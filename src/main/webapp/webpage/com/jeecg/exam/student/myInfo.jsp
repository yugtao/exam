<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>我的信息</title>
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
<t:formvalid formid="formobj" dialog="false" layout="div" callback="test" action="eUserController.do?doAdd" beforeSubmit="setContentc">
	 <fieldset class="step" style="padding-bottom: 20px;">
	 <legend>我的信息</legend>
	 <input id="id" name="id" type="hidden" value="${eUserPage.id }"/>
		<div class="form">
			<label class="Validform_label"> 真实姓名: </label> 
			<input id="realName" name="realName" type="text" datatype="*" value="${eUserPage.realName}"/>
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 性别: </label> 
			 <t:dictSelect field="userSex" type="radio"  typeGroupCode="e_sex"  defaultVal="${eUserPage.userSex}" datatype="*" hasLabel="false"  title="学员性别" ></t:dictSelect>  
		    <span class="Validform_checktip"></span>
		</div>
		 <div class="form">
			<label class="Validform_label"> 出生年月： </label> 
			 <input id="userBirthday" name="userBirthday" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  ignore="ignore"  value='<fmt:formatDate value='${eUserPage.userBirthday}' type="date" pattern="yyyy-MM-dd"/>'/>
			<span class="Validform_checktip"></span>
		</div>
		
		<div class="form">
			<label class="Validform_label"> 民族： </label> 
			<input type="text" id="userNation" name="userNation" datatype="*"  value="${eUserPage.userNation}"> 
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 籍贯： </label> 
			<input type="text" id="userJiguan" name="userJiguan" datatype="*" value="${eUserPage.userJiguan}" > 
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 户口所在地： </label> 
			<input type="text" id="userHukou" name="userHukou" datatype="*"  value="${eUserPage.userHukou}"> 
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 政治面貌： </label> 
			<t:dictSelect field="userPolitics" type="list"  typeGroupCode="e_politics"  defaultVal="${eUserPage.userPolitics}" hasLabel="false"  title="政治面貌"  datatype="*" ></t:dictSelect>
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 学历: </label> 
			<t:dictSelect field="userEducation" type="list"  typeGroupCode="e_edu"  defaultVal="${eUserPage.userEducation}" hasLabel="false"  title="学历" datatype="*"></t:dictSelect>
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 学位: </label> 
			
			<t:dictSelect field="userDegree" type="list"  typeGroupCode="e_degree"  defaultVal="${eUserPage.userDegree}" hasLabel="false"  title="学位" datatype="*"></t:dictSelect>
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 毕业学校: </label> 
			<input type="text" id="userSchool" name="userSchool" datatype="*"  value="${eUserPage.userSchool}"> 
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 专业: </label> 
			<input type="text" id="userMajor" name="userMajor" datatype="*"  value="${eUserPage.userMajor}"> 
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 毕业年月: </label> 
			<input type="text" id="userGDate" name="userGDate" datatype="*"  value="${eUserPage.userGDate}"> 
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 婚姻状况: </label> 
			<t:dictSelect field="userMarry" type="list"  typeGroupCode="e_marry" datatype="*" defaultVal="${eUserPage.userMarry}" hasLabel="false"  title="婚姻状况" ></t:dictSelect>
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 本人身份: </label> 
			  <t:dictSelect field="userIndntity" type="list"  typeGroupCode="e_identity" datatype="*" defaultVal="${eUserPage.userIndntity}" hasLabel="false"  title="本人身份" ></t:dictSelect>
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 参加工作时间: </label> 
			<input type="text" id="userWorkDate" name="userWorkDate" datatype="*"  value="${eUserPage.userWorkDate}"> 
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 身份证号: </label> 
			<input type="text" id="userCode" name="userCode"  value="${eUserPage.userCode}" datatype="/(^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$)|(^[1-9]\d{5}\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{2}$)/" errormsg="身份证格式不正确" > 
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 通讯地址: </label> 
			<input type="text" id="userAdress" name="userAdress" datatype="*" value="${eUserPage.userAdress}" > 
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 邮箱:</label> 
			<input type="text" id="userEmail" name=userEmail datatype="e"  value="${eUserPage.userEmail}"> 
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 联系电话:</label> 
			<input type="text" id="userTel" name="userTel" datatype="*" value="${eUserPage.userTel}" > 
			<span class="Validform_checktip"></span>
		</div>
		<div style="text-align:center"><input class="btn" type="submit" value="提交" style="height:30px;width:100px !important;border-radius:5px"></div>
		
	</fieldset>
</t:formvalid>
</body>
</html>
<t:authFilter />