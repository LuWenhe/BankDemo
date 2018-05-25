<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<center>
		<h3>你好,请选择您想要的贷款</h3>
		<br/>
		
		<table cellpadding="10">
			<tr>
				<th>编号</th>
				<th>种类</th>
				<th>利率</th>
				<th>最低首付比例</th>
				<th>操作</th>
			</tr>
			
			<c:forEach items="${requestScope.loan }" var="loan">
				<tr>
					<td>${loan.loanId }</td>
					<td>${loan.loanType }</td>
					<td>${loan.rate }</td>
					<td>${loan.minPayRate }</td>
					<td><a href="bankServlet?method=regloan&userId=${sessionScope.user.userId }&loanId=${loan.loanId }">申请</a></td>
				</tr>
			</c:forEach>
		</table>
	</center>

</body>
</html>