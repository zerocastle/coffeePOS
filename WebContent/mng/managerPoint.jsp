<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport"
	content="width = device-width, initial-scale = 1.0">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="../js/movingContent.js" charset="UTF-8"></script>
<script src="../js/category.js"></script>
<link href="../css/bootstrap-responsive.css" rel="stylesheet">
<link href="../css/login.css" rel="stylesheet">
<link href="../css/pstyle.css" rel="stylesheet" type="text/css">
<!--  link rel="stylesheet" href="css/ysFont.css"-->
<!-- Bootstrap -->
<link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.0/animate.css" rel="stylesheet"/>
</head>
<body>

	<c:if test="${!empty sessionScope.loginSession2}">
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span2">
					<img src="../images/brand.png" alt="" width="100" height="80">
				</div>
				<div class="container span2 offset3">
					<h1 class="title" id="title">HAKA</h1>
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

		<!-- 포인트 적립금 수정 -->
		<script>
			$(document).ready(function() {
				var control = $('#show');
				var img = control.find('>img');
				var result = $('#img');

				 img.click(function() {
					result.fadeIn(600);
				}); 
				img.click(function() {
					result.fadeOut(600);
				});
			})
		</script>
		<div class="container">
			<h1>적립률 변경</h1>
			<div class="stuff">
				<div class="textBox" id="box">
					<diV id="show">
						<img src="../images/brand.png" class="img-circle"
							style="width: 500px; height: 250px;" id="push" />
					</diV>
				</div>
			</div>
		</div>
	</c:if>
</body>
</html>