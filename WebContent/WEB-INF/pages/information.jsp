<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<center>
		<h3>账户信息</h3>
		<br/>
		
		<c:if test="${requestScope.customer != null }">
			name: ${customer.name }
			<br/><br/>
			age: ${customer.age }
			<br/><br/>
			identityNumber: ${customer.identityNumber }
			<br/><br/>
			telephone: ${customer.telephone }
			<br/><br/>
			address: ${customer.address }
			<br/><br/>
			balance: ${sessionScope.account.accountId }
			<br/><br/>
			
			<a href="bankServlet?method=forwardPage&page=deposit&accountId=${sessionScope.account.accountId }">存款</a>&nbsp;
			<a href="bankServlet?method=forwardPage&page=withdraw&accountId=${sessionScope.account.accountId }">取款</a>&nbsp;
			<a href="bankServlet?method=detail&accountId=${sessionScope.account.accountId }">明细</a>&nbsp;
		</c:if>
		<br/>
	</center>

</body>
</html>