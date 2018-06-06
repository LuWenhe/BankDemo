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

<style type="text/css">
	
	span {
		font-weight: 600;	
	}
	
</style>

<script type="text/javascript">
	
	$(function(){
		
		var nameReg = /^[\u4e00-\u9fa5]{0,8}$/g;
		var idenReg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/g;
		var teleReg = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/g;
		
		var naFlag = false;
		var agFlag = false;
		var ideFlag = false;
		var teFlag = false;
		var adFlag = false;
		
		var isCor = function(input, reg){
			if(!reg.test(input)){
				return false;
			}
			return true;
		}
	    
		function testStr(flag, anode, bnode, txt){
			if(!flag){
				$(bnode).text(txt);
				return;
			}
			$(bnode).text("");
		}
		
	    $("#na").change(function(){
	    	var naStr = $.trim($(this).val());
	    	naFlag = isCor(naStr, nameReg);
	    	
	    	testStr(naFlag, "#na", "#errorNa", "请输入0-8位的汉字");
	    });
	    
	    $("#ag").change(function(){
	    	var input = $.trim($(this).val());
	    	var num = parseInt(input);
	    	
	    	if(num <= 0 || num >= 120){
	    		$("#errorAg").text("请输入正确的年龄");
	    		return;
	    	}
	    	agFlag = true;
	    	$("#errorAg").text("");
	    });
	    
	    $("#ide").change(function(){
	    	var ideStr = $.trim($(this).val());
	    	ideFlag = isCor(ideStr, idenReg);
	    	
	    	testStr(ideFlag, "#ide", "#errorIde", "请输入正确的身份证号码");
	    });
	    
	    $("#te").change(function(){
	    	var teStr = $.trim($(this).val());
	    	teFlag = isCor(teStr, teleReg);
	    	
	    	testStr(teFlag, "#te", "#errorTe", "请输入正确的手机号码");
	    });
	    
	    $("#ad").change(function(){
	    	var teStr = $.trim($(this).val());
	    	if(teStr == ""){
	    		$("#errorAd").text("请输入地址");
	    		return;
	    	}
	    	adFlag = true;
	    	$("#errorAd").text("");
	    });
	    
	    $(":submit").click(function(){
	    	if(!naFlag || !agFlag || !ideFlag || !teFlag || !adFlag){
	    		alert("请输入正确信息!");
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
				<h3 class="form-title">你好😗 ${user.username }</h3>
				<form action="bankServlet?method=addUserInfo" method="post">
					<input type="hidden" name="username" value="${user.username }"/>
					<input type="hidden" name="password" value="${user.password }"/>
					
					<div class="col-md-9">
						<div class="form-group">
							<span class="text-danger" id="errorNa"></span>
							<input class="form-control required" type="text" placeholder="姓名" id="na" name="name"/>
						</div>
						<div class="form-group">
							<span class="text-danger" id="errorAg"></span>
							<input class="form-control required" type="text" placeholder="年龄" id="ag" name="age"/>
						</div>
						<div class="form-group">
							<span class="text-danger" id="errorIde"></span>
							<input class="form-control required" type="text" placeholder="身份证号" id="ide" name="identityNumber" />
						</div>
						<div class="form-group">
							<span class="text-danger" id="errorTe"></span>
							<input class="form-control required" type="text" placeholder="手机号码" id="te" name="telephone" />
						</div>
						<div class="form-group">
							<span class="text-danger" id="errorAd"></span>
							<input class="form-control required" type="text" placeholder="地址" id="ad" name="address" />
						</div>
						<div class="form-group col-md-offset-7" class="button">
							<input type="submit" class="btn btn-success pull-right" value="注册"></input>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>