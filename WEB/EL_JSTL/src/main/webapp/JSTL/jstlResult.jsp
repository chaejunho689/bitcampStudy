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
	<fmt:requestEncoding value="UTF-8"/>
	<ul>
		<li> 이름 : ${param.name} </li>
		<li> 나이 : ${param.age}살 </li>
		<c:if test="${param.age >= 19 }">
			<li> 성인입니다 </li>
		</c:if>
		<c:if test="${param.age < 19 }">
			<li> 미성년자입니다 </li>
		</c:if>
		<li> 색깔 :
			<c:choose>
				<c:when test="${param.color == 'red'}"> 빨강 </c:when>
				<c:when test="${param.color == 'green'}"> 초록 </c:when>
				<c:when test="${param.color == 'blue'}"> 파랑 </c:when>
				<c:when test="${param.color == 'magenta'}"> 보라 </c:when>
				<c:otherwise> 하늘 </c:otherwise>
			</c:choose>
		 </li> <br>
		 <li> 취미1 : 
		 	${paramValues['hobby'][0] }
		 	${paramValues['hobby'][1] }
		 	${paramValues['hobby'][2] }
		 	${paramValues['hobby'][3] }
		 	${paramValues['hobby'][4] }
		 	${paramValues['hobby'][5] }
		 	<br>
		</li>
		<li> 취미2 : 
		 	${paramValues.hobby[0] }
		 	${paramValues.hobby[1] }
		 	${paramValues.hobby[2] }
		 	${paramValues.hobby[3] }
		 	${paramValues.hobby[4] }
		 	${paramValues.hobby[5] }
		 </li>
		 <li> 취미3 :
		 	<c:forEach var="data" items="${paramValues.hobby }"> <%-- for() --%>
		 		${data }
		 	</c:forEach> 
		 	
		 </li>
		 
	</ul>
</body>
</html>