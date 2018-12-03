<!-- 사원 삭제 -->
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
<script src="mngButton.js" charset="UTF-8"></script>
</head>
<body>
	<div id="wrapper">
		<h1>사원 삭제</h1>
		<table width="300" height="300" align="center">

			<tr>
				<td align="center">사원번호</td>
			</tr>
			<tr>
				<td align="center"><input id="dId" name="eId" type="text" size="10"></td>
			</tr>
			<tr>
				<td align="center"><input type="submit" value="삭제"
					id="deleteEmployee"> <input type="submit" value="취소"
					id="cancle"></td>
			</tr>
		</table>
	</div>
</body>
</html>