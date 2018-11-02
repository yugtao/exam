<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>准考证表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="eProveController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${eProvePage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							考生名:
						</label>
					</td>
					<td class="value">
					     	 <input id="proveStuName" name="proveStuName" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">考生名</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							身份证号:
						</label>
					</td>
					<td class="value">
					     	 <input id="proveCardCode" name="proveCardCode" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">身份证号</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							报考单位:
						</label>
					</td>
					<td class="value">
					     	 <input id="proveOrg" name="proveOrg" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">报考单位</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							报考职业:
						</label>
					</td>
					<td class="value">
					     	 <input id="proveWork" name="proveWork" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">报考职业</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							准考证号:
						</label>
					</td>
					<td class="value">
					     	 <input id="proveCode" name="proveCode" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">准考证号</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							考场地址:
						</label>
					</td>
					<td class="value">
					     	 <input id="provePlace" name="provePlace" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">考场地址</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							座位信息:
						</label>
					</td>
					<td class="value">
					     	 <input id="proveSeat" name="proveSeat" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">座位信息</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							考生id:
						</label>
					</td>
					<td class="value">
					     	 <input id="proveStuId" name="proveStuId" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">考生id</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							考生账户id:
						</label>
					</td>
					<td class="value">
					     	 <input id="proveUserId" name="proveUserId" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">考生账户id</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							考试id:
						</label>
					</td>
					<td class="value">
					     	 <input id="proveExamId" name="proveExamId" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">考试id</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							考试名:
						</label>
					</td>
					<td class="value">
					     	 <input id="proveExamName" name="proveExamName" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">考试名</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							考试时间:
						</label>
					</td>
					<td class="value">
					     	 <input id="proveDate" name="proveDate" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">考试时间</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							考场:
						</label>
					</td>
					<td class="value">
					     	 <input id="proveRoom" name="proveRoom" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">考场</label>
						</td>
				<td align="right">
					<label class="Validform_label">
					</label>
				</td>
				<td class="value">
				</td>
					</tr>
				
				
			</table>
		</t:formvalid>
 </body>
