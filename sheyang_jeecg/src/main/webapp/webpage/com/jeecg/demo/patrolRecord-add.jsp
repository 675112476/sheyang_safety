<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>巡查记录</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  
  <script type="text/javascript">
	var inputdiv=document.getElementById("inputs");
	var inputhtml="";
	function getRisks(factory) {
		console.info(factory);
		$.ajax({
			url : "http://localhost:8090/getriskpoints",
			data : {
				"factory" : factory
			},
			async: false,
			dataType : "jsonp",
			complete : function(data) {
				//data = data.responseJSON;
				//data = eval('(' + data + ')');
				console.info(data);
				if(data.risks==null){
					console.info("风险点为空");
				}else{
					var risks=data.risks;
					console.info(risks);
					for(var i=0;i<risks.length;i++){
						inputhtml+="<input type='hidden' name='date' value='2018-11-14 00:00:00'/>"
						+"<input type='hidden' name='factory' value='射阳港龙凤烟花爆竹门市'/>"
						+"<input type='hidden' name='risk_point' value="+risks[i]+">"
						+"<div>风险点"+(i+1)+"："+risks[i]
						+"&nbsp&nbsp&nbsp<select name='is_control'>"   
				        +"<option value='可控'>可控</option> <option value='不可控'>不可控</option></select> </div><br/>";
					}
					inputhtml+="<input type='submit' value='保存'><br><br>"
					console.info(inputhtml);
					inputdiv.innerHTML=inputhtml;
				}
			}
		});
	}
	function getCountry() {
		$.ajax({
			url : "http://localhost:8090/getCountry",
			dataType : "jsonp",
			complete : function(data) {
				console.info(data);
			}
		});
	}
	//getRisks("射阳港龙凤烟花爆竹门市");
	getCountry();
</script>	
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="patrolRecordController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${patrolRecordPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							巡查员姓名:
						</label>
					</td>
					<td class="value">
							<input id="patrolName" name="patrolName" type="text" style="width: 150px" class="searchbox-inputtext"  datatype="*" ignore="checked"   onclick="popupClick(this,'realname,telephone','patrolName,telephone','xunchayuan')"  />
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
					     	 <input id="telephone" name="telephone" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="m" ignore="ignore" />
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
							   <input id="time" name="time" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  datatype="*" ignore="checked" />    
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
							<input id="factoryName" name="factoryName" type="text" style="width: 150px" class="searchbox-inputtext"  datatype="*" ignore="checked"   onclick="popupClick(this,'factory','factoryName','patrol_factory')"  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">巡查公司</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							风险点是否可控:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="iscontrol" type="radio"  datatype="*"  typeGroupCode="yes_or_no"  defaultVal="${patrolRecordPage.iscontrol}" hasLabel="false"  title="风险点是否可控" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">风险点是否可控</label>
							<button onclick="window.location.href='patrolRecordController.do?index'">Continue</button>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							具体地址:
						</label>
					</td>
					<td class="value">
					     	 <input id="location" name="location" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
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
						  	 <textarea style="height:auto;width:95%" class="inputxt" rows="6" id="record" name="record"  datatype="*"  ignore="checked" ></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">整改措施</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
 <script src = "webpage/com/jeecg/demo/patrolRecord.js"></script>	
  		
