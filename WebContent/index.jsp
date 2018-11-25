<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Document</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="js/eLogin.js" charset="UTF-8"></script>
<!--  style src="mcss/login.css"></style-->
<style>
.box {
	float: left;
	border: 2px solid brown;
	width: 50%;
	height: 100%;
	text-align: center;
	vertical-align: center;
	font-family: "Times New Roman", Serif;
	font-size: 1.5em;
}

#inline {
	display: block;
	padding: 5px;
	border: 2px solid brown;
	width: 450px;
	height: 150px;
}

#inline>.box:hover {
	color: violet;
}
</style>

<script>
	$(document).ready(function() {
		$('#buttonE').bind('click', function() {
			$('#employee').show();
			$('.boxWrap').hide();
		})

		$('#buttonM').bind('click', function() {
			$('#manager').show();
			$('.boxWrap').hide();
		})
	})
</script>
</head>
<body>
<div>${sessionScope.loginSession}</div>	
<c:if test="${empty sessionScope.loginSession || sessionScope.loginSession2}">
	<!-- 단순 이미지 -->
	<div align="center">
		<img src="images/login_coffee01.jpg" alt="커피사진" width="450"
			height="350">
	</div>
	<!-- 로그인 선택 박스 -->
	<div align="center" class="boxWrap">
		<div id="inline">
			<button id="buttonE" class="box">사원</button>
			<button id="buttonM" class="box">매니저</button>
		</div>
	</div>

	<!--사원(employee 로그인 부분) -->
	<div align="center" id="employee" style="display: none;">
		<div class="login">
			<div class="heading">
				<h2>Sign in</h2>

				<!--로그인 ajax로 처리 보낼부분 -->
				<div class="input-group input-group-lg">
					<span class="input-group-addon"><i class="fa fa-user"></i></span> <input
						type="text" class="form-control" placeholder="ID" id="eId">
				</div>

				<div class="input-group input-group-lg">
					<span class="input-group-addon"><i class="fa fa-lock"></i></span> <input
						type="password" class="form-control" placeholder="Password"
						id="ePw">
				</div>

				<button type="submit" class="float" id="eSubmit">Login</button>
			</div>
		</div>
	</div>
	<!-- 관리자 로그인 부분 -->
	<div align="center" id="manager" style="display: none;">
		<div class="login">
			<div class="heading">
				<h2>Sign in</h2>

				<!--로그인 ajax로 처리 보낼부분 -->

				<div class="input-group input-group-lg">
					<span class="input-group-addon"><i class="fa fa-lock"></i></span> <input
						type="password" class="form-control" placeholder="Password"
						id="mPw">
				</div>

				<button type="submit" class="float" id="mSubmit">Login</button>
			</div>
		</div>
	</div>
</c:if>

<c:if test="${!empty sessionScope.loginSession}">
	<div>여기는  사원  페이지</div>
</c:if>

<c:if test="${!empty sessionScope.loginSession2 }">
	<div>여기는 관리자 페이지 입니다.</div>
</c:if>


</body>
</html>