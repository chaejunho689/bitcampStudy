<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	th, td, table {
		border : 1px solid grey;
	}
	th {
		width: 30%;
	}
</style>
</head>
<body>
	<form method="get" action="./elResult_java.jsp" >
		<table>
			<tr>
				<th> X </th>
				<td> <input type="text" name="x"  value="25"/> </td>
			</tr>
			<tr>
				<th> Y </th>
				<td>  <input type="text" name="y"  value="36"/> </td>
			</tr>
			<tr align="center" >
				<td colspan="2">
				    <button type="submit">계산</button>
				    <button type="reset">취소</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>