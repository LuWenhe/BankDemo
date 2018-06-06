<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
	#in {
		margin-left: 17px;
	}
	
</style>
<script type="text/javascript">
	
	$(function(){
		
		$("input:submit").click(function(){
			
			var inStr = $.trim($("#in").val());
			var loStr = $.trim($("#lo").val());
			var yeStr = $.trim($("#ye").val());
			
			if(inStr == "" || loStr == "" || yeStr == ""){
				alert("不能为空!");
				return false;
			}
		
		});
		
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
		<h2>贷款申请表单</h2>
		
		<div class="info">
			<form class="form-inline" action="bankServlet?method=handleLoan&loanId=${loan.loanId }
					&customerId=${customer.customerId } " method="post">
				<label class="form-label"><strong>${customer.name }</strong>😊，
				您办理的贷款为${loan.loanType }</label>
				<br/><br/>
				
				<div class="form-group">
					<label class="form-label">月收入：</label>
					<input type="text" class="form-control" id="in" name="income"/>
				</div>
				<br /><br />
				
				<div class="form-group">
					<label class="form-label">贷款金额：</label>
					<input type="text" class="form-control" name="loanamount" id="lo"/>
				</div>
				<br /><br />
						
				<div class="form-group">
					<label class="form-label">贷款年数：</label>
					<input type="text" class="form-control" name="yearnum" id="ye"/>
				</div>
				<br /><br />
				
				<div class="form-group col-md-offset-3" class="button">
					<input type="submit" class="btn btn-success pull-right" value="申请"/>
				</div>	
			</form>
		</div>
		
	</div>
</body>
</html>