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

#wrapper {
	border: 1px solid black;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="eleButton.js" charset="UTF-8"></script>
</head>
<body>
	<div id="wrapper">
		<h1>고객 등록</h1>
		<table width="300" height="300" align="center">

			<tr>
				<td>아이디</td>
				<td><input id="cId" name="id" type="text"></td><td><button id="userCheck" value="유저확인">유저확인</button></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input id="cPhone" name="tel" type="text"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input id="cName" name="name" type="text"></td>
			</tr>
			<tr>
				<td rowspan="3" colspan="1" align="center" bgcolor="white"></td>
			</tr>
			<tr>
				<td align="center"><input type="submit" value="등록" id="registerSubmit"> <input
					type="submit" value="취소"></td>
			</tr>
		</table>
	</div>
</body>
</html>