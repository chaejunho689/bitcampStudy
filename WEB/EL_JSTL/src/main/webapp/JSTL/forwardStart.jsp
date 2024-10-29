<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.jstl.personDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// 자바 역할
	List<String> list = new ArrayList<String>();
	list.add("호랑이");
	list.add("사자");
	list.add("기린");
	list.add("코끼리");
	list.add("타조");
	list.add("콜알알라");
	list.add("사막여우");

	personDTO aa = new personDTO("홍길동", 25);
	personDTO bb = new personDTO("라이언", 30);
	personDTO cc = new personDTO("어피치", 22);
	
	List<personDTO> list2 = new ArrayList<personDTO>();
	list2.add(aa);
	list2.add(bb);
	list2.add(cc);
	
	//submit, button를 통해서 넘어가는 데이터는 문자열(String)만 가능하다.
	//절대 객체는 넘길 수 없다.
	request.setAttribute("list", list);
	request.setAttribute("list2", list2);
	
	//페이지 이동
	//forward와 같은 의미
	RequestDispatcher dispatcher = request.getRequestDispatcher("forwardEnd.jsp"); // 상대 번지
	dispatcher.forward(request, response);
	
	//제어권 넘기기
	
%>

<jsp:forward page="forwardEnd.jsp" />