$(function(){
	//자기가 작성한 글인지 확인하기?
	if($('#memId').val() == $('#id').text()){
		$('#boardViewSpan').show();
	}
	else{
		$('#boardViewSpan').hide();
	}
	
	//글수정
	$('#boardUpdateFormBtn').click(function(){
		$('#boardViewForm').attr('action', '/projectMVC/board/boardUpdateForm.do');
		$('#boardViewForm').submit(); //seq, pg를 가지고 이동한다.
	});
	
	//글삭제 - 삭제한 후에는 1페이지를 보여준다
	$('#boardDeleteFormBtn').click(function(){
		$('#boardViewForm').attr('action', '/projectMVC/board/boardDeleteForm.do');
		$('#boardViewForm').submit(); //seq를 가지고 이동한다.
	});
});