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
		
		
		
	});
	
</script>
</head>
<body>

	<font color="red">
		<c:if test="${requestScope.error != null }">
			${requestScope.error }
		</c:if>
	</font>
	<br/>
	
	<form action="bankServlet?method=login" method="post">
		
		accountNumber: <input type="text" name="accountNumber" value="${requestScope.username }" />
		<br/><br/>
		accountPassword: <input type="text" name="accountPassword"/>
		<br/><br/>
		<input type="submit" value="登陆"/>
		
	</form>
	
</body>
</html>