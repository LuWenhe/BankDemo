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
			balance: ${customer.balance }
			
			<a href="bankServlet?method=forwardPage&page=deposit&accountNumber=${sessionScope.account.accountNumber }">存款</a>&nbsp;
			<a href="bankServlet?method=forwardPage&page=withdraw&accountNumber=${sessionScope.account.accountNumber }">取款</a>&nbsp;
			<a href="bankServlet?method=forwardPage&page=transfer&accountNumber=${sessionScope.account.accountNumber }">转账</a>&nbsp;
		</c:if>
		<br/>
	</center>

</body>
</html>