<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>巡查记录</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  var risks;
  	function submitPoints(){
  		var factory=$("#factoryName").val();
		var time=$("#time").val();
		var person_name=$("#patrolName").val();
  		var sub_data="?";
  		for(var i=0;i<risks.length;i++){
  			var is_control=$("#is_control_"+i).val();
  			sub_data+="date="+time+"&patrol_person="+person_name+"&factory="+factory+"&risk_point="+risks[i]+"&is_control="+is_control+"&";
  		}
  		$.ajax({
  			url : "http://218.92.240.39:6390/insertrisks"+sub_data,
  			//url : "http://localhost:8090/insertrisks"+sub_data,
  			type: "GET",
  			timeout : 1000, 
  			processData: true,
  			dataType : "jsonp",
  			success : function(data) {
  				if(data=="1"){
  					alert("风险点情况保存成功");
  				}else{
  					console.info(data);
  					alert("风险点保存失败");
  				}
  			}
  		});
  	}
  	function getRisks(){
		var inputhtml="";
		if($("#patrolName").val()==""||$("#factoryName").val()==""||$("#time").val()==""){
			alert("请输入巡查员名称、单位名称、时间");
			$("[id=iscontrol]").prop('checked',false);
		}else{
			var factory=$("#factoryName").val();
			var time=$("#time").val();
			
			$.ajax({
				url : "http://218.92.240.39:6390/getriskpoints",
				//url : "http://localhost:8090/getriskpoints",
				data : {
					"factory" : factory
				},
				timeout : 1000, 
				async: false,
				dataType : "jsonp",
				success : function(data) {
					console.info(data);
					if(data.risks==null){
						alert("单位查无危险点，请确认巡查单位是否输入错误！");
						$("[id=iscontrol]").prop('checked',false);
					}else{
						risks=data.risks;
						console.info(risks);
						for(var i=0;i<risks.length;i++){
							inputhtml+="<input type='hidden' name='date' value="+time+">"
							+"<input type='hidden' name='factory' value="+factory+">"
							+"<input type='hidden' name='risk_point' value="+risks[i]+">"
							+"<div>风险点"+(i+1)+"："+risks[i]
							+"&nbsp&nbsp&nbsp<select id='is_control_"+i+"'>"   
					        +"<option value='不可控'>不可控</option><option value='可控'>可控</option> </select> </div><br/>";
						}
						inputhtml+="<button type='button' id='point_submit' onclick='submitPoints();'>保存</button><br><br>";
						console.info(inputhtml);
						$("#inputs").html(inputhtml);
					}
				}
			});
		}
		
	}
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
							巡查单位:
						</label>
					</td>
					<td class="value">
							<input id="factoryName" name="factoryName" type="text" style="width: 150px" class="searchbox-inputtext"  datatype="*" ignore="checked"   onclick="popupClick(this,'factory_name','factoryName','factory')"  />
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
					     	 <input id="location" name="location" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
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
						  	<textarea style="height:auto;width:95%" class="inputxt" rows="6" id="riskReason" name="riskReason"  ignore="ignore" ></textarea>
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
					  	<textarea style="height:auto;width:95%" class="inputxt" rows="6" id="record" name="record"  ignore="ignore" ></textarea>
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">整改措施</label>
					</td>
				</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/demo/patrolRecord.js"></script>		
<script type="text/javascript">
 $("[id=iscontrol]").click(function(){
	 var is_control=$(this).val();
	 console.info($(this).val());
	 if(is_control==2){
		  getRisks();
	 }
	 if(is_control==1){
		 $("#inputs").html("");
	 }
 });
 </script>