<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/jquery-3.3.1.js"></script>
<script type="text/javascript">
	
	$(function(){
		
		var usFlag = false;
		var paFlag = false;
		
		var isCor = function(input, reg){
			if(!reg.test(input)){
				return false;
			}
			return true;
		}
	    
		$("#us").change(function(){
			var regName = /^[a-zA-Z0-9_-]{5,15}$/g;
			var usStr = $.trim($(this).val());
			usFlag = isCor(usStr, regName);
				
			if(!usFlag){
				$("#errorus").text("请输入 5-15 位的字母和数字");
				return;
			}
			$("#errorus").text("");
		});
	    
		$("#pa").change(function(){
			var regPassword = /^[a-zA-Z]\w{5,15}$/g;
			var paStr = $.trim($(this).val());
			paFlag = isCor(paStr, regPassword);
				
			if(!paFlag){
				$("#errorpa").text("请输入 5-15 位的字母和数字");
				return;
			}
			$("#errorpa").text("");
		});
		
	    $("input:submit").click(function(){
	    	var usStr = $.trim($("#us").val()); 
			var paStr = $.trim($("#pa").val());
			
			if(usStr == "" || paStr == ""){
				alert("不能为空");
				return false;
			}
			
			if(!usFlag || !paFlag){
				alert("格式不对");
				return false;
			}
			
	    });
	});
	
</script>
</head>
<body>
	<h3>用户注册</h3>
	<br/>
	
	<form action="loginServlet?method=registerUser" method="post">
		用户名: <input type="text" id="us" name="username"/>
		<span id="errorus" style="color: red"></span>
		<br/><br/>
		
		密码: <input type="password" id="pa" name="password"/>
		<span id="errorpa" style="color: red"></span>
		<br/><br/>
		
		<input type="submit" value="注册"/>
	</form>

</body>
</html>