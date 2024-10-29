<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
request.setAttribute("apple", "사과");

//페에지 이름
RequestDispatcher dispatcher = request.getDateHeader("forwardResult.jsp"); // 상대번지
dispatcher.forward(request, response); //제어권 넘기기
%>
<%-- <jsp:forward page="forwardResult.jsp" /> --%>


http://localhost:8080\EL_JSTL/exam /forwardResult.jsp
\EL_JSTL\exam\forwardrRsult.jsp