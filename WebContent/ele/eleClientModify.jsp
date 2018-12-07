<%@ page language="java" contentType="text/html; charset=UTF-8"
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
	<script src="../js/category.js"></script>
</head>

<body>
	<div id="wrapper">
		<h1>고객 정보 수정</h1>
		<table width="300" height="300" align="center">

			 <tr>
				<td>아이디</td>
				<td><input id="mId" name="mId" type="text"></td>
			</tr> 
			<tr>
				<td>전화번호</td>
				<td><input id="mPhone" name="mPhone" type="text"></td>
			</tr>
			<!-- <tr>
				<td>이름</td>
				<td><input id="mName" name="name" type="text"></td>
			</tr> -->
			<tr>
				<td rowspan="3" colspan="1" align="center" bgcolor="white"></td>
			</tr>
			<tr>
				<td align="center"><button id="modifyMember">수정</button>
				 <button id="cancle">취소</button></td>
			</tr>
		</table>
	</div>
</body>
</html>