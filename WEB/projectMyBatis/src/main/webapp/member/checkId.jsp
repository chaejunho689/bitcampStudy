<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ID 중복 체크</title>
</head>
<body>
<form action="checkId.jsp">
<%

	//데이터
	String id = request.getParameter("id");
	boolean result = false;
	
	//DB
	//MemberDAO 싱글톤으로 생성;
// 	MemberDAO memberDAO = new MemberDAO();

	if(id == null || id.trim().isEmpty()) {
		out.println("아이디가 입력되지 않았습니다.");
	} else {
		MemberDAO memberDAO = MemberDAO.getInstance();
		result = memberDAO.isExistId(id);
	}
%>

<!-- 	(debug)user_input :  -->
<%-- 	<%=id%> --%>

<% if(result) { %>
		<p> 중복된 ID 입니다. </p>
		<input type="text" name="id">
		<input type="submit" value="중복체크"/>
<% }else { %>
		<p> 사용 가능한 ID 입니다. </p>
		<input type="button" value="사용하기" onclick="checkIdClose('<%=id%>')" />
<% } %>
</form>

<script type="text/javascript">
function checkIdClose(id) {
	opener.document.getElementById("id").value = id;
	opener.document.getElementById("password1").focus(); 
	window.close();
}
</script>
</body>
</html>