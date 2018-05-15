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
		
		$("input:text").change(function(){
			var inputVal = $.trim($(this).val());
			var flag = true;
			var reg = /^\d+$/g;
			if(!reg.test(inputVal)){
				flag = false;
			}
			
			if(!flag){
				alert("输入的数量不合法");
				$(this).val("");
				return;
			}
		})
		
		$("input:submit").click(function(){
			var inputVal = $.trim($("input:text").val());
			if(inputVal == ""){
				alert("输入的数量为空");
				return;
			}
		})
	});
	
</script>
</head>
<body>
	
	<center>
		<h3>取款</h3>
		
		<form action="bankServlet?method=withdraw&accountNumber=${sessionScope.account.accountNumber }" method="post">
			请输入取款金额:
			<input type="text" name="withdrawNumber"/>
			<br/><br/>
			
			<input type="submit" value="确定"/>
		</form>
		
		<c:if test="${amount > 0 }">
			你已经取了 ${amount }元!,当前余额为: ${account.balance }元!
		</c:if>
	</center>
	

</body>
</html>