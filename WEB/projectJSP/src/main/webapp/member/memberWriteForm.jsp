<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<style type="text/css">
#submitDiv {
	text-align: center;
}
table th {
	border-collapse: collapse;
}
th, td {
	padding: 5px;
}
#address2 {
	width: 450px;
}
.password {
	width: 250px;
}
#idDiv {
	color: red;
	font-weight: 900;
}
</style>
</head>
<body>

<div>
<img src="../image/ompangi.gif" width="100" height="100" alt="홈" onclick="location.href='../index.jsp'" style="cursor: pointer;">

	<form method="post" action="./memberWrite.jsp" onsubmit="return submitCheck(this)">
	    <table>
	        <tr>
	            <th>이름</th>
	            <td><input type="text" name="name" id="name" class="name" placeholder="이름 입력"></td>
	        </tr>
	        <tr>
	            <th>아이디</th>
	            <td><input type="text" id="id" name="id" onchange="idcheckYn_change()">
	            	<button type="button" onclick="checkId()" >중복체크</button> 
	            	<div id="idDiv">
	            	</div>
	            </td>
	        </tr>
	        <tr>
	            <th>비밀번호</th>
	            <td><input type="password" name="password1" id="password1" class="password" placeholder="비밀번호 입력"></td>
	        	<div id="pwdDiv">
	        </tr>
	        <tr>
	            <th>재확인</th>
	            <td><input type="password" name="password2" id="password2" class="password" placeholder="비밀번호 입력"></td>
	        </tr>
	        <tr>
		    	<th>성별</th>
	            <td><input type="radio" name="gender" value="0" checked> 남자
	            	<input type="radio" name="gender" value="1"> 여자 
	            </td>
	        </tr>
	        <tr>
	            <th>이메일</th>
	            <td><input type="text" id="email1" name="email1"/> @
		            <input type="text" id="email2" name="email2" />
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
		            <input type="text" name="tel2" maxlength="4">
		            -
		            <input type="text" name="tel3" maxlength="4">
	            </td>
	        </tr>
        	<tr>
	        	<th rowspan='3'> 주소  </th> 
	        	<td colspan='2'>
	        		<input type="text" name="zipcode" id="zipcode" size="6" readonly placeholder="우편번호 입력""> 
	        		<button type="button" onclick="postcode();">우편번호 검색</button>
	        	</td>
        	</tr>
        	<tr>
        		<td colspan='2'>
        			<input type="text" name="addr1" id="addr1" placeholder="주소">
        		</td> 
        	</tr>
   		    <tr>
        		<td colspan='2'>
        			<input type="text" name="addr2" id="addr2" placeholder="상세주소">
        		</td> 
        	</tr>
	        <tr id="submitDiv">
		        <td colspan='4'>
				    <button type="submit">회원가입</button>
				    <button type="reset">다시제출</button>
				</td>
	    	</tr>
	    </table>

	</form>
</div>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="../js/common.js" defer></script>
</body>
</html>