$(function(){
	$('#updateBtn').click(function(){
		$('#nameDiv').empty();
    	$('#pwdDiv').empty();
    	
    	if($('#name').val() == '') {
    		$('#nameDiv').html('이름 입력');
    	} else if($('#pwd').val() == '') {
    		$('#pwdDiv').html('비밀번호 입력');
    	} else {
	    		$.ajax({
		    		type: 'post',
		            url: '/spring/user/update',
		            data: $('#userUpdateForm').serialize(),
		            success: function() {
		                	alert('회원정보 수정 완료');
                    location.href = '/spring/user/list?pg=' + $('#pg').val();
		            },
		            error: function(e) {
		                console.log(e);
		            }
	    		});
    		}
	});
});


$(function(){
	$('#deleteBtn').click(function(){
		if(confirm("정말 삭제하시겠습니까?") ) {
			$.ajax({
	    		type: 'post',
	            url: '/spring/user/delete',
	            data: $('#userUpdateForm').serialize(),
	            success: function() {
	                	alert('계정이 삭제되었습니다. ');
	            location.href = '/spring/user/list?pg=' + $('#pg').val();
	            },
	            error: function(e) {
	                console.log(e);
	            }
			});
		} else {
			alert("취소되었습니다.");
		}
	});
});