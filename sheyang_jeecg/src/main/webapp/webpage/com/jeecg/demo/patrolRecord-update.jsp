<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>巡查记录</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //取jsonArray的长度
   function getJsonLength(jsonData){
	    var jsonLength = 0;
	    for(var item in jsonData){
	       jsonLength++;
	    }
	    return jsonLength;
	}
//http://localhost:8090/getrisks?date=2018-11-02&factory=碧蓝宾馆&patrol_person=21
	var inputhtml="";
	$(document).ready(function(){
		$.ajax({
			url : "http://218.92.240.39:6390/getrisks",
			//url : "http://localhost:8090/getrisks",
			type: "GET",
			data:{
				"date":$("#time").val(),
				"factory":$("#factoryName").val(),
				"patrol_person":$("#patrolName").val()
			},
			timeout : 1000, 
			processData: true,
			dataType : "jsonp",
			success : function(data) {
				if(data[0].result==0){
					for(var i=1;i<getJsonLength(data);i++){
						inputhtml+=data[i].riskpoint+":"+data[i].iscontrol+"<br/>";
					}
				}else{
					
				}
				console.info(inputhtml);
				$("#inputs").html(inputhtml);
			}
		});
		
	});
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="patrolRecordController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${patrolRecordPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								巡查员姓名:
							</label>
						</td>
						<td class="value">
							<input id="patrolName" name="patrolName" type="text" style="width: 150px" class="searchbox-inputtext"  datatype="*" ignore="checked"  onclick="popupClick(this,'realname,telephone','patrolName,telephone','xunchayuan')" value='${patrolRecordPage.patrolName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">巡查员姓名</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								巡查员电话:
							</label>
						</td>
						<td class="value">
						    <input id="telephone" name="telephone" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="m" ignore="ignore"  value='${patrolRecordPage.telephone}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">巡查员电话</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								巡查时间:
							</label>
						</td>
						<td class="value">
									  <input id="time" name="time" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  datatype="*" ignore="checked" value='<fmt:formatDate value='${patrolRecordPage.time}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">巡查时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								巡查单位:
							</label>
						</td>
						<td class="value">
							<input id="factoryName" name="factoryName" type="text" style="width: 150px" class="searchbox-inputtext"  datatype="*" ignore="checked"  onclick="popupClick(this,'factory_name','factoryName','factory')" value='${patrolRecordPage.factoryName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">巡查单位</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								具体地址:
							</label>
						</td>
						<td class="value">
						    <input id="location" name="location" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${patrolRecordPage.location}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">具体地址</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								风险点是否可控:
							</label>
						</td>
						<td class="value">
								<t:dictSelect id="iscontrol" field="iscontrol" type="radio"  datatype="*"  typeGroupCode="yes_or_no"  defaultVal="${patrolRecordPage.iscontrol}" hasLabel="false"  title="风险点是否可控" ></t:dictSelect>     
								<span class="Validform_checktip"></span>
								<label class="Validform_label" style="display: none;">风险点是否可控</label>
								<div id="inputs"></div>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								不可控原因:
							</label>
						</td>
						<td class="value" >
						  	 	<textarea id="riskReason" style="height:auto;width:95%;" class="inputxt" rows="6" name="riskReason"  ignore="ignore" >${patrolRecordPage.riskReason}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">不可控原因</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								整改措施:
							</label>
						</td>
						<td class="value" >
						  	 	<textarea id="record" style="height:auto;width:95%;" class="inputxt" rows="6" name="record"  ignore="ignore" >${patrolRecordPage.record}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">整改措施</label>
						</td>
					</tr>
					
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/demo/patrolRecord.js"></script>		
