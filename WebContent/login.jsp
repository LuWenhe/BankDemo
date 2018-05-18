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
</script>
</head>
<body>

	<font color="red">
		<c:if test="${requestScope.error != null }">
			${requestScope.error }
		</c:if>
	</font>
	<br/>
	
	<form action="loginServlet?method=login" method="post">
		
		用户名: <input type="text" name="username"/>
		<br/><br/>
		密码: <input type="text" name="password"/>
		<br/><br/>
		<a href="<%=request.getContextPath() %>/registeruser.jsp">忘记密码?</a>
		<input type="submit" value="登陆"/>
		
	</form>
	
</body>
</html>