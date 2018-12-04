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
				<c:forEach var="item" items="${sessionScope.getCoffeeList }">



					<td><img src="${item.pPath }" />${item.pName} ${item.pPrice}</td>


				</c:forEach>
			</tr>
		</table>

	</div>


</body>
</html>