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
		
		var nameReg = /^[\u4e00-\u9fa5]{0,8}$/g;
		var idenReg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/g;
		var teleReg = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/g;
		
		var i = 0;
		
		var isCor = function(input, reg){
			if(!reg.test(input)){
				return false;
			}
			i++;
			alert(i);
			return true;
		}
		
	
		$.validate = function(aNode, bNode, tips, reg){  
 			$(aNode).change(function(){
 				var usStr = $.trim($(this).val());
 				var flag = isCor(usStr, reg);
 				
 				if(!flag){
 					$(bNode).text(tips);
 					return;
 				}
 				
 				$(bNode).text("");
 			})
	    };
	    
	    $("#ag").change(function(){
	    	var input = $.trim($(this).val());
	    	var num = parseInt(input);
	    	if(num <= 0 || num >= 120){
	    		$("#errorAg").text("请输入正确的年龄");
	    		return;
	    	}
	    	i++
	    	$("#errorAg").text("");
	    });
	    
	    $.validate("#na", "#errorNa", "请输入0-8位的汉字", nameReg);
	    $.validate("#ide", "#errorIde", "请输入正确的身份证号码", idenReg);
	    $.validate("#te", "#errorTe", "请输入正确的手机号码", teleReg);
	
	    $(":submit").click(function(){
			var usStr = $.trim($("#na").val()); 
			var agStr = $.trim($("#ag").val()); 
			var ideStr = $.trim($("#ide").val()); 
			var teStr = $.trim($("#te").val()); 
			var adStr = $.trim($("#ad").val()); 
			
		    if(usStr == "" || agStr == "" || ideStr == ""
					|| teStr == "" || adStr == ""){
				alert("不能为空");
				return false;
			}
		    
			if(i != 4){
				alert("验证不能通过");
				return false;
			}
		});
	    
	});
	
</script>
</head>
<body>

	<h3>添加个人信息界面</h3>
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