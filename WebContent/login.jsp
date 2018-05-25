<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/jquery-3.3.1.js"></script>
<script type="text/javascript">
	
	$(function(){
				
		$("input:submit").click(function(){
		
			var usStr = $.trim($("#us").val());
			var paStr = $.trim($("#pa").val());
			
			if(usStr == "" || paStr == ""){
				alert("不能为空");
				return false;
			}
			
			var err;
			
			$.ajax({
				type: "get",
				async: false,
				url: "loginServlet?method=testLogin",
				dataType: "json",
				data: {"username": usStr, "password": paStr, "time": new Date()},
				success: function(data){
					err = data.err;
				}
			});
			
			if(!err){
				alert("该账户不存在!");
				return false;
			}
			
			if(err == 1){
				alert("账户与密码不匹配!");
				return false;
			}			
			
			alert("登陆成功!");
			
		});
		
	});
	
</script>
</head>
<body>

	<form action="loginServlet?method=login" method="post">
		
		用户名: <input type="text" id="us" name="username" value="${username }"/>
		<br/><br/>
		密码: <input type="text" id="pa" name="password" value="${password }"/>
		<br/><br/>
		<a href="<%=request.getContextPath() %>/registeruser.jsp">注册账户</a>
		<input type="submit" value="登陆"/>
		
	</form>
	
</body>
</html>