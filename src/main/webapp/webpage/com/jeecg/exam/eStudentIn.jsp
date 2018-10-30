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
        	 alert("表单提交前想干点啥呢");
          }
          function test(){
        	  alert("表单提交后要干点啥呢");
          }

  </SCRIPT>
  </head>
  <body>
<t:formvalid formid="formobj" dialog="false" layout="div" callback="test" action="eStudentController.do?doAdd" beforeSubmit="setContentc">
	 <fieldset class="step" style="padding-bottom: 20px;">
	 <legend>考生信息填写</legend>
		<div class="form">
			<label class="Validform_label"> 报名单位: </label> 
			<t:dictSelect field="sOrg" type="list"  dictTable="t_s_depart" dictField="id" dictText="departname" datatype="*"  defaultVal="${eStudentPage.sOrg}" hasLabel="false"  title="报名单位" ></t:dictSelect>
			<span class="Validform_checktip"></span>
		</div>
		
		<div class="form">
			<label class="Validform_label"> 报名职业: </label> 
			<t:dictSelect field="sWork" type="list"  dictTable="e_work" dictField="id" dictText="w_name" datatype="*" defaultVal="${eStudentPage.sWork}" hasLabel="false"  title="报名职业" ></t:dictSelect>  
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 学员姓名: </label> 
			<input id="sStudient" name="sStudient" type="text" datatype="*" />
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 学员性别: </label> 
			 <t:dictSelect field="sSex" type="radio"  typeGroupCode="e_sex"  defaultVal="${eStudentPage.sSex}" datatype="*" hasLabel="false"  title="学员性别" ></t:dictSelect>  
		    <span class="Validform_checktip"></span>
		</div>
		  
		<div class="form">
			<label class="Validform_label"> 出生年月： </label> 
			<input type="text" id="sBirthday" name="sBirthday" datatype="*"  > 
			<span class="Validform_checktip"></span>
		</div>
		
		<div class="form">
			<label class="Validform_label"> 民族： </label> 
			<input type="text" id="sNation" name="sNation" datatype="*"  > 
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 籍贯： </label> 
			<input type="text" id="sJiguan" name="sJiguan" datatype="*"  > 
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 户口所在地： </label> 
			<input type="text" id="sHukou" name="sHukou" datatype="*"  > 
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 政治面貌： </label> 
			<t:dictSelect field="sPolitics" type="list"  typeGroupCode="e_politics"  defaultVal="${eStudentPage.sPolitics}" hasLabel="false"  title="政治面貌"  datatype="*" ></t:dictSelect>
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 学历: </label> 
			<t:dictSelect field="sEducation" type="list"  typeGroupCode="e_edu"  defaultVal="${eStudentPage.sEducation}" hasLabel="false"  title="学历" datatype="*"></t:dictSelect>
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 学位: </label> 
			
			<t:dictSelect field="sDegree" type="list"  typeGroupCode="e_degree"  defaultVal="${eStudentPage.sDegree}" hasLabel="false"  title="学位" datatype="*"></t:dictSelect>
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 毕业学校: </label> 
			<input type="text" id="sSchool" name="sSchool" datatype="*"  > 
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 专业: </label> 
			<input type="text" id="sMajor" name="sMajor" datatype="*"  > 
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 毕业年月: </label> 
			<input type="text" id="sGDate" name="sGDate" datatype="*"  > 
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 婚姻状况: </label> 
			<t:dictSelect field="sMarry" type="list"  typeGroupCode="e_marry" datatype="*" defaultVal="${eStudentPage.sMarry}" hasLabel="false"  title="婚姻状况" ></t:dictSelect>
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 本人身份: </label> 
			  <t:dictSelect field="sIndntity" type="list"  typeGroupCode="e_identity" datatype="*" defaultVal="${eStudentPage.sIndntity}" hasLabel="false"  title="本人身份" ></t:dictSelect>
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
			<input type="text" id="sWorkDate" name="sWorkDate" datatype="*"  > 
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 身份证号:： </label> 
			<input type="text" id="sCode" name="sCode" datatype="*"  > 
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 通讯地址: </label> 
			<input type="text" id="sAdress" name="sAdress" datatype="*"  > 
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 联系电话:</label> 
			<input type="text" id="sTel" name="sTel" datatype="*"  > 
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 笔试成绩: </label> 
			<input type="text" name="sWrittenScore" id="sWrittenScore" datatype="*"  > 
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 面试成绩: </label> 
			<input type="text" name="sInterviewScore" id="sInterviewScore" datatype="*"  > 
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 总成绩: </label> 
			<input type="text" name="sTotalScore" id="sTotalScore" datatype="*"  > 
			<span class="Validform_checktip"></span>
		</div>
		<div class="form">
			<label class="Validform_label"> 排名: </label> 
			<input type="text" name="sRank" id="sRank" datatype="*"  > 
			<span class="Validform_checktip"></span>
		</div>
		<div style="text-align:center"><input class="btn" type="submit" value="提交" style="height:30px;width:100px !important;border-radius:5px"></div>
		
	</fieldset>
</t:formvalid>
</body>
</html>
<t:authFilter />