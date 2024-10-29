<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="member.bean.MemberDTO"%>
<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
String id = request.getParameter("id");
String pwd = request.getParameter("pwd"); 

Map<String, String> map = new HashMap<>();
map.put("id", id);
map.put("pwd", pwd);

MemberDAO memberDAO = MemberDAO.getInstance();
MemberDTO memberDTO = new MemberDTO();

memberDTO.setId(id);
memberDTO.setPwd(pwd);
memberDTO = memberDAO.login(memberDTO);

%>

<%
	
	if(memberDTO == null) {
		response.sendRedirect("loginFail.jsp");
	}else {
	    String get_id = memberDTO.getId();
		String get_name = memberDTO.getName();
	 	String get_email = memberDTO.getEmail1() + "@" + memberDTO.getEmail2();
		
		session.setAttribute("memName", get_name);
		session.setAttribute("memId", get_id);
		session.setAttribute("memEmail", get_email);

		session.setAttribute("memDTO", memberDTO);
		
		response.sendRedirect("loginOk.jsp");
	}
%>

