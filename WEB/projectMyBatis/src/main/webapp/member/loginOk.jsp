<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
// 	String id = request.getParameter("id");
// 	String name = request.getParameter("name"); 
	
	String name = null;
	String id = null;

	/*
	// 쿠키
	Cookie[] ar = request.getCookies(); // 특정 쿠키만을 가져오지 못하고, 모든 쿠키들을 다 가져온다.
	if(ar != null) {
		for(int i = 0; i < ar.length; i++) {
			String cookieName = ar[i].getName(); // 쿠키명
			String cookieValue = ar[i].getValue(); // 쿠키값
			
			System.out.println("쿠키명 = " + cookieName);
			System.out.println("쿠키값 = " + cookieValue);
			System.out.println();
			
			if(cookieName.equals("memName")) {
				name = ar[i].getValue();
			}
			
			if(cookieName.equals("memId")) {
				id = ar[i].getValue();
			}
			
		}
	}
	*/
	//세션
	name = (String)session.getAttribute("memName"); // 다형성 : 자식 = (자식)부모 형태로 형변환
	id = (String)session.getAttribute("memId"); // 다형성 : 자식 = (자식)부모 형태로 형변환
%>
<!-- 로그인 되었습니다.-->
<%=name %>