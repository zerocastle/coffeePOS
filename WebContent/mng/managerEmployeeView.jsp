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
<script src="mngButton.js"></script>
<script src="../js/movingContent.js" charset="UTF-8"></script>
<script src="../js/category.js"></script>
<link href="../css/bootstrap-responsive.css" rel="stylesheet">
<link href="../css/login.css" rel="stylesheet">
<!--  link rel="stylesheet" href="css/ysFont.css"-->
<!-- Bootstrap -->
<link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">

<style>
table {
	width: 100%;
	margin: 15px 0;
}

th {
	font-weight: bold;
	background-color: #79a36d;
	color: #30205a;
	border: 1px solid #ffffff;
	border-width: 1px 0 1px 0
}

table, th, td {
	text-align: center;
	padding: 10px;
	border-collapse: collapse;
	border-bottom: 1px solid #EAEAEA;
}

tr {
	border: 1px solid #ffffff;
}

#list li {
	/*목차리스트*/
	display: inline;
	vertical-align: middle;
}

tbody tr:nth-child(2n-1) {
	background-color: #e8ebeb;
}
</style>
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
	</c:if>
	<!-- 본문 사원 리스트 -->
	<table border="1" rules="rows" width="200" height="150"
				align="center" id="table">
				<tr>
					<th></th>
					<th>순번</th>
					<th>사번</th>
					<th>전화번호</th>
					<th>이름</th>
					<th>월급</th>
					<th>직급</th>
				</tr>
				<h2 align="center">
				<b>- 사원 리스트 -</b>
			</h2>
			<c:forEach items="${requestScope.eleList}" var="item">
				<c:set var="counter" value="${counter + 1 }"></c:set>
				<tr>
					<td align="center"><label class="checkbox inline"> <input
							type="checkbox" id="${counter }" value="option1">
					</label></td>
					<td><c:out value="${counter}"></c:out></td>
					<td>${item.geteNum()}</td>
					<td>${item.getePhone()}</td>
					<td>${item.geteName()}</td>
					<td>${item.getePay()}</td>
					<td>${item.getRank()}</td>

				</tr>

			</c:forEach>
			</table>

			<!-- 패이징 -->
			<ul id="list" style="text-align: center">
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
			</ul>
			<!-- 버튼 -->
			<div id="a" align="right">
				<button type="submit" class="btn" id="refresh">조회</button>
				<button type="submit" class="btn" id="employeeRegister">등록</button>
				<button type="submit" class="btn" id="employeeDelete">삭제</button>
			</div>
			<div style="text-align: center">
				<select>
					<option>사번</option>
					<option>이름</option>

					<form method="post" action="#">
						<input type="text" class="input-medium search-query">
						<button type="submit" class="btn">Search</button>
					</form>
				</select>

			</div>
	
	
</body>
</html>