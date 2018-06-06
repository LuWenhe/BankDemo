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
<style type="text/css">
	.info {
		font-size: 15px;
	}
	
	.table th, .table td { 
		text-align: center;
	}
</style>
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
		<h2>账户明细📋</h2>
		<div class="info">
			<table class="table table-hover" cellpadding="10">
				<thead>
					<tr>
						<th>编号</th>
						<th>时间</th>
						<th>操作方式</th>
						<th>金额</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${depositDetail }" var="dd">
						<tr>
							<td>${dd.tradeNumber }</td>
							<td>${dd.detailTime }</td>
							<td>${dd.type }</td>
							<td>${dd.money }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>