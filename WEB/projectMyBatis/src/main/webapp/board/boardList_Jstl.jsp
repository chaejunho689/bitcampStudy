<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="board.bean.BoardPaging"%>
<%@page import="java.util.List"%>
<%@page import="board.service.BoardDAO"%>
<%@page import="board.bean.BoardDTO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int pg = Integer.parseInt(request.getParameter("pg"));

	//	1페이지당 5개씩
	int endNum = pg * 5;
	int startNum = endNum - 4;
	
	Map<String,Object>map = new HashMap<String,Object>();

	map.put("endNum", endNum);
	map.put("startNum", startNum);
	
	
	//DB
	 BoardDAO boardDAO = BoardDAO.getInstance();
	 List<BoardDTO> list = boardDAO.boardList(map);
		
	 //페이징 처리
	 int totalA = boardDAO.getTotalA();
	 
	 BoardPaging boardPaging = new BoardPaging();
	 boardPaging.setCurrentPage(pg);
	 boardPaging.setPageBlock(3);
	 boardPaging.setPageSize(5);
	 boardPaging.setTotalA(totalA);
	 
	 boardPaging.makePagingHTML();
	 
	 
	 %>
	 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border-collapse: collapse;
}

th, td {
	padding : 10px;
}
#currentPaging {
	border: 1px solid blue;
	color : red;
	font-size: 15pt;
	padding : 5px 8px;
}
#paging {
	border: 1px solid blue;
	color : black;
	font-size : 15pt;
}




</style>
</head>
<body>
	<table border="1" frame="hsides" rules="rows">
		<tr>
			<th width="100">글번호</th>
			<th width="400">제목</th>
			<th width="150">작성자</th>
			<th width="150">작성일</th>
			<th width="100">조회수</th>
		</tr>
		
		${param.list }
		<tr>
			<td>
				${param.seq }
			</td>
		
	</table>
</body>
</html>