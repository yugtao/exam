<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>考场表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="ePlaceController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${ePlacePage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								所属考试:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="examId" type="list"  dictTable="e_exam" dictField="id" dictText="e_name"   defaultVal="${ePlacePage.examId}" hasLabel="false"  title="所属考试" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">所属考试</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								考场名称:
							</label>
						</td>
						<td class="value">
						    <input id="pName" name="pName" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${ePlacePage.PName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">考场名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								考场地址信息:
							</label>
						</td>
						<td class="value">
						    <input id="pInfo" name="pInfo" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${ePlacePage.PInfo}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">考场地址信息</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								考场容纳人数:
							</label>
						</td>
						<td class="value">
						    <input id="pCount" name="pCount" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${ePlacePage.PCount}' datatype="n"  errormsg="请输入数字"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">考场容纳人数</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
