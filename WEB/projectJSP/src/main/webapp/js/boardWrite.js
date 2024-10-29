$(function(){
	$('#boardWriteBtn').click(function(){
		$('#subjectDiv').empty();
		$('#contentDiv').empty();
		
		if($('#subject').value() == '' ) {
			$('#subjectDiv').html('제목 입력');
		} else if($('#content').val() == '') {
			$('#contentDiv').html('내용 입력');
		} else {
			$.ajax({
				type : 'post'
				,url : 'boardWrite.jsp'
				,data : {
						 'subeject' : $('#subejct').val() 
						,'content' : $('#subejct').val() 
					 	}
				,success : function(){}
				,error : function(e){
					console.log(e)
				}
			});
		}
	})
});