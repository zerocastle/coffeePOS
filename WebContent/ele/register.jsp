<!-- 고객등록 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h1 {
	text-align: center;
}
#wrapper{
	border:1px solid black;
}
</style>
</head>
<body>
	<div id="wrapper">
		<h1>고객 등록</h1>
		<table width="300" height="300" align="center">
			<tr>
				<td>이름</td>
				<td><input id="name" name="name" type="text"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input id="tel" name="tel" type="text"></td>
			</tr>
			<tr>
				<td rowspan="3" colspan="1" align="center" bgcolor="white"></td>
			</tr>
			<tr>
				<td align="center"><input type="submit" value="등록"> <input
					type="submit" value="취소"></td>
			</tr>
		</table>
	</div>
</body>
</html>