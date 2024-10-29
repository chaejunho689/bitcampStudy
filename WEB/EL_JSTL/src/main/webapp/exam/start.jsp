<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<font color="red" >
	<b>
		start.jsp. - sendProc.jsp - sendResult.jsp 페이지 이동합니다.
		sendDiret로 이동하므로 데이터는 공유되지 않습니다.
		주소는 sendResult.jsp가 보인다.
	</b>
	</font>
	<font color="blue" >
	<b>
		start.jsp. - forwardProc.jsp - forwardResult.jsp 페이지 이동합니다.
		forward로 이동하므로 데이터는 공유합니다.
		주소는 forwardProc.jsp가 보이지만 결과는 forwardResult.jp가 나온다.
	</b>
	</font>
	
	<input type="button" value="endRedirect" onclick="location.href='sendProc.jsp' ">
	<input type="button" value="forward" onclick="location.href='forwardProc.jsp' ">
</body>
</html>