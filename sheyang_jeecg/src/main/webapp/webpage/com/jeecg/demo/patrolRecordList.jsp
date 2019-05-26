<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="patrolRecordList" checkbox="false" pagination="true" fitColumns="true" title="巡查记录" sortName="createDate" actionUrl="patrolRecordController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single"  dictionary="bpm_status"  width="120"></t:dgCol>
   <t:dgCol title="巡查员姓名"  field="patrolName"  query="true"  queryMode="single"  dictionary="xunchayuan,patrolName@telephone,realname@telephone"  popup="true"  width="120"></t:dgCol>
   <t:dgCol title="巡查员电话"  field="telephone"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="巡查时间"  field="time"  formatter="yyyy-MM-dd"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="巡查单位"  field="factoryName"  queryMode="single"  dictionary="factory,factoryName,factory_name"  popup="true"  width="120"></t:dgCol>
   <t:dgCol title="整改措施"  field="record"  queryMode="single"  width="350"></t:dgCol>
   <t:dgCol title="风险点是否可控"  field="iscontrol"  query="true"  queryMode="single"  dictionary="yes_or_no"  width="120"></t:dgCol>
   <t:dgCol title="具体地址"  field="location"  queryMode="single"  width="180"></t:dgCol>
   <t:dgCol title="不可控原因"  field="riskReason"  queryMode="single"  width="350"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
	<t:dgDelOpt title="删除" url="patrolRecordController.do?doDel&id={id}"
		urlclass="ace_button" urlfont="fa-trash-o" />
	<t:dgToolBar title="录入" icon="icon-add"
		url="patrolRecordController.do?goAdd" funname="add"></t:dgToolBar>
	<t:dgToolBar title="批量删除" icon="icon-remove"
		url="patrolRecordController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
	<t:dgToolBar title="查看" icon="icon-search"
		url="patrolRecordController.do?goUpdate" funname="detail"></t:dgToolBar>
	<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
	<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
	<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
	<t:dgToolBar title="危险点详情查询" icon="icon-putout" url="patrolRecordController.do?patrolSearch"  funname="createwindowoktext"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/demo/patrolRecordList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'patrolRecordController.do?upload', "patrolRecordList");
}

//导出
function ExportXls() {
	JeecgExcelExport("patrolRecordController.do?exportXls","patrolRecordList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("patrolRecordController.do?exportXlsByT","patrolRecordList");
}
function createwindowoktext(title, addurl, width, height) {
	if(width=="100%" || height=="100%"){
		width = window.top.document.body.offsetWidth;
		height =window.top.document.body.offsetHeight-100;
	}else{
		width = isRealNum(width)?width:700;
		height = isRealNum(height)?height:400;
		width=parseInt(width);
		height=parseInt(height);
	}
	$.dialog({
		content: 'url:'+addurl,
		zIndex: getzIndex(),
		lock : true,
		width:width,
		height: height,
		title:title,
		opacity : 0.3,
		cache:false, 
		okVal: $.i18n.prop('dialog.submit'),
		cancelVal: $.i18n.prop('dialog.close'),
		cancel: true /*为true等价于function(){}*/
	});
}
 </script>