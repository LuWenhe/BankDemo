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
<link href='css/common.css' rel='stylesheet' type='text/css' />

<style type="text/css">
	
	span {
		font-weight: 600;	
	}
	
</style>

<script type="text/javascript">
	
	$(function(){
		
		var usFlag = false;
		var paFlag = false;
		
		var isCor = function(input, reg){
			if(!reg.test(input)){
				return false;
			}
			return true;
		}
	    
		$("#us").change(function(){
			var regName = /^[a-zA-Z0-9_-]{5,15}$/g;
			var usStr = $.trim($(this).val());
			usFlag = isCor(usStr, regName);
				
			if(!usFlag){
				$("#errorus").text("请输入 5-15 位的字母和数字");
				return;
			}
			$("#errorus").text("");
		});
	    
		$("#pa").change(function(){
			var regPassword = /^[a-zA-Z]\w{5,15}$/g;
			var paStr = $.trim($(this).val());
			paFlag = isCor(paStr, regPassword);
				
			if(!paFlag){
				$("#errorpa").text("请输入 5-15 位的字母和数字");
				return;
			}
			$("#errorpa").text("");
		});
		
	    $("input:submit").click(function(){
	    	var usStr = $.trim($("#us").val()); 
			var paStr = $.trim($("#pa").val());
			
			if(usStr == "" || paStr == ""){
				alert("不能为空");
				return false;
			}
			
			if(!usFlag || !paFlag){
				alert("格式不对");
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
				<h3 class="form-title">注册😊</h3>
				
				<form action="loginServlet?method=registerUser" method="post">
					<div class="col-md-9">
						<div class="form-group">
							<span id="errorus" class="text-danger"></span>
							<input class="form-control required" type="text" placeholder="用户名" id="us" name="username" autofocus="autofocus" maxlength="15" />
						</div>
						
						<div class="form-group">
							<span id="errorpa" class="text-danger"></span>
							<input class="form-control required" type="password" placeholder="密码" id="pa" name="password" maxlength="15" />
						</div>
						
						<div class="form-group col-md-offset-7" class="button">
							<input type="submit" class="btn btn-success pull-right" value="注册" />
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>