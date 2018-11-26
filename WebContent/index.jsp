<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Document</title>
<meta name="viewport"
	content="width = device-width, initial-scale = 1.0">
<link href="css/bootstrap-responsive.css" rel="stylesheet">
<link href="css/login.css" rel="stylesheet">
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="js/eLogin.js" charset="UTF-8"></script>
<!--  style src="mcss/login.css"></style-->

<style>
html, body {
	margin: 0;
	padding: 0;
	height: 100%
}

.nav {
	font-size: 2em;
	text-align: center;
}

#title {
	color: white;
	background-color: black;
	text-align: center;
	border: 3px solid black;
	box-shadow: grey 0.2em 0.2em 0.2em;
	text-shadow: black 0.2em 0.2em 0.2em;
}

#categoly {
	float: left;
	width: 10%;
	height: 80%;
	text-align: left;
}

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
	<c:if
		test="${empty sessionScope.loginSession || sessionScope.loginSession2}">
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
						<span class="input-group-addon"><i class="fa fa-user"></i></span>
						<input type="text" class="form-control" placeholder="ID" id="eId">
					</div>

					<div class="input-group input-group-lg">
						<span class="input-group-addon"><i class="fa fa-lock"></i></span>
						<input type="password" class="form-control" placeholder="Password"
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
						<span class="input-group-addon"><i class="fa fa-lock"></i></span>
						<input type="password" class="form-control" placeholder="Password"
							id="mPw">
					</div>

					<button type="submit" class="float" id="mSubmit">Login</button>
				</div>
			</div>
		</div>
	</c:if>
	<!-- 여기는 사원 페이지 입니다. -->
	<c:if test="${!empty sessionScope.loginSession}">
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span2">
					<img src="images/brand.png" alt="" width="100" height="80">
				</div>
				<div class="container span2 offset3">
					<h1 class="title" id="title">YS COFFEE</h1>
				</div>
				<div class="row span4 offset1"></div>
				<!-- 공백  -->
				<div class="container span4 offset1" class="box">
					<div>
						<h4>
							<span style="color: brown"> ${sessionScope.loginSession}</span>&nbsp반갑습니다.
						</h4>
					</div>
				</div>
			</div>
		</div>
		<div class="container-fluid">
			<div class="navbar navbar-inverse">
				<div class="navbar-inner">
					<a class="brand" href="#">HOME</a>
					<div class="span4 offset7"></div>
					<ul class="nav">
						<li><a href="#">고객관리</a></li>
						<li><a href="#">직원관리</a></li>
						<li><a href="#">매출관리</a></li>
						<li><a href="#">적립관리</a></li>
						<li><a href="#">메뉴관리</a></li>
					</ul>
				</div>
			</div>
		</div>
		<nav id="categoly">
			<ul class="nav nav-tabs nav-stacked">
				<li><a href="coffee">COFFEE</a></li>
				<li><a href="coffee">TEA</a></li>
				<li><a href="coffee">BREAD</a></li>
			</ul>
		</nav>
	</c:if>

	<c:if test="${!empty sessionScope.loginSession2 }">
		<div>여기는 관리자 페이지 입니다.</div>
	</c:if>


</body>
</html>