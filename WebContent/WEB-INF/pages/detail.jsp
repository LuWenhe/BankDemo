<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<center>
		<h3>查询明细</h3>
		<br/>
		
		<table cellpadding="10">
			<tr>
				<th>时间</th>
				<th>操作方式</th>
				<th>XX</th>
				<th>金额</th>
			</tr>
			<c:forEach items="${depositDetail }" var="dd">
				<tr>
					<td>${dd.detailTime }</td>
					<td>${dd.type }</td>
					<td>${dd.detailId }</td>
					<td>${dd.money }</td>
				</tr>
			</c:forEach>
		</table>	
	</center>

</body>
</html>