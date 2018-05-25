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
				return false;
			}
			
			var u = $("form").attr("action");
			var len = u.length;
			var len1 = u.lastIndexOf("=");
			var userId = u.substr(len1 + 1, len - len1);
			
			var err1;
			var err2;
			var acc;
		
			$.ajax({
				type: "get",
				async: false,
				url: "bankServlet?method=testBalance",
				dataType: "json",
				data: {"userId": userId, "account": inputVal, "time": new Date()},
				success: function(data){
					err1 = data.err1;
					err2 = data.err2;
					acc = data.account;
				}
			});
			
			if(err2 == 1){
				alert("很抱歉!您已经超过了10000元的限度");
				return false;
			}
			
			alert("您已经存入:" + acc + "元!");
		})
	});
	
</script>
</head>
<body>
	<center>
		<h3>存款</h3>	
		
		<form action="bankServlet?method=deposit&userId=${sessionScope.user.userId }" method="post">
			请输入存款金额:
			<input type="text" name="depositNumber"/>
			<br/><br/>
			
			<input type="submit" value="确定"/>
		</form>

	</center>

</body>
</html>