<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/jquery-3.3.1.js"></script>
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
	
	<center>
		<h3>贷款申请表单</h3>
		<br/>
		
		你好! ${customer.name }, 您办理的贷款为${loan.loanType }, 请填写以下信息
		<br/><br/>
		
		<form action="bankServlet?method=handleLoan&loanId=${loan.loanId }
				&customerId=${customer.customerId } " method="post">
			月收入: <input type="text" name="income" id="in"/>
			<br/><br/>
			
			贷款金额: <input type="text" name="loanamount" id="lo"/>
			<br/><br/>
			
			贷款年数: <input type="text" name="yearnum" id="ye"/>
			<br/><br/>
			
			<input type="submit" value="申请"/>			
		</form>
	</center>
	
</body>
</html>