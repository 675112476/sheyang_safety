<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>巡查记录</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
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
								巡查公司:
							</label>
						</td>
						<td class="value">
							<input id="factoryName" name="factoryName" type="text" style="width: 150px" class="searchbox-inputtext"  datatype="*" ignore="checked"  onclick="popupClick(this,'factory','factoryName','patrol_factory')" value='${patrolRecordPage.factoryName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">巡查公司</label>
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
								整改措施:
							</label>
						</td>
						<td class="value" >
						  	 	<textarea id="record" style="height:auto;width:95%;" class="inputxt" rows="6" name="record"  datatype="*"  ignore="checked" >${patrolRecordPage.record}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">整改措施</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/demo/patrolRecord.js"></script>		
