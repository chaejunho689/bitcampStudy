<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!	// JAVA 구역 -- 전역변수
	// 1번만 실행 됨
	String name = "홍길동";
	int age = 25;
%>

<%	// JAVA 구역 -- 지역변수
	// 요청시 마다 실행 됨
	age++;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- Hello JSP <br/> html 주석-->

<%-- 안녕하세요 JSP <br/> JSP 주석 --%>

나의 이름은 <%=name%> 입니다.<br/>

<% out.println("나의 이름은 " + name + "입니다."); %> <br/>

<!--나의 나이는 <%=age%>살 입니다.<br/> -->
<%-- <% out.println("나의 나이는 " + age + "살 입니다."); %>--%>
<%-- html단 주석은 걸어도 내부적으로 age 변수는 사용되므로,(개발자도구 소스에서 확인이 됨) age 변수를 주석할 경우 html단 age에서 오류 발생
따라서 jsp 주석을 걸어야 됨 --%>
</body>
</html>