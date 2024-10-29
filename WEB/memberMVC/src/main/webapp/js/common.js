var idcheckYn = false;
var pwd = document.getElementById("password");
var pwd1 = document.getElementById("password1");
var pwd2 = document.getElementById("password2");
var name = document.getElementById("name");
var id = document.getElementById("id");

// 우편번호 - 다음 API
function postcode() {
	 new daum.Postcode({
	        oncomplete: function(data) {
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
	            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
        	//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
        	if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
        	addr = data.roadAddress;
        	} else { // 사용자가 지번 주소를 선택했을 경우(J)
        	addr = data. jibunAddress;

        	}

        	// 우편번호와 주소 정보를 해당 필드에 넣는다.
        	document.getElementById('zipcode').value = data.zonecode;
        	document.getElementById("addr1").value = addr;
        	// 커서를 상세주소 필드로 이동한다.
        	document.getElementById("addr2").focus();
	    }}).open();
 }
 
function checkId() {
	let id = document.getElementById("id").value;
	
	if(!id) {
		document.getElementById("idDiv").innerText = "먼저 아이디를 입력하세요.";
 	} else {
		window.open("../member/checkId.jsp?id="+id, "myWindow", "width=450 height=150 top=200 left=700");	
		idcheckYn = true;
 	}
 }
 
function idcheckYn_change() {
	 idcheckYn = false;
 }
 
function submitCheck(form) {
	var id = form.id.value;
	var pwd1 = form.password1.value;
	var pwd2 = form.password2.value;
	var name = form.name.value;
	
	 if(!id) {
		 alert("아이디를 입력하세요.");
		 document.getElementById("id").focus();
		 return false;
 	}else if(!idcheckYn) {
		 alert("아이디 중복체크 진행하세요.");
		 document.getElementById("id").focus();
		 return false;
	 } else if(pwd1.value != pwd2.value) {
		 alert("비밀번호가 일치하지 않습니다.");
		 document.getElementById("password2").value = "";
		 document.getElementById("password2").focus();
		 return false;
	 } else if(!name) {
		 alert("이름을 입력하세요.");
		 document.getElementById("name").focus();
		 return false;
	 } else if(!pwd1) {
		 alert("비밀번호를 입력하세요.");
		 document.getElementById("password1").focus();
		 return false;
	 }
	 
	return true;
 }
 
 
 function updateSubmitCheck(form) {
	var id = form.id.value;
	var pwd1 = form.password1.value;
	var pwd2 = form.password2.value;
	var name = form.name.value;
	
 	 if(!id) {
 		 alert("아이디를 입력하세요.");
 		 document.getElementById("id").focus();
 		 return false;
 	 } else if(pwd1.value != pwd2.value) {
 		 alert("비밀번호가 일치하지 않습니다.");
 		 document.getElementById("password2").value = "";
 		 document.getElementById("password2").focus();
 		 return false;
 	 } else if(!name) {
 		 alert("이름을 입력하세요.");
 		 document.getElementById("name").focus();
 		 return false;
 	 } else if(!pwd1) {
 		 alert("비밀번호를 입력하세요.");
 		 document.getElementById("password1").focus();
 		 return false;
 	 }
	 return true;
  }
 
function submitLoginCheck(form) {
	if(!id) {
		alert("아이디를 입력하세요.");
		document.getElementById("id").focus();
		return false;
	 } else if(!pwd) {
		alert("비밀번호를 입력하세요.");
		document.getElementById("password").focus();
		return false;
	 }
}
 
function change() {
	 document.getElementById("email2").value = document.getElementById("email3").value;
//	 document.getElementById("email2").focus();
 }
 
 $('#id').focusout(function(){
	$('#idDiv').empty();
	
	let id = document.getElementById("id").value;
	
	if(id == null || id == "") {
		$('#idDiv').css('color', 'red');
		$('#idDiv').append("ID가 입력되지 않았습니다.")
	} else {
		$.ajax({
			type : 'post'
			,url : 'checkId.do'
			,dataType : "text"
			,data : {
					 'id' : $('#id').val() 
				 	}
			,success : function(data){
//				data = data.replace(/[\n\r]/g, '');
				data = data.trim();
				if(data != "exist_result") {
					$('#idDiv').css('color', 'blue');
					$('#idDiv').append("사용 가능한 ID입니다.");
					idcheckYn = true;
				} else {
					$('#idDiv').css('color', 'red');
					$('#idDiv').append("사용 불가능한 ID입니다.");
				}
			}
			,error : function(e){
				console.log(e)
			}
		});
	}
});

$('#id').focusin(function(){
	$('#idDiv').empty();
});
 
 $('#updateBtn').click(function(){
	$('#nameDiv').empty();
	$('#pwdDiv').empty();

	if($('#name').val() == '') {
		$('#nameDiv').html('이름을 입력하세요.');
	} else if($('#pwd').val() == '') {
		$('#nameDiv').html('비밀번호를 입력하세요.');
	} else if($('#pwd').val != $('#rdpwd')) {
		$('#nameDiv').html('비밀번호가 맞지않습니다');
	} else {
		$.ajax({
			type: 'post',
			url : 'update.jsp',
			data : $('form[name="updateForm"]').serialize(), //name=값&id=값&~~~~
			success : function(){
				alert("회원정보가 수정 완료되었습니다.")
				location.href="../index.jsp"
			},
			error : function(e) {
				console.log(e);
			}
		});
	}
 });