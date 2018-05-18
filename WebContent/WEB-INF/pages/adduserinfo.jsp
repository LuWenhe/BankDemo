<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<center>
		<h3>添加个人信息界面</h3>
		<br/><br/>
		
		<form action="bankServlet?method=addUserInfo" method="post">
			姓名: <input type="text" name="name"/>
			<br/><br/>
	
			年龄: <input type="text" name="age"/>
			<br/><br/>
	
			身份证号: <input type="text" name="identityNumber"/>
			<br/><br/>
	
			电话: <input type="text" name="telephone"/>
			<br/><br/>
	
			地址: <input type="text" name="address"/>
			<br/><br/>
			
			<input type="submit" value="注册"/>
		</form>
		
	</center>	
	
</body>
</html>