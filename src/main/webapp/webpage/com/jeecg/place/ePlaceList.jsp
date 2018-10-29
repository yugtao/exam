<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addEPlaceBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delEPlaceBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addEPlaceBtn').bind('click', function(){   
 		 var tr =  $("#add_ePlace_table_template tr").clone();
	 	 $("#add_ePlace_table").append(tr);
	 	 resetTrNum('add_ePlace_table');
	 	 return false;
    });  
	$('#delEPlaceBtn').bind('click', function(){   
		$("#add_ePlace_table").find("input[name$='ck']:checked").parent().parent().remove();  
        resetTrNum('add_ePlace_table'); 
        return false;
    }); 
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
			$(".datagrid-toolbar").hide();
		}
    });
</script>
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addEPlaceBtn" href="#">添加</a> <a id="delEPlaceBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="ePlace_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						考场名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						考场地址信息
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						考场容纳人数
				  </td>
	</tr>
	<tbody id="add_ePlace_table">
	<c:if test="${fn:length(ePlaceList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="ePlaceList[0].id" type="hidden"/>
					<input name="ePlaceList[0].examId" type="hidden"/>
					<input name="ePlaceList[0].pCreatby" type="hidden"/>
				  <td align="left">
					  	<input name="ePlaceList[0].pName" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">考场名称</label>
					</td>
				  <td align="left">
					  	<input name="ePlaceList[0].pInfo" maxlength="20" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">考场地址信息</label>
					</td>
				  <td align="left">
					  	<input name="ePlaceList[0].pCount" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">考场容纳人数</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(ePlaceList)  > 0 }">
		<c:forEach items="${ePlaceList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="ePlaceList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="ePlaceList[${stuts.index }].examId" type="hidden" value="${poVal.examId }"/>
						<input name="ePlaceList[${stuts.index }].pCreatby" type="hidden" value="${poVal.pCreatby }"/>
				   <td align="left">
					  	<input name="ePlaceList[${stuts.index }].pName" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.pName }"/>
					  <label class="Validform_label" style="display: none;">考场名称</label>
				   </td>
				   <td align="left">
					  	<input name="ePlaceList[${stuts.index }].pInfo" maxlength="20" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.pInfo }"/>
					  <label class="Validform_label" style="display: none;">考场地址信息</label>
				   </td>
				   <td align="left">
					  	<input name="ePlaceList[${stuts.index }].pCount" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.pCount }"/>
					  <label class="Validform_label" style="display: none;">考场容纳人数</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
