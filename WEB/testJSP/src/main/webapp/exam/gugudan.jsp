<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	td {
		padding : 0 5px;
		width: 100px;
	}
</style>
</head>
<body>
<table>
	<% for(int dan = 2; dan<=9; dan++) { %>
		<tr>
		<% for(int num = 1; num <= 9; num++) { %>
		<td><%=dan %> * <%=num %> = <%= dan * num  %> </td>
	<% } %>
	</tr>
<% } %>
</table>
</body>
</html>