<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="eExamList" checkbox="true" fitColumns="true" title="考试表" sortName="id" extendParams="view: detailview,detailFormatter:detailFormatterFun,onExpandRow: onExpandRowFun" actionUrl="eExamController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single"  dictionary="bpm_status"  width="120"></t:dgCol>
   <t:dgCol title="创建人id"  field="eCreateId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="考试名称"  field="eName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="考试状态"  field="eStatus"  queryMode="single"  dictionary="ea_status"  width="120"></t:dgCol>
   <t:dgCol title="考试信息"  field="eInfo"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="考试时间"  field="eDate"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="考试人数"  field="eCount"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="eExamController.do?doDel&id={id}"  urlclass="ace_button" urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="eExamController.do?goAdd" funname="add" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="eExamController.do?goUpdate" funname="update" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="eExamController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="eExamController.do?goUpdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src="plug-in/easyui/extends/datagrid-detailview.js"></script>
 <script type="text/javascript">
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'eExamController.do?upload', "eExamList");
}

//导出
function ExportXls() {
	JeecgExcelExport("eExamController.do?exportXls","eExamList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("eExamController.do?exportXlsByT","eExamList");
}
//返回行明细内容的格式化函数。
function detailFormatterFun() {
    var s = '<div class="placeInfoHidden" style="padding:2px;">' 
   		+ '		<div class="easyui-tabs" style="height:230px;width:800px;">' 
   		+ '			<div title="订单明细" style="padding:2px;">' 
   		+ '				<table class="jfrom_place_linetablelines" ></table>' 
   		+ '			</div>' 
   		+ '		</div>' 
   		+ '	</div>';
    return s;
}
//当展开一行时触发 
function onExpandRowFun(index, row) {
	//把加上的子表tabs和datagrid初始化
    var tabs = $(this).datagrid('getRowDetail', index).find('div.easyui-tabs');
    tabs.tabs();
    var jfrom_place_linetablelines = $(this).datagrid('getRowDetail', index).find('table.jfrom_place_linetablelines');
    var jfrom_place_linedurl = 'eExamController.do?eplaceDatagrid&field=pName,pInfo,pCount&examId=' + row.id;
    jfrom_place_linetablelines.datagrid({
        singleSelect: true,
        loadMsg: '正在加载',
        fitColumns: true,
        height: '180',
        pageSize: 50,
        pageList: [50, 150, 200, 250, 300],
        border: false,
        url: jfrom_place_linedurl,
        idField: 'id',
        rownumbers: true,
        pagination: true,
        columns: [[{
            title: '考场名称',
            field: 'pName',
            align: 'left',
            width: 50
        },
        {
            title: '考场信息',
            field: 'pInfo',
            align: 'left',
            width: 50
        },
        {
            title: '容纳人数',
            field: 'pInfo',
            align: 'left',
            width: 50
        }]]
    });
}
 </script>
