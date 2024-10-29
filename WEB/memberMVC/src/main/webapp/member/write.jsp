<%@page import="member.bean.MemberDTO"%>
<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p> 회원가입이 완료되었습니다. </p>

<script type="text/javascript">
window.onload = function() {
	alert("회원가입을 축하합니다.");
	location.href="../index.jsp";
}

</script>

</body></html>
