<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>巡查记录</title>

 <style type="text/css">

        body

        {

            font-family:Arial, Sans-Serif;

            font-size:0.85em;

        }

        img 

        {

            border:none;

        }

        ul, ul li

        {

            list-style-type: none;

            margin: 0;

            padding: 0;

        }

        ul li.first

        {

            border-top: 1px solid #DFDFDF;

        }

        ul li.last

        {

            border: none;

        }

        ul p

        {

            float: left;

            margin: 0;

            width: 310px;

        }

        ul h3

        {

            float: left;

            font-size: 14px;

            font-weight: bold;

            margin: 5px 0 0 0;

            width: 200px;

            margin-left:20px;

        }

        ul li

        {

            border-bottom: 1px solid #DFDFDF;

            padding: 10px 0;

            width:600px;

            overflow:hidden;

        }

        ul input[type="text"], ul input[type="password"]

        {

            width:300px;

            padding:5px;

            position:relative;

            border:solid 1px #666;

            -moz-border-radius:5px;

            -webkit-border-radius:5px;

        }

        ul input.required 

        {

            border: solid 1px #f00;

        }
        textarea {

				padding: 10px;

				vertical-align: top;

				width: 200px;

			}

			textarea:focus {

				outline-style: solid;

				outline-width: 2px;

			}

    </style>

	<script src="plug-in/joints/jquery.js"></script>
	<script src='plug-in/autosize/autosize.js'></script>
	<script type="text/javascript" src="plug-in/date/laydate.dev.js"></script>

    
</head>

<body>

<center>

<br /><br />


    <ul>
        <li class="first">

            <h3>巡查员姓名：</h3>

            <p><input type="text"  id="patrol_name" name="patrol_name" /></p>

        </li>

        <li>

            <h3>巡查员电话：</h3>

            <p><input type="text" name="patrol_phone" id="patrol_phone"/></p>

        </li>

        <li>

            <h3>巡查时间：</h3>
            <p><input name="time" id="time" style="width:300px; padding:5px; border:1px solid #666;-webkit-border-radius:5px;"/></p>

        </li>

        <li>

            <h3>巡查单位：</h3>

            <p><input type="text" name="patrol_factory" id="patrol_factory" /></p>

        </li>

        <li>

            <h3>巡查具体地址：</h3>

            <p><input type="text" id="address" name="address"  /></p>

        </li>
        <li>

            <h3>风险点是否可控：</h3>
            <div style="text-align: left;"><button id="is_control" onclick="getRisks();">查询风险点</button><div>
				<br/><br/>
                <form action="http://218.92.240.39:6390/insertrisks" id="inputs">

        </li>
        <li>

            <h3>整改措施：</h3>

            <p>
            <textarea id="measures" name="measures" style='max-height: 300px; width: 300px;resize: none; border:solid 1px #666;-webkit-border-radius:5px;'></textarea>
			</p>

        </li>
        <li class="last">
            
			<button type="button" id="signup" onclick="sendRecords()">提交</button>
			<button type="button" id="reset" onclick="reset_func()">重置</button>

        </li>

    </ul></center>
	<script type="text/javascript">

        laydate({

            elem: '#time'

        });

    </script>
	<script>

	autosize(document.querySelectorAll('textarea'));
	function getRisks(){
		var inputdiv=document.getElementById("inputs");
		var inputhtml="";
		if($("#patrol_factory").val()==""||$("#time").val()==""){
			alert("请输入巡查公司名称和时间");
		}else{
			var factory=$("#patrol_factory").val();
			var time=$("#time").val();
			//http://localhost:8090/getriskpoints
			console.info(factory);
			console.info(time);
			
			$.ajax({
				url : "http://218.92.240.39:6390/getriskpoints",
				data : {
					"factory" : factory
				},
				async: false,
				dataType : "jsonp",
				complete : function(data) {
					console.info(data);
					data = data.responseJSON;
					console.info(data);
					if(data.risks==null){
						alert("公司查无危险点，请确认巡查公司是否输入错误！");
					}else{
						var risks=data.risks;
						console.info(risks);
						for(var i=0;i<risks.length;i++){
							inputhtml+="<input type='hidden' name='date' value="+time+">"
							+"<input type='hidden' name='factory' value="+factory+">"
							+"<input type='hidden' name='risk_point' value="+risks[i]+">"
							+"<div>风险点"+(i+1)+"："+risks[i]
							+"&nbsp&nbsp&nbsp<select name='is_control'>"   
					        +"<option value='可控'>可控</option> <option value='不可控'>不可控</option></select> </div><br/>";
						}
						inputhtml+="<input type='submit' value='保存'><br><br>";
						console.info(inputhtml);
						inputdiv.innerHTML=inputhtml;
					}
				}
			});
		}
		
	}
	function sendRecords(){
		if($("#patrol_name").val()==""||$("#patrol_phone").val()==""||$("#time").val()==""||$("#patrol_factory").val()==""){
			alert("请填写完整姓名、电话、时间和公司");
		}else{
			var patrol_name=$("#patrol_name").val();
	    	var patrol_phone=$("#patrol_phone").val();
	    	var time=$("#time").val();
	    	var patrol_factory=$("#patrol_factory").val();
	    	var address=$("#address").val();
	    	var measures=$("#measures").val();
	    	$.ajax({
	    		url : "http://218.92.240.39:6390/insertrecords",
	    		data : {
	    			"patrol_name" : patrol_name,
	    			"patrol_factory":patrol_factory,
	    			"patrol_phone":patrol_phone,
	    			"time":time,
	    			"address":address,
	    			"measures":measures,
	    			
	    		},
	    		async: false,
	    		dataType : "jsonp",
	    		complete : function(data) {
	    			console.info(data);
	    			if(data.status==200){
	    				alert("提交成功");
	    				location.reload();
	    			}else{
	    				alert("服务器错误，插入失败");
	    			}
	    		}
	    	});
		}
    }
	function reset_func(){
		document.getElementById("patrol_name").value="";
		document.getElementById("patrol_phone").value="";
		document.getElementById("time").value="";
		document.getElementById("patrol_factory").value="";
		document.getElementById("address").value="";
		document.getElementById("measures").value="";
		
	}
	$.ajax({
        url: "http://218.92.240.39:6390/get",
        type: "GET",
        data:{country:"县政府"},
        dataType: "jsonp",
        processData: true,
        success: function(json) {
        	console.info(json);
        }
	});
	</script>
    
</body>
</html>