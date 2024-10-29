<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<fmt:formatNumber type="number" value="123456789" /><br>
<fmt:formatNumber type="number" value="123456789.99" /><br>
<fmt:formatNumber type="number" value="123456789.99" maxFractionoDigits=2/><br>

<fmt:formatNumber type="number" value="123456.78" pattern="#,###" /><br>
<fmt:formatNumber type="number" value="123456.78" pattern=",##" /><br>
<fmt:formatNumber type="number" value="123456.78" pattern="#,###.##" /><br>

<br>
<fmt:formatNumber type="number" value="0000.00" pattern="#,###.##" /><br>
<fmt:formatNumber type="number" value="0000.00" pattern="0, 000.00" /><br>
<fmt:formatNumber type="number" value="12.3" pattern="000.00" /><br>


<c:set var="now" value="<%=new Date() %>" />
<c:out value="${now}"/> <br>
date : <fmt:formatDate value="${now}" type="date" /> <br>
time : <fmt:formatDatae value="${now}" type="time" /> <br>
both : <fmt:formatDate value="${now}" type="both" /> <br>

<fmt:formatDate value="${now}" type="both" pattern="yyyy-MM-dd hh:mm" /><br>
<fmt:formatDate value="${now}" type="date" pattern="yyyy-MM-dd" /><br>
<fmt:formatDate value="${now}" type="date" pattern="yyyy-MM-dd E요일 a" /><br>
<fmt:formatDate value="${now}" type="time" pattern="HH:mm:ss" /><br>


</body>
</html>