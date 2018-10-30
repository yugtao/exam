<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>考试表</title>
    <style>
  .ui-button {
  	  display: inline-block;
	  padding: 2px 2px;
	  margin-bottom: 0;
	  font-size: 8px;
	  font-weight: normal;
	  line-height: 1.42857143;
	  text-align: center;
	  white-space: nowrap;
	  vertical-align: middle;
	  -ms-touch-action: manipulation;
      touch-action: manipulation;
	  cursor: pointer;
	  -webkit-user-select: none;
      -moz-user-select: none;
      -ms-user-select: none;
      user-select: none;
	  background-image: none;
	  border: 1px solid transparent;
	  border-radius: 4px;
  }
  </style>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  $(document).ready(function(){
	$('#tt').tabs({
	   onSelect:function(title){
	       $('#tt .panel-body').css('width','auto');
		}
	});
	$(".tabs-wrap").css('width','100%');
  });
 </script>
 </head>
 <body style="overflow-x: hidden;">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="eExamController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${eExamPage.id }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">考试名称:</label>
			</td>
			<td class="value">
		     	 <input id="eName" name="eName" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore"  value='${eExamPage.eName}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">考试名称</label>
			</td>
			<td align="right">
				<label class="Validform_label">考试状态:</label>
			</td>
			<td class="value">
					<t:dictSelect field="eStatus" type="list"   typeGroupCode="ea_status"  defaultVal="${eExamPage.eStatus}" hasLabel="false"  title="考试状态"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">考试状态</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">考试信息:</label>
			</td>
			<td class="value">
		     	 <input id="eInfo" name="eInfo" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore"  value='${eExamPage.eInfo}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">考试信息</label>
			</td>
			<td align="right">
				<label class="Validform_label">考试时间:</label>
			</td>
			<td class="value">
					  <input id="eDate" name="eDate" type="text" style="width: 150px"   ignore="ignore"  value='<fmt:formatDate value='${eExamPage.eDate}' type="date" pattern="yyyy-MM-dd"/>'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">考试时间</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">考试人数:</label>
			</td>
			<td class="value">
		     	 <input id="eCount" name="eCount" type="text" maxlength="20" style="width: 150px" class="inputxt"  ignore="ignore"  value='${eExamPage.eCount}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">考试人数</label>
			</td>
		</tr>
	
			</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="eExamController.do?ePlaceList&id=${eExamPage.id}" icon="icon-search" title="考场管理" id="ePlace"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
		<table style="display:none">
		<tbody id="add_ePlace_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  		<input name="ePlaceList[#index#].pName" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">考场名称</label>
				  </td>
				  <td align="left">
					  		<input name="ePlaceList[#index#].pInfo" maxlength="20" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">考场地址信息</label>
				  </td>
				  <td align="left">
					  		<input name="ePlaceList[#index#].pCount" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">考场容纳人数</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/jeecg/exam/eExam.js"></script>	
