<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="board.bean.BoardDTO"%>
<%@page import="board.service.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	
	String id = (String)session.getAttribute("memId");
	String name = (String)session.getAttribute("memName");
	String email = (String)session.getAttribute("memEmail");
	
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	
	Map<String, String> map = new HashMap<>();
    map.put("id", id);
    map.put("name",  name);
    map.put("email", email);
    map.put("subject", subject);
    map.put("content", content);
    
	

	BoardDAO boardDAO = BoardDAO.getInstance();
	BoardDTO boardDTO = new BoardDTO();
	
	
	boardDTO.setId(id);
	boardDTO.setSubject(subject);
	boardDTO.setContent(content);

	boardDAO.write(boardDTO);
// 	boardDAO.write(Map<String, String>map)
// 		String sql; = "";
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p> 글 작성이 완료되었습니다. </p>

<script type="text/javascript">
window.onload = function() {
	alert("글작성이 완료되었습니다.");
	location.href="../index.jsp";
}

</script>

</body></html>
