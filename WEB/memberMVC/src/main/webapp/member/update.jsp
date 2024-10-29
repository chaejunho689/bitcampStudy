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
<!-- <p> 회원 정보가 수정 완료되었습니다. </p> -->
<script type="text/javascript">
window.onload = function() {
	alert("회원정보가 수정완료되었습니다.");
	location.href="/memberMVC/index.do";
}

</script>

</body></html>
