<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>行业</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <style type="text/css">
  	.combo_self{height: 22px !important;width: 150px !important;}
  	.layout-header .btn {
	    margin:0;
	   float: none !important;
	}
	.btn-default {
	    height: 35px;
	    line-height: 35px;
	    font-size:14px;
	}
  </style>
  
  <script type="text/javascript">
	$(function(){
		$(".combo").removeClass("combo").addClass("combo combo_self");
		$(".combo").each(function(){
			$(this).parent().css("line-height","0px");
		});   
	});
  		
  		 /**树形列表数据转换**/
  function convertTreeData(rows, textField) {
      for(var i = 0; i < rows.length; i++) {
          var row = rows[i];
          row.text = row[textField];
          if(row.children) {
          	row.state = "open";
              convertTreeData(row.children, textField);
          }
      }
  }
  /**树形列表加入子元素**/
  function joinTreeChildren(arr1, arr2) {
      for(var i = 0; i < arr1.length; i++) {
          var row1 = arr1[i];
          for(var j = 0; j < arr2.length; j++) {
              if(row1.id == arr2[j].id) {
                  var children = arr2[j].children;
                  if(children) {
                      row1.children = children;
                  }
                  
              }
          }
      }
  }
  </script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="industryController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${industryPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								行业名称:
							</label>
						</td>
						<td class="value">
						    <input id="industryName" name="industryName" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="*" ignore="ignore"  value='${industryPage.industryName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">行业名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								分管县长名称:
							</label>
						</td>
						<td class="value">
							<input id="industryFenguan" name="industryFenguan" type="text" style="width: 150px" class="searchbox-inputtext"  datatype="*" ignore="ignore"  onclick="popupClick(this,'leader_name','industryFenguan','fenguan')" value='${industryPage.industryFenguan}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">分管县长名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								局长名称:
							</label>
						</td>
						<td class="value">
							<input id="industryJuzhang" name="industryJuzhang" type="text" style="width: 150px" class="searchbox-inputtext"  datatype="*" ignore="ignore"  onclick="popupClick(this,'leader_name','industryJuzhang','juzhang')" value='${industryPage.industryJuzhang}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">局长名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								父节点:
							</label>
						</td>
						<td class="value">
							<input id="parentId" name="parentId" type="text" style="width: 150px" class="inputxt easyui-combotree"  ignore="ignore" 
							value='${industryPage.parentId}'
							data-options="
				                    panelHeight:'220',
				                    url: 'industryController.do?datagrid&field=id,industryName',  
				                    loadFilter: function(data) {
				                    	var rows = data.rows || data;
				                    	var win = frameElement.api.opener;
				                    	var listRows = win.getDataGrid().treegrid('getData');
				                    	joinTreeChildren(rows, listRows);
				                    	convertTreeData(rows, 'industryName');
				                    	return rows; 
				                    },
				                    onSelect:function(node){
				                    	$('#parentId').val(node.id);
				                    },
				                    onLoadSuccess: function() {
				                    	var win = frameElement.api.opener;
				                    	var currRow = win.getDataGrid().treegrid('getSelected');
				                    	if(!'${industryPage.id}') {
				                    		//增加时，选择当前父菜单
				                    		if(currRow) {
				                    			$('#parentId').combotree('setValue', currRow.id);
				                    		}
				                    	}else {
				                    		//编辑时，选择当前父菜单
				                    		if(currRow) {
				                    			$('#parentId').combotree('setValue', currRow.parentId);
				                    		}
				                    	}
				                    }
				            "
							>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">父节点</label>
						</td>
					</tr>
				
					<tr>
						<td align="right">
							<label class="Validform_label">
								行业简介:
							</label>
						</td>
						<td class="value" >
						  	 	<textarea id="industryIntroduction" style="height:auto;width:95%;" class="inputxt" rows="6" name="industryIntroduction"  ignore="ignore" >${industryPage.industryIntroduction}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">行业简介</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/demo/industry.js"></script>		
