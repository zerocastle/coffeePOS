<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width = device-width, initial-scale = 1.0">
<title>Insert title here</title>
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/productList.css">
<!-- <script src="productList/productJS/coffee.js"></script> -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
	<c:set var="counter" value="0" />
	<c:set target="${sessionScope.getCoffeeLis }" var="object" />
	<div id="result">
		<table class="table table-hover">
			<tr>
				<th></th>
				<th>이미지</th>
				<th>상품명</th>
				<th>가격</th>
			</tr>

			<c:forEach var="item" items="${sessionScope.getTeaList }">
				<tr>

					<td><button class="btn" value="${item.pName }"
							onclick="search(this.value)">선택</button></td>
					<td><img src="/coffeePOS/images/${item.pPath }" width="70px"
						height="70px" /></td>
					<td><input type="text" value="${item.pName}"
						id="${item.pName}" /></td>
					<td><input type="text" value="${item.pPrice}"
						id="${item.pPrice}" /></td>
				</tr>
			</c:forEach>

		</table>

	</div>


</body>
</html>