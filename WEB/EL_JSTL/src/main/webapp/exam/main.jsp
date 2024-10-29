<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3> *** include directive *** </h3>
	<%@ include file="today.jsp"  %>

	<h3> *** include JSP tag *** </h3>
	<jsp:include page="image.jsp" >
	
	<% String name = "코난"; %> 
<!-- today.jsp에서 변수 String name을 잡았기 때문에 에러 발생 -->
	
	<h3> 3초 뒤에 네이버로 이동 </h3>
	<% response.setHeader("Refresh", "3;url=https://www.naver.com"); %>
	
</body>
</html>

