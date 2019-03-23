<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>巡查记录</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="plug-in/Nicepage-master/css/layui.css" type="text/css" rel="stylesheet">

<t:base type="jquery,easyui,tools,DatePicker"></t:base>

<script type="text/javascript">
	var json; 
	var nameList;
	var widthList;
	function DangerSearch() {
		
		var riskpoint = $("#riskpoints").val();
		if(riskpoint==""){
			alert("请选择危险点");
		}else{
			$.ajax({
				url : "http://218.92.240.39:6390/getriskfactory?riskpoint="+riskpoint,
				//url :"http://localhost:8090/getriskfactory?riskpoint="+riskpoint,
				type : "GET",
				timeout : 1000,
				processData : true,
				dataType : "jsonp",
				success : function(data) {
					if(data[0].result==0){
						data.splice(0,1); 
						console.info(data);
						json =data;
						//nameList与widthList的数组长度要一致
						nameList = ['巡查员姓名','巡查员电话','巡查时间', '巡查地点','整改措施']; //table的列名
						widthList = [100, 100, 100, 100, 200]; //table每列的宽度
						$.getScript('plug-in/Nicepage-master/js/nicePage.js',function(){
				        	 nicePage.setCfg({
					    			table: 'table',
					    			bar: 'pageBar',
					    			limit: 20,
					    			color: '#1E9FFF',
					    			layout: ['count', 'prev', 'page', 'next', 'limit', 'skip']
					    		});
				        });
						
					}else if(data[0].result==1){
						alert("该危险点查无记录");
						$("#riskpoints").val("");
						$("#riskpointsText").val("");
					}else if(data[0].result==2){
						alert("无该危险点");
						$("#riskpoints").val("");
						$("#riskpointsText").val("");
					}else if(data[0].result==3){
						alert("一次只能查询一个危险点");
						$("#riskpoints").val("");
						$("#riskpointsText").val("");
					}else if(data[0].result==4){
						alert("请选择具体的风险点");
						$("#riskpoints").val("");
						$("#riskpointsText").val("");
					}
					
				}
			});
		}
		
	}
</script>
</head>
<body>
·<center>
		<tr>
			<td align="right"><label class="Validform_label"> 场所危险点:
			</label></td>
			<td class="value"><t:treeSelectTag id="riskpoints"
					field="riskpoints" code="A02" inputClass="inputxt"></t:treeSelectTag>
				<span class="Validform_checktip"></span> <label
				class="Validform_label" style="display: none;">场所危险点</label></td>
			<td>
				<button type='button' id='btn_search' onclick='DangerSearch();'>搜索</button>
			</td>
		</tr>
	
		</br>
		<div style="width: 80%">
			<!--以下为两个必须div元素-->
			<div id="table"></div>
			<div id="pageBar"></div>
		</div>
	</center>

	
</body>
<script language="Javascript" src="plug-in/Nicepage-master/js/layui.js"></script>

</html>