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
		var regName = /^[a-zA-Z][a-zA-Z0-9_]{4,15}$/g;
		var regPassword = /^[a-zA-Z]\w{5,17}$/g;
		
		var isCor = function(input, reg){
			if(!reg.test(input)){
				return false;
			}
			
			return true;
		}
	
		$.validate = function(aNode, bNode, tips, reg){  
 			$(aNode).change(function(){
 				var usStr = $.trim($(this).val());
 				var flag = isCor(usStr, reg);
 				
 				if(!flag){
 					$(bNode).text(tips);
 					return;
 				}
 				
 				$(bNode).text("");
 			})
	    };  			
		
	    $.validate("#us", "#errorus", "请输入8-14位的字母或数字", regName);
	    $.validate("#pa", "#errorpa", "请输入8-14位的字母或数字", regPassword);
	    
	});
	
</script>
</head>
<body>
	
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