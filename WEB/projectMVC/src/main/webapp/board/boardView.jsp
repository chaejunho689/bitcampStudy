<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/index.css">
<style type="text/css">
table {
    border-collapse: collapse;
}
th, td{
    padding: 10px;
}
#boardViewForm {
	display: flex;
	flex-direction: column;
	align-items: center;
	margin: 30px auto;
	text-align: left;
}
</style>
</head>
<body>
<div id="wrap">
	<div id="header">
		<h1>
			<img alt="사과" src="${ pageContext.request.contextPath }/image/apple.png" 
			     width="50" height="50"
			     onclick="location.href='${ pageContext.request.contextPath }/index.do'"
			     style="cursor: pointer;">
			MVC를 활용한 미니프로젝트
		</h1>
		<hr style="border-color: #483D8B; border-width: 3px;" />
	</div>
	
	<div id="container">
		<jsp:include page="../main/boardMenu.jsp" />
		
		<div id="section">
			
			<form id="boardViewForm">
				
				<input type="hidden" id="memId" value="${sessionScope.memId }" />
				<input type="hidden" name="seq" value="${boardDTO.seq }" />
				<input type="hidden" name="pg" value="${requestScope.pg }" />
			
				<table border="1" frame="hsides" rules="rows">
					<tr>
						<td colspan="3">
							<h2>${boardDTO.subject }</h2>
						</td>
					</tr>
					
					<tr>
						<td width="200">글번호 : ${boardDTO.seq }</td>
						<td width="200">작성자 : <span id="id">${boardDTO.id }</span></td>
						<td width="200">조회수 : ${boardDTO.hit }</td>
					</tr>
					
					<tr>
						<td height="300" colspan="3" valign="top">
							<div style="width: 100%; height: 100%; overflow: auto;">
								<pre style="white-space: pre-line; word-break: break-all;">
									${boardDTO.content }
								</pre>
							</div>
						</td>
					</tr>
				</table>
				
				
				
				
				
				
				
				
				
				
				
				
				
				<div style="width: 650px; margin-top: 5px;">
					<input type="button" value="목록" 
					       onclick="location.href='/projectMVC/board/boardList.do?pg=${pg}'">
					<span id="boardViewSpan">
						<input type="button" value="글수정" id="boardUpdateFormBtn"> <!-- seq, pg 가지고 간다 -->
						<input type="button" value="글삭제" id="boardDeleteFormBtn"> <!-- seq 가지고 간다 -->
					</span>
				</div>
			</form>
			
		</div> <!-- id="section" -->
	</div> <!-- id="container" -->
</div>	<!-- id="wrap" -->

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../js/boardView.js"></script>
</body>
</html>















