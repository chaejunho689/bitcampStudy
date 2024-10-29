<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> 메인화면 </h2>
Context = ${pageContext.request.contextPath }
<c:if test="${sessionScope.memId  == null }">
<h3> <a href="./member/writeForm.do"> 회원가입 </a> </h3>
<h3> <a href="./member/loginForm.do"> 로그인 </a> </h3>
</c:if>

<c:if test="${sessionScope.memId  != null }"> 
<h3> <a href="./member/updateForm.do"> 회원정보수정 </a> </h3>
<h3> <a href="./member/logout.do"> 로그아웃 </a> </h3>
</c:if>

</body>
</html>