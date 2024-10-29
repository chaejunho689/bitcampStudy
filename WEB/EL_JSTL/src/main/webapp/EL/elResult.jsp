<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	
	
	String x_string = request.getParameter("x");
	String y_string = request.getParameter("y");
	
	int x = Integer.parseInt(x_string);
	int y = Integer.parseInt(y_string);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%=x_string%> + <%=y_string %> = <%= x + y %>

<br>
${param['x'] } + ${param['y'] } = ${param['x'] + param['y'] };
${param['x'] } - ${param['y'] } = ${param['x'] - param['y'] };
${param.x} * ${param.y} = ${param.x * param.y} <br>
${param.x} / ${param.y} = ${param.x / param.y} <br>
</body>
</html>