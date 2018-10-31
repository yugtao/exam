<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>考试表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="eExamController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${eExamPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							考试名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="eName" name="eName" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">考试名称</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							考试状态:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="eStatus" type="list"  typeGroupCode="ea_status"  defaultVal="${eExamPage.eStatus}" hasLabel="false"  title="考试状态" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">考试状态</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							考试信息:
						</label>
					</td>
					<td class="value">
					     	 <input id="eInfo" name="eInfo" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">考试信息</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							考试时间:
						</label>
					</td>
					<td class="value">
							   <input id="eDate" name="eDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">考试时间</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							考试人数:
						</label>
					</td>
					<td class="value">
					     	 <input id="eCount" name="eCount" type="text" maxlength="20" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">考试人数</label>
						</td>
				</tr>
				
				
			</table>
		</t:formvalid>
 </body>
