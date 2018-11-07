<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>注册用户信息表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="eUserController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${eUserPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							学历:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="userEducation" type="list"  typeGroupCode="e_edu"  defaultVal="${eUserPage.userEducation}" hasLabel="false"  title="学历" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">学历</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							学位:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="userDegree" type="list"  typeGroupCode="e_degree"  defaultVal="${eUserPage.userDegree}" hasLabel="false"  title="学位" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">学位</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							毕业学校:
						</label>
					</td>
					<td class="value">
					     	 <input id="userSchool" name="userSchool" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">毕业学校</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							专业:
						</label>
					</td>
					<td class="value">
					     	 <input id="userMajor" name="userMajor" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">专业</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							毕业年月:
						</label>
					</td>
					<td class="value">
					     	 <input id="userGDate" name="userGDate" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">毕业年月</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							婚姻状况:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="userMarry" type="radio"  typeGroupCode="e_marry"  defaultVal="${eUserPage.userMarry}" hasLabel="false"  title="婚姻状况" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">婚姻状况</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							本人身份:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="userIndntity" type="list"  typeGroupCode="e_identity"  defaultVal="${eUserPage.userIndntity}" hasLabel="false"  title="本人身份" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">本人身份</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							参加工作时间:
						</label>
					</td>
					<td class="value">
					     	 <input id="userWorkDate" name="userWorkDate" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">参加工作时间</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							身份证号码:
						</label>
					</td>
					<td class="value">
					     	 <input id="userCode" name="userCode" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">身份证号码</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							联系地址:
						</label>
					</td>
					<td class="value">
					     	 <input id="userAdress" name="userAdress" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">联系地址</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							电话:
						</label>
					</td>
					<td class="value">
					     	 <input id="userTel" name="userTel" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">电话</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							邮箱:
						</label>
					</td>
					<td class="value">
					     	 <input id="userEmail" name="userEmail" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">邮箱</label>
						</td>
					</tr>
				
				
			</table>
		</t:formvalid>
 </body>
