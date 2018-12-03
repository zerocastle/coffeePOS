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
<script src="../ele/eleButton.js"></script>
<script src="../js/movingContent.js" charset="UTF-8"></script>
<script src="../js/category.js"></script>
<link href="../css/bootstrap-responsive.css" rel="stylesheet">
<link href="../css/login.css" rel="stylesheet">
<!--  link rel="stylesheet" href="css/ysFont.css"-->
<!-- Bootstrap -->
<link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="../css/pstyle.css" rel="stylesheet" type="text/css">
</head>
<body>
	<c:if test="${!empty sessionScope.loginSession2}">
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span2">
					<img src="../images/brand.png" alt="" width="100" height="80">
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
		
		<!-- 여기서 부터 상품수정 -->
			<div class="container">
				<h1>Product information</h1>
				<div class="stuff">
					<div class="image">
						<article>
							<p id="status">File Upload</p>
							<p>
								<input type=file>
							</p>
							<div id="holder"></div>
						</article>
						<script>
						/* 	var upload = document.getElementsByTagName('input')[0], holder = document
									.getElementById('holder'), state = document
									.getElementById('status');

							if (typeof window.FileReader === 'undefined') {
								state.className = 'fail';
							} else {
								state.className = 'success';
								state.innerHTML = 'Product Image';
							}

							upload.onchange = function(e) {
								e.preventDefault();

								var file = upload.files[0], reader = new FileReader();
								reader.onload = function(event) {
									var img = new Image();
									img.src = event.target.result;

									if (img.width > 150) { // holder width
										img.width = 150;
									}
									holder.innerHTML = '';
									holder.appendChild(img);
								};
								reader.readAsDataURL(file);

								return false;
							}; */
						</script>
						<label class="label"></label> <label class="error"></label>
					</div>
					<div class="textBox">
						<input class="text" type="textbox" placeholder="Product name"
							onkeyup="this.setAttribute('value', this.value);" value="" /> <label
							class="label">Product name</label> <label class="error"></label>
					</div>
					<div class="textBox">
						<input class="text" type="text" placeholder="Price"
							onkeyup="this.setAttribute('value', this.value);" value="" /> <label
							class="label">Price</label>
					</div>

					<button class="button1">수정</button>

					<button class="button2">취소</button>

				</div>
			</div>
	</c:if>
</body>
</html>