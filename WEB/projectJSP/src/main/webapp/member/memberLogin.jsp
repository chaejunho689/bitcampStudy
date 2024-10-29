<%@page import="java.net.URLEncoder"%>
<%@page import="member.bean.MemberDTO"%>
<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
String id = request.getParameter("id");
String pwd = request.getParameter("pwd"); 

MemberDAO memberDAO = MemberDAO.getInstance();
MemberDTO memberDTO = memberDAO.login(id, pwd);


// loginYn = memberDAO.login(id, pwd);

// String name = memberDAO.login(id, pwd);
// String login_id = memberDAO.login(id, pwd);

// if(name != "" || name != null) {
// 	loginYn = true;
// }


%>

<%
	
	if(memberDTO == null) {
		//페이지 이동
		response.sendRedirect("loginFail.jsp");
	}else {
		/*
		// 중요한 데이터를 주소에 실어서 보내지 않도록 주의한다.
		// response.sendRedirect("loginOk.jsp?name=" + URLEncoder.encode(name,"UTF-8") + "&id=" + id);
	
		// 쿠키 방식
		Cookie cookie = new Cookie("memName", name); // 쿠키 생성
		cookie.setMaxAge(3); // 초단위
		response.addCookie(cookie); // 클라이언트에 저장
		
		Cookie cookie2 = new Cookie("memId", id);
		cookie2.setMaxAge(3); 
		response.addCookie(cookie2);
		
		*/
		//세션 방식
// 		HttpSession session = request.getSession();
	    String get_id = memberDTO.getId();
		String get_name = memberDTO.getName();
	 	String get_email = memberDTO.getEmail1() + "@" + memberDTO.getEmail2();
		
		session.setAttribute("memName", memberDTO.getName());
		session.setAttribute("memId", id);
		session.setAttribute("memEmail", memberDTO.getEmail1()+"@"+memberDTO.getEmail2());

		session.setAttribute("memDTO", memberDTO);
		
		response.sendRedirect("loginOk.jsp");
	}
%>

