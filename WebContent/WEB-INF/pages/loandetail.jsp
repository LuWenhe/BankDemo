<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="script/jquery-3.3.1.js"></script>
<link rel="stylesheet" type="text/css" href="script/bootstrap.min.css" />
<script src="script/bootstrap.min.js"></script>
<link href="css/common2.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-inverse">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">主菜单</a>
			</div>
			<div id="navbar-menu" class="collapse navbar-collapse">
				<ul class="nav navbar-nav" class="a">
					<li>
						<a href="<%=request.getContextPath() %>/information.jsp">账户信息</a>
					</li>
					<li>
						<a href="bankServlet?method=forwardPage&page=deposit">存款</a>
					</li>
					<li>
						<a href="bankServlet?method=forwardPage&page=withdraw">取款</a>
					</li>
					<li>
						<a href="bankServlet?method=detail">明细</a>
					</li>
					<li>
						<a href="bankServlet?method=logout">注销</a>
					</li>
				</ul>
			</div>
		</nav>
	</div>
	
	<div class="content">
		<h2>贷款信息📝</h2>
		
		<div class="content-left">
			<div class="info">
				<c:if test="${aLoan != null and loan != null }">
					<span class="text-info">贷款种类：</span>
					<label>${loan.loanType }</label>
					<br/><br/>
					
					<span class="text-info">利率：</span>
					<label id="info1">${loan.rate }</label>
					<br/><br/>
					
					<span class="text-info">贷款年数：</span>
					<label>${aLoan.yearNum }</label>
					<br/><br/>
				</c:if>
			</div>
		</div>
	</div>
	
</body>
</html>