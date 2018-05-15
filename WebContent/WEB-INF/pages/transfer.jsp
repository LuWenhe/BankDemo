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
	
	$(function(){
		
		$("#as").change(function(){
			var inputVal = $.trim($(this).val());
			var flag = true;
			var reg = /^\d{16}$/g;
			if(!reg.test(inputVal)){
				flag = false;
			}
			
			if(!flag){
				$("#error").text("银行账户格式不正确");
				$(this).val("");
				return;
			}
			
			$("#error").text("");
			
			var url = "bankServlet?method=validateAccount";
			var args = {"accountSide":inputVal, "time":new Date()};
			
			$.getJSON(url, args, function(data){
				var result1 = data.result;

				if(!result1){
					$("#error").text("不能使用自己的账户");
				} else if(result1 == 1) {
					$("#error").text("验证通过");
				} else {
					$("#error").text("不存在该账户");
				}
				
			});
		
		});
		
		$("#an").change(function(){
			var inputVal = $.trim($(this).val());
			var flag = true;
			var reg = /^\d+$/g;
			
			if(!reg.test(inputVal)){
				flag = false;
			}
			
			if(!flag){
				$("#error").text("输入的金额格式不正确");
				$(this).val("");
				return;
			}
			
			$("#error").text("");
		});
		
	});
	
</script>
</head>
<body>

	<center>
		<h3>转账</h3>
		
		<div id="error" style="color: red"></div>
		
		<form action="bankServlet?method=transfer&accountNumber=${sessionScope.account.accountNumber }" method="post">
			请输入对方的账户:
			<input type="text" id="as" name="accountSide"/>
			<br/><br/>
			
			请输入转账金额:
			<input type="text" id="an" name="amount"/>
			<br/><br/>
			
			<input type="submit" value="转账"/>
		</form>
		
		<c:if test="${amount > 0 }">
			你已经向账号为 ${account.accountNumber }的用户转了 ${amount } 元!
		</c:if>
	</center>

</body>
</html>