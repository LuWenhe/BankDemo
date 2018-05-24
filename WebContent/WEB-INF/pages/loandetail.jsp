<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<center>
		
		<h3>贷款信息</h3>
		<br/>
		
		<c:if test="${aLoan != null and loan != null }">
			Type: ${loan.loanType }
			<br/><br/>
			
			Rate: ${loan.rate }
			<br/><br/>
			
			loanAmount: ${aLoan.loanAmount }
			<br/><br/>
			
			year: ${aLoan.yearNum }
		</c:if>		
	</center>
	
</body>
</html>