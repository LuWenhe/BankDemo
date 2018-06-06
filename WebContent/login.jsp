<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="script/jquery-3.3.1.js"></script>
<link rel="stylesheet" type="text/css" href="script/bootstrap.min.css" />
<script src="script/bootstrap.min.js"></script>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	
	$(function(){
				
		$("input:submit").click(function(){
		
			var usStr = $.trim($("#us").val());
			var paStr = $.trim($("#pa").val());
			
			if(usStr == "" || paStr == ""){
				alert("不能为空");
				return false;
			}
			
			var err;
			
			$.ajax({
				type: "get",
				async: false,
				url: "loginServlet?method=testLogin",
				dataType: "json",
				data: {"username": usStr, "password": paStr, "time": new Date()},
				success: function(data){
					err = data.err;
				}
			});
			
			if(!err){
				alert("该账户不存在!");
				$("#us").val("");
				$("#pa").val("");
				return false;
			}
			
			if(err == 1){
				alert("账户与密码不匹配!");
				return false;
			}			
			
		});
		
	});
	
</script>
</head>
<body>
	
	<div class="container">
		<div class="form row">
			<div class="form-horizontal col-md-offset-3" id="login_form">
				<h3 class="form-title">登陆🙂</h3>
				<br/>
				
				<form action="loginServlet?method=login" method="post">
					<div class="col-md-9">
						<div class="form-group">
							<input class="form-control required" type="text" placeholder="用户名" id="us" name="username" maxlength="15" value="${username }" />
						</div>
						<br/>
						
						<div class="form-group">
							<input class="form-control required" type="password" placeholder="密码" id="pa" name="password" maxlength="15" value="${password }"/>
						</div>
						
						<div class="form-group">
							<label class="checkbox">
	                            <a href="<%=request.getContextPath() %>/registeruser.jsp">没有账户？</a>
	                        </label>
						</div>
						
						<div class="form-group col-md-offset-7" class="button">
							<input type="submit" class="btn btn-success pull-right" value="登陆"/>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>