<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/jquery-3.3.1.js"></script>
<script type="text/javascript">
	
	var count = 3;
	
	function go(){
		count --;
		
		var href = window.location.href;
		var len = href.lastIndexOf("/");
		var href1 = href.substr(0, len + 1);
		
		if(count > 0){
			$("#time").text(count);
		} else {
			window.location.href = href1 + "information.jsp";
		}
	}
		
	$(function(){
		setInterval(go, 1000);  
	});
	
</script>
</head>
<body>
	
	<h3>正在处理...</h3>

</body>
</html>