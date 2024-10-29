<%@page import="member.bean.MemberDTO"%>
<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String) session.getAttribute("memId");
	MemberDTO memberDTO = null;
	
	if (id != null) {
	    MemberDAO memberDAO = MemberDAO.getInstance();
	    memberDTO = memberDAO.getMember(id);
	}
	
	if (memberDTO == null) {
	    out.println("<script>alert('회원 정보를 불러올 수 없습니다. 다시 로그인해 주세요.'); location.href='./member/login.jsp';</script>");
	    return;
	}

%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="../js/common.js" defer></script>
<script type="text/javascript">
window.onload = function() {
// 	document.updateForm.gender[1].checked = true;
	document.updateForm.gender['<%=memberDTO.getGender()%>'].checked = true;
	
	document.updateForm.tel1.value = '<%=memberDTO.getTel1()%>';
	document.updateForm.tel2.value = '<%=memberDTO.getTel2()%>';
	document.updateForm.tel3.value = '<%=memberDTO.getTel3()%>';
	
// 	index이동

}
</script>
</head>
<body>
<div>
<img src="../image/ompangi.gif" width="100" height="100" alt="홈" onclick="location.href='../index.jsp'" style="cursor: pointer;">
	<form method="post" action="/memberMVC/member/update.do" onsubmit="return updateSubmitCheck(this)">
	    <table>
	        <tr>
	            <th>이름</th>
	            <td><input type="text" name="name" id="name" class="name" value="<%=memberDTO.getName() %>"></td>
	        </tr>
	        <tr>
	            <th>아이디</th>
	            <td><input type="text" id="update_Id" name="id" onchange="idcheckYn_change()" value="<%=memberDTO.getId() %>" readonly>
	            	<div id="updateIdDiv">
	            	</div>
	            </td>
	        </tr>
	        <tr>
	            <th>비밀번호</th>
	            <td><input type="password" name="password1" id="password1" class="password" placeholder="비밀번호 입력" ></td>
	        	<div id="pwdDiv"></div>
	        </tr>
	        <tr>
	            <th>재확인</th>
	            <td><input type="password" name="password2" id="password2" class="password" placeholder="비밀번호 입력"></td>
	        </tr>
	        <tr>
		    	<th>성별</th>
	            <td><input type="radio" id="gender" name="gender" value="0"> 남자
	            	<input type="radio" id="gender" name="gender" value="1"> 여자 
	            </td>
	        </tr>
	        <tr>
	            <th>이메일</th>
	            <td><input type="text" id="email1" name="email1" value="<%= memberDTO.getEmail1() %>"/> @
		            <input type="text" id="email2" name="email2" value="<%= memberDTO.getEmail2() %>"/>
		            <input type="text" id="email3" name="email3" list="email3_list" oninput="change()" />
		            <datalist id="email3_list" >
						<option value="직접입력"/>		            
						<option value="naver.com"/>		            
						<option value="daum.net"/>		            
						<option value="gmail.com"/>	
		            </datalist>
	            </td>
	        </tr>
	        <tr>
	            <th>전화번호</th>
	            <td>
	            	<select name="tel1"> 
	            		<option value="010"> 010 </option>
	            		<option value="011"> 011 </option>
	            		<option value="019"> 019 </option>
	            	</select>
	            	-
		            <input type="text" name="tel2" maxlength="4" value="<%=memberDTO.getTel2() %>">
		            -
		            <input type="text" name="tel3" maxlength="4"  value="<%=memberDTO.getTel3() %>">
	            </td>
	        </tr>
        	<tr>
	        	<th rowspan='3'> 주소  </th> 
	        	<td colspan='2'>
	        		<input type="text" name="zipcode" id="zipcode" size="6" readonly value="<%=memberDTO.getZipcode() %>"> 
	        		<button type="button" onclick="postcode();">우편번호 검색</button>
	        	</td>
        	</tr>
        	<tr>
        		<td colspan='2'>
        			<input type="text" name="addr1" id="addr1" placeholder="주소" value="<%=memberDTO.getAddr1() %>">
        		</td> 
        	</tr>
   		    <tr>
        		<td colspan='2'>
        			<input type="text" name="addr2" id="addr2" placeholder="상세주소" value="<%=memberDTO.getAddr2() %>">
        		</td> 
        	</tr>
	        <tr id="submitDiv">
		        <td colspan='4'>
				    <button type="submit">회원정보수정</button>
				    <button type="reset">다시제출</button>
				</td>
	    	</tr>
	    </table>

	</form>
</div>

</body>
</html>