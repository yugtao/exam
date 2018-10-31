<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>考生信息报名审核表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="eStudentController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${eStudentPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							报名单位:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="sOrg" type="list"  dictTable="t_s_depart" dictField="id" dictText="departname"  defaultVal="${eStudentPage.sOrg}" hasLabel="false"  title="报名单位" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">报名单位</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							报名职业:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="sWork" type="list"  dictTable="e_work" dictField="id" dictText="w_name"  defaultVal="${eStudentPage.sWork}" hasLabel="false"  title="报名职业" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">报名职业</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							学员姓名:
						</label>
					</td>
					<td class="value">
					     	 <input id="sStudient" name="sStudient" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">学员姓名</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							学员性别:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="sSex" type="radio"  typeGroupCode="e_sex"  defaultVal="${eStudentPage.sSex}" hasLabel="false"  title="学员性别" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">学员性别</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							出生年月:
						</label>
					</td>
					<td class="value">
					     	 <input id="sBirthday" name="sBirthday" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">出生年月</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							民族:
						</label>
					</td>
					<td class="value">
					     	 <input id="sNation" name="sNation" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">民族</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							籍贯:
						</label>
					</td>
					<td class="value">
					     	 <input id="sJiguan" name="sJiguan" type="text" maxlength="100" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">籍贯</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							户口:
						</label>
					</td>
					<td class="value">
					     	 <input id="sHukou" name="sHukou" type="text" maxlength="100" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">户口</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							政治面貌:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="sPolitics" type="list"  typeGroupCode=""  defaultVal="${eStudentPage.sPolitics}" hasLabel="false"  title="政治面貌" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">政治面貌</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							学历:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="sEducation" type="list"  typeGroupCode="e_edu"  defaultVal="${eStudentPage.sEducation}" hasLabel="false"  title="学历" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">学历</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							学位:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="sDegree" type="list"  typeGroupCode="e_degree"  defaultVal="${eStudentPage.sDegree}" hasLabel="false"  title="学位" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">学位</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							毕业学校:
						</label>
					</td>
					<td class="value">
					     	 <input id="sSchool" name="sSchool" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">毕业学校</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							专业:
						</label>
					</td>
					<td class="value">
					     	 <input id="sMajor" name="sMajor" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">专业</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							毕业年月:
						</label>
					</td>
					<td class="value">
					     	 <input id="sGDate" name="sGDate" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">毕业年月</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							婚姻状况:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="sMarry" type="list"  typeGroupCode="e_marry"  defaultVal="${eStudentPage.sMarry}" hasLabel="false"  title="婚姻状况" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">婚姻状况</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							本人身份:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="sIndntity" type="list"  typeGroupCode="e_identity"  defaultVal="${eStudentPage.sIndntity}" hasLabel="false"  title="本人身份" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">本人身份</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							现工作单位:
						</label>
					</td>
					<td class="value">
					     	 <input id="sOrgNow" name="sOrgNow" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">现工作单位</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							现职务:
						</label>
					</td>
					<td class="value">
					     	 <input id="sJobNow" name="sJobNow" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">现职务</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							参加工作时间:
						</label>
					</td>
					<td class="value">
					     	 <input id="sWorkDate" name="sWorkDate" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">参加工作时间</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							身份证号:
						</label>
					</td>
					<td class="value">
					     	 <input id="sCode" name="sCode" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">身份证号</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							通讯地址:
						</label>
					</td>
					<td class="value">
					     	 <input id="sAdress" name="sAdress" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">通讯地址</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							联系电话:
						</label>
					</td>
					<td class="value">
					     	 <input id="sTel" name="sTel" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">联系电话</label>
						</td>
					</tr>
				
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							审核不通过原因:
						</label>
					</td>
					<td class="value"  colspan="3" >
								<script type="text/javascript"  charset="utf-8" src="plug-in/ueditor/ueditor.config.js"></script>
								<script type="text/javascript"  charset="utf-8" src="plug-in/ueditor/ueditor.all.min.js"></script>
						    	<textarea name="sReason" id="sReason" style="width: 650px;height:300px"></textarea>
							    <script type="text/javascript">
							        var sReason_editor = UE.getEditor('sReason');
							    </script>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">审核不通过原因</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
