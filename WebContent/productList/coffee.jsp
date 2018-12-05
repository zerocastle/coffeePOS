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
			<th></th>
			<th>이미지</th>
			<th>상품명</th>
			<th>가격</th>

			<c:forEach var="item" items="${sessionScope.getCoffeeList }">
				<tr>

					<td></td>
					<td><img src="/coffeePOS/images/productImage/${item.pPath }" width="70px" height="70px" /></td>
					<td>${item.pName}</td>
					<td>${item.pPrice}</td>

				</tr>
			</c:forEach>

		</table>

	</div>


</body>
</html>