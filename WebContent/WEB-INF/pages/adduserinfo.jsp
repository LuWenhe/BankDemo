<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/jquery-3.3.1.js"></script>
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

	<h3>添加个人信息界面</h3>
	<br/>
	
	你好!${user.username }
	<br/><br/>
	
	<form action="bankServlet?method=addUserInfo" method="post" >
		姓名: <input type="text" id="na" name="name"/>
		<span id="errorNa" style="color: red"></span>
		<br/><br/>

		年龄: <input type="text" id="ag" name="age"/>
		<span id="errorAg" style="color: red"></span>
		<br/><br/>

		身份证号: <input type="text" id="ide" name="identityNumber"/>
		<span id="errorIde" style="color: red"></span>
		<br/><br/>

		手机号码: <input type="text" id="te" name="telephone"/>
		<span id="errorTe" style="color: red"></span>
		<br/><br/>

		地址: <input type="text" id="ad" name="address"/>
		<span id="errorAd" style="color: red"></span>
		<br/><br/>
		
		<input type="submit" value="注册"/>
	</form>
	
</body>
</html>