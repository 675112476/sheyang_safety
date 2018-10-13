<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="industryList" checkbox="true" pagination="true" treegrid="true" treeField="industryName" fitColumns="true" title="行业" sortName="createDate" actionUrl="industryController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="行业名称"  field="industryName"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="分管县长名称"  field="industryFenguan"  queryMode="group"  dictionary="fenguan,industryFenguan,leader_name"  popup="true"  width="120"></t:dgCol>
   <t:dgCol title="局长名称"  field="industryJuzhang"  queryMode="single"  dictionary="juzhang,industryJuzhang,leader_name"  popup="true"  width="120"></t:dgCol>
   <t:dgCol title="行业简介"  field="industryIntroduction"  queryMode="group"  width="200"></t:dgCol>
   <t:dgCol title="父节点"  field="parentId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="industryController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="industryController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="industryController.do?goUpdate" funname="updatetree" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="industryController.do?doBatchDel" funname="deleteALLSelecttree"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="industryController.do?goUpdate" funname="detailtree" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/demo/industryList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
		$("#industryList").treegrid({
 				 onExpand : function(row){
 					var children = $("#industryList").treegrid('getChildren',row.id);
 					 if(children.length<=0){
 					 	row.leaf=true;
 					 	$("#industryList").treegrid('refresh', row.id);
 					 }
 				}
 		});
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'industryController.do?upload', "industryList");
}

//导出
function ExportXls() {
	JeecgExcelExport("industryController.do?exportXls","industryList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("industryController.do?exportXlsByT","industryList");
}

/**
 * 获取表格对象
 * @return 表格对象
 */
function getDataGrid(){
	var datagrid = $('#'+gridname);
	return datagrid;
}
 </script>