<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/common.js" defer></script>
</head>
<body>
<h1>
	<img src="../image/1.jpg" width="100" height="100" alt="홈" 
		 onclick="location.href='../index.jsp'" style="cursor: pointer;"> 로그인
</h1>
<form id="loginForm">
	<table border="1">
		<tr>
	        <th>아이디</th>
	        <td>
	        	<input type="text" name="id" id="login_id" size="30" placeholder="아이디 입력">
	        	<div id="loginIdDiv"></div>
	        </td>
	    </tr>
	    
	    <tr>
	        <th>비밀번호</th>
	        <td>
	        	<input type="password" name="pwd" id="login_pwd" size="40" placeholder="비밀번호 입력">
	        	<div id="loginPwdDiv"></div>
	        </td>
	    </tr>
	    
	    <tr>
	    	<td colspan="2" align="center">
	    		<input type="button" value="로그인" id="loginBtn" "/>
	    		<input type="button" value="회원가입" onclick="location.href='/member/writeForm.do'" />      
	    	</td>
	    </tr>
	</table>
</form>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
$(function() {
	$('#loginBtn').click(function(){
		$('#loginIdDiv').empty();
		$('#login_pwdDiv').empty();
		
		if($('#login_id').val() == '') {
			$('#loginIdDiv').html('아이디를 입력하세요.');
			$('#loginIdDiv').css('color', 'red');
			
		} else if($('#login_pwd').val() == '') {
			$('#loginPwdDiv').html('패스워드를 입력하세요.')
			$('#loginPwdDiv').css('color', 'red');
			
		} else {
			$.ajax({
				type : 'post',
				url : 'login.do',
				data : {
					'id' : $('#login_id').val(),
					'pwd' : $('#login_pwd').val() },
				dataType: "json",
				success : function(data) {
					if(data.login_yn == 'login_fail') {
						alert("아이디 또는 비밀번호가 틀렸습니다.")
					} else {
	                    alert(data.memName + "님 로그인되었습니다.");
	                    location.href='/memberMVC/index.do';
				    }
	            },
	            error: function(e){
					console.log(e);
				}
	        });
	    }
	});
});
</script>
</body>
</html>