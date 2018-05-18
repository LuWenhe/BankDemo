<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="loginServlet?method=registerUser" method="post">
		username: <input type="text" name="username"/>
		<br/><br/>
		
		password: <input type="text" name="password"/>
		<br/><br/>
		
		<input type="submit" value="注册"/>
	</form>

</body>
</html>