<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%


	//세션
	session.removeAttribute("memName");
	session.removeAttribute("memId");
	// ▼ 또는 아래처럼 전체 삭제
	session.invalidate();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  
</body>
<script type="text/javascript">
window.onload = function() {
	alert("로그아웃 되었습니다.");
	location.href = "/memberMVC/index.do";
}
</script>
</html>