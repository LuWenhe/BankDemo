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
<script type="text/javascript">
	
	$(function(){
		
		var $aNode = $("#fir");
		var href = $aNode.attr("href");
		var aLoanId = href.substr(href.lastIndexOf("=") + 1, 1);

		if(aLoanId != 0){
			$aNode.text("查看贷款");
		} else {
			$aNode.text("申请贷款");

			$aNode.attr("href", "bankServlet?method=loanlist"); 
		}
		
	});
	
</script>
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
		<h2>账户信息📔</h2>
		
		<div class="content-left">
			<div class="info">
				<span class="text-info">姓名：</span>
				<label id="info1">${customer.name }</label>
				<br/><br/>
				
				<span class="text-info">年龄：</span>
				<label id="info1">${customer.age }</label>
				<br/><br/>
			
				<span class="text-info">身份证号：</span>
				<label>${customer.identityNumber }</label>
				<br/><br/>
				
				<span class="text-info">电话：</span>
				<label id="info1">${customer.telephone }</label>
				<br/><br/>
				
				<span class="text-info">地址：</span>
				<label id="info1">${customer.address }</label>
				<br/><br/>
				
				<span class="text-info">余额：</span>
				<label id="info1">${account.balance }</label>
				<br/><br/>
				
				<span class="text-info">是否贷款？</span>
				<label><a href="bankServlet?method=loanDetail&aLoanId=${customer.aLoanId }" id="fir"></a></label>
				<br/><br/>
			</div>
		</div>
	</div>
	
</body>
</html>