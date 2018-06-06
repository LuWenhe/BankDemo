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
		})
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
		<h2>存款💴</h2>
		
		<div class="info">
			<form action="bankServlet?method=deposit&userId=${sessionScope.user.userId }" method="post">
				<div class="form-group col-sm-8" >
			    	<input type="text" class="form-control" name="depositNumber" placeholder="请输入存款金额">
			    </div>
				    
			    <div class="form-group">
					<input type="submit" class="btn btn-primary" value="确定" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>