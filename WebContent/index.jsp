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
<!--  link rel="stylesheet" href="css/ysFont.css"-->
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="js/eLogin.js" charset="UTF-8"></script>
<script src="js/category.js" charset="UTF-8"></script>
<script src="js/movingContent.js" charset="UTF-8"></script>
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

#category {
	float: left;
	width: 10%;
	height: 70%;
	text-align: left;
	/*일딴 색깔 칠하고 나중에 촌스러우니깐 지우자*/
	background-color: skyblue;
}

footer {
	width: 100%;
	height: 30%;
	clear: both;
	padding-top: 20px;
}

#product {
	width: 40%;
	heigth: 70%;
	float: left;
	background-color: linen;
}

#counter {
	float: left;
	width: 50%;
	height: 70%;
	/* background-color: pink; */
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
		test="${(empty sessionScope.loginSession) and (empty sessionScope.loginSession2)}">
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
						<input type="text" class="form-control" placeholder="사번" id="eId">
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
						<span class="input-group-addon"><i class="fa fa-user"></i></span>
						<input type="text" class="form-control" placeholder="관리자번호"
							id="mId">
					</div>


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
							<span style="color: brown"><span id="resultStr"></span>
								${sessionScope.loginSession}</span>&nbsp반갑습니다. <span><button
									id="logout" type="button" class="btn btn-mini">로그아웃</button></span>
						</h4>
					</div>
				</div>
			</div>
		</div>
		<div class="container-fluid" id="menuList">
			<div class="navbar navbar-inverse">
				<div class="navbar-inner">
					<a class="brand" href="#" id="home">HOME</a>
					<div class="span4 offset7"></div>
					<ul class="nav">
						<li><a href="#">고객관리</a></li>
					</ul>
				</div>
			</div>
		</div>
		<nav id="category">
			<ul class="nav nav-tabs nav-stacked">
				<li><a href="#" id="coffeeButton">COFFEE</a></li>
				<li><a href="#" id="teaButton">TEA</a></li>
				<li><a href="#" id="breadButton">BREAD</a></li>
			</ul>
		</nav>
		<!-- 여기 상품 화면 보이는 부분 -->
		<div id="product">
			<div id="coffee"><jsp:include page="productList/coffee.jsp" /></div>
			<div id="tea" style="display: none"><jsp:include
					page="productList/tea.jsp" /></div>
			<div id="bread" style="display: none"><jsp:include
					page="productList/bread.jsp" /></div>
		</div>
		<!-- 카운터 영역 -->
		<div id="counter">
			<div><jsp:include page="ele/counterView.jsp" /></div>
		</div>

	</c:if>
	<!-- 권한으로 할지 생각좀 해조자 이건 -->
	<c:if test="${!empty sessionScope.loginSession2 }">
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
							<span style="color: brown"><span id="resultStr"></span>
								${sessionScope.loginSession2}</span>&nbsp반갑습니다. <span><button
									id="logout" type="button" class="btn btn-mini">로그아웃</button></span>
						</h4>
					</div>
				</div>
			</div>
		</div>
		<div class="container-fluid" id="menuList">
			<div class="navbar navbar-inverse">
				<div class="navbar-inner">
					<a class="brand" href="#" id="home">HOME</a>
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
		<nav id="category">
			<ul class="nav nav-tabs nav-stacked">
				<li><a href="#">COFFEE</a></li>
				<li><a href="#">TEA</a></li>
				<li><a href="#">BREAD</a></li>
			</ul>
		</nav>
		<!-- 여기 상품 화면 보이는 부분 -->
		<div id="product">
			<div id="coffee"><jsp:include page="productList/coffee.jsp" /></div>
			<div id="tea" style="display: none"><jsp:include
					page="productList/tea.jsp" /></div>
			<div id="bread" style="display: none"><jsp:include
					page="productList/bread.jsp" /></div>
		</div>
		<!-- 카운터 영역 -->
		<div id="counter">
			<div><jsp:include page="ele/counterView.jsp" /></div>
		</div>
	</c:if>


	<!-- coy right -->
	<footer class="container-fluid">
		<p class="text-center" id="introduce" style>HAKA</p>
		<p class="text-center">품격 있는 맛 최상의 서비스</p>
		<p class="text-center">
			<strong>&copy; 2018 YS.com All rights reserved.</strong>
		</p>

	</footer>


</body>
</html>