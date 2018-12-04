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
	<div id="left_main">
		<table id="image_item" border="1">
			<tr>
			</tr>
			<tr align="center">
				<td>아메리카노</td>
				<td>카페라떼</td>
				<td>카페모카</td>
			</tr>
		</table>
	</div>

	<div id="test">
		<table class="table-striped">
			<tr>
				<c:forEach var="item" items="${sessionScope.getCoffeeList }">
					<td>${item.pName }</td>	
				</c:forEach>
			</tr>
		</table>
		
	</div>
	<div>커피 리스트 : ${sessionScope.getCoffeeList }</div>
	<%=request.getAttribute("getCoffeeList") %>
</body>
</html>