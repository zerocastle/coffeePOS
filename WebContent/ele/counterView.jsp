
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width = device-width, initial-scale = 1.0">
<link href="css/bootstrap-responsive.css" rel="stylesheet">
<link href="css/bootstrap.css" rel="stylesheet">

<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/counterView.css">
<title>Insert title here</title>
<style>
.main {
	width: 100%;
	height: 70%;
}

.b {
	border: 1px black solid;
	width: 42%;
	height: 36%;
	/* margin-top: 1%; */
	margin-left: 8%;
	float: left;
	font-size: 20px;
}

.b-1 {
	width: 80px;
	position: relative;
	left: 55px;
	top: -5px;
	display: inline-block;
}

.c {
	border: 1px black solid;
	width: 40.5%;
	height: 250px;
	margin-top: 17.5%;
	display: inline-block;
}

.c-1 {
	width: 500px;
	height: 50px;
}

.c-1-1 {
	border: 1px black solid;
	width: 340px;
	height: 150px;
	margin-left: 3%;
	margin-top: 4%;
}

.c-2 {
	width: 390px;
	height: 110px;
	margin-top: 33%;
	position: relative;
	left: 0px;
}

.input-large {
	width: 240px;
	height: 40px;
	margin-left: 15px;
	margin-top: 15px;
	float: left;
}

.btn-large {
	padding: 11px 19px;
	font-size: 17.5px;
	-webkit-border-radius: 6px;
	-moz-border-radius: 6px;
	border-radius: 6px;
	margin-top: 15px;
	display: inline-block;
}
</style>
</head>
<body>
	<div>
		<div class="main">
			<div class="a">
				<div id="mainContent">

					<div id="basket">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Product</th>
									<th>Price</th>
									<th>Count</th>

								</tr>
							</thead>
							<tbody>
								<!-- <tr>
									<td>아메리카노</td>
									<td>1500원</td>
									<td><i class="fa fa-minus" title="Decrease Qty" /> <input
										class="qty" value="3" name="qty" maxlength="3" /> <i
										class="fa fa-plus" title="Increase Qty" /></td>
									<td>4500원</td>
									<td class="last"><i class="fa fa-trash-o"
										title="Delete Item"></i></td>
								</tr> -->

								<c:forEach items="${requestScope.itemList}" var="item">
									<c:set var="counter" value="${counter + 1 }"></c:set>
									<tr>
										<td align="center"><label class="checkbox inline">
												<input type="checkbox" id="${counter }" value="option1">
										</label></td>
										<td><c:out value="${counter}"></c:out></td>
										<td>${item.pName()}</td>
										<td>${item.pPrice()}</td>

									</tr>

								</c:forEach>

							</tbody>
						</table>


					</div>
				</div>
			</div>
			<div class="b">
				<table class="table">
					<td>총 금액
						<div class="b-1">
							<input class="input-medium" type="text" size="6" length="6">
						</div>
					</td>
					<tr>
						<td>적립금 사용 <input class="input-small" type="textbox">
							<button class="btn btn-default">사용</button></td>
					<tr>
						<td>결제 금액
							<div class="box-1"></div>
						</td>
					<tr>
						<td>적립금
							<div class="box-2"></div>
						</td>
				</table>
			</div>
			<div class="c">
				<div class="c-1">
					<input class="input-large" type="textbox">
					<button class="btn btn-large">조회</button>
					<div class="c-1-1"></div>
				</div>
				<div class="c-2">
					<button class="btn btn-block">결제</button>
					<button class="btn btn-block-1">삭제</button>
				</div>
			</div>
		</div>
</body>
</html>


