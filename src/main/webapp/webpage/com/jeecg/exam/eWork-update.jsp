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
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="eWorkController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${eWorkPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								职位所属单位:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="wOrg" type="list"  dictTable="t_s_depart" dictField="id" dictText="departname"   defaultVal="${eWorkPage.wOrg}" hasLabel="false"  title="职位所属单位" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">职位所属单位</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								岗位名称:
							</label>
						</td>
						<td class="value">
						    <input id="wName" name="wName" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore"  value='${eWorkPage.wName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">岗位名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								岗位类别:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="wType" type="list"  typeGroupCode="e_wtype"   defaultVal="${eWorkPage.wType}" hasLabel="false"  title="岗位类别" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">岗位类别</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								招聘人数:
							</label>
						</td>
						<td class="value">
						    <input id="wCount" name="wCount" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore"  value='${eWorkPage.wCount}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">招聘人数</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								报名人数:
							</label>
						</td>
						<td class="value">
						    <input id="wBCount" name="wBCount" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${eWorkPage.wBCount}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">报名人数</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								学历要求:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="wAskEducation" type="list"  typeGroupCode="e_edu"   defaultVal="${eWorkPage.wAskEducation}" hasLabel="false"  title="学历要求" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">学历要求</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								学位要求:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="wAskDegree" type="list"  typeGroupCode="e_degree"   defaultVal="${eWorkPage.wAskDegree}" hasLabel="false"  title="学位要求" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">学位要求</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								专业:
							</label>
						</td>
						<td class="value">
						    <input id="wAskMajor" name="wAskMajor" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${eWorkPage.wAskMajor}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">专业</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								年龄:
							</label>
						</td>
						<td class="value">
						    <input id="wAskAge" name="wAskAge" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${eWorkPage.wAskAge}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">年龄</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								职称:
							</label>
						</td>
						<td class="value">
						    <input id="wAskTitle" name="wAskTitle" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${eWorkPage.wAskTitle}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">职称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								其他要求:
							</label>
						</td>
						<td class="value">
						    <input id="wAskOther" name="wAskOther" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${eWorkPage.wAskOther}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">其他要求</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								资格审查通过人数:
							</label>
						</td>
						<td class="value">
						    <input id="wPassCount" name="wPassCount" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${eWorkPage.wPassCount}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">资格审查通过人数</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								未通过人数:
							</label>
						</td>
						<td class="value">
						    <input id="wPassNot" name="wPassNot" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${eWorkPage.wPassNot}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">未通过人数</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								职位状态:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="wStatus" type="list"  typeGroupCode="ew_status"   defaultVal="${eWorkPage.wStatus}" hasLabel="false"  title="职位状态" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">职位状态</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								笔试人数:
							</label>
						</td>
						<td class="value">
						    <input id="wWriCount" name="wWriCount" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${eWorkPage.wWriCount}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">笔试人数</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								笔试开考比例:
							</label>
						</td>
						<td class="value">
						    <input id="wWriPro" name="wWriPro" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${eWorkPage.wWriPro}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">笔试开考比例</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								面试人数:
							</label>
						</td>
						<td class="value">
						    <input id="wIntCount" name="wIntCount" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${eWorkPage.wIntCount}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">面试人数</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								面试开考比例:
							</label>
						</td>
						<td class="value">
						    <input id="wIntPro" name="wIntPro" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${eWorkPage.wIntPro}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">面试开考比例</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								实际招收人数:
							</label>
						</td>
						<td class="value">
						    <input id="wRCount" name="wRCount" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore"  value='${eWorkPage.wRCount}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">实际招收人数</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								解释:
							</label>
						</td>
						<td class="value">
						    <input id="wReason" name="wReason" type="text" maxlength="255" style="width: 150px" class="inputxt"  ignore="ignore"  value='${eWorkPage.wReason}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">解释</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								职业所属考试:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="wExam" type="list"  dictTable="e_exam" dictField="id" dictText="e_name"   defaultVal="${eWorkPage.wExam}" hasLabel="false"  title="职业所属考试" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">职业所属考试</label>
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
