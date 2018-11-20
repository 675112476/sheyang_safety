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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="patrolRecordController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${patrolRecordPage.id }"/>
		巡查公司
  </t:formvalid>
 </body>
 <script src = "webpage/com/jeecg/demo/patrolRecord.js"></script>	
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
			url : "http://localhost:8090/test",
			dataType : "jsonp",
			complete : function(data) {
				console.info(data);
			}
		});
	}
	//getRisks("射阳港龙凤烟花爆竹门市");
	getCountry();
</script>		
