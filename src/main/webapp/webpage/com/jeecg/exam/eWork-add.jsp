<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>职位表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="eWorkController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${eWorkPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							职位所属单位:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="wOrg" type="list" where description !='1'"  dictTable="t_s_depart" dictField="id" dictText="departname"  defaultVal="${eWorkPage.wOrg}" hasLabel="false"  title="职位所属单位" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">职位所属单位</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							职位名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="wName" name="wName" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">职位名称</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							计划招收人数:
						</label>
					</td>
					<td class="value">
					     	 <input id="wCount" name="wCount" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">计划招收人数</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							实际招收人数:
						</label>
					</td>
					<td class="value">
					     	 <input id="wRCount" name="wRCount" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">实际招收人数</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							解释:
						</label>
					</td>
					<td class="value">
					     	 <input id="wReason" name="wReason" type="text" maxlength="255" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">解释</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							职位状态:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="wStatus" type="list"  typeGroupCode="ew_status"  defaultVal="${eWorkPage.wStatus}" hasLabel="false"  title="职位状态" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">职位状态</label>
						</td>
				</tr>
				
				
			</table>
		</t:formvalid>
 </body>
