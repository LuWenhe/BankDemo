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
		
		$(":button").click(function(){
			var usStr = $.trim($("#na").val()); 
			
			if(usStr == ""){
				alert("hel");
		
			}
		})
		
	});
	
</script>
</head>
<body>
	
	<form action="success.jsp" method="post">
		<input type="text" name="name" id="na"/>
		<input type="button" value="Submit">
	</form>

</body>
</html>