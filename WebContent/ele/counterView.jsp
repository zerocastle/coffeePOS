
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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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
<script src="productList/productButton.js" charset="UTF-8"></script>
<script>
	function search(value) {

		var search = value;
		alert(value);
		var query = {
			pName : value
		};
		$.ajax({

			type : "POST",
			url : "/coffeePOS/product/counter.do",
			data : query,
			success : function(data) {

				window.location.href = "/coffeePOS/index.jsp";

			}

		})

	}

	function pointUse() {
		var totalMoney = $('#totalMoney').val();
		var clientPoint = $('#pointPrepared').val();

		var payMentMoney = totalMoney - clientPoint;
		var stackPoint = Number(payMentMoney)* 0.1;
		alert(stackPoint);
		$('#payMentMoney').val(payMentMoney);
		$('#clientStackPoint').val(stackPoint); 
		
	}
	
	/* function payMent(){
		$.ajax({
			var query={
					
			}
		})
	} */

</script>

</head>
<body>
	<div>
		<div class="main">
			<div class="a">
				<div id="mainContent">

					<div id="basket" style="overflow-y: auto; height: 400px;">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Product</th>
									<th>Price</th>
									<th>Count</th>

								</tr>
							</thead>
							<tbody>




								<c:forEach items="${sessionScope.counterList}" var="item">

									<tr>
										<td>${item[0]}</td>
										<td>${item[1]}</td>
										<td>${item[2]}</td>

									</tr>
									<c:set var="total" value="${item[2]}"></c:set>
								</c:forEach>

							</tbody>
						</table>


					</div>

					<!-- 리스트 창 -->

				</div>
			</div>



			<div class="b">
				<table class="table">
					<tr>
						<td>총 금액
							<div class="b-1">
								<input class="input-medium" type="text" size="6" length="6"
									value="${total}" id="totalMoney">
							</div>
						</td>
					</tr>
					<tr>
						<td>적립금 사용 <input class="input-small" type="textbox"
							id="pointPrepared" />
							<button class="btn btn-default" id="pointuse"
								onclick="pointUse();">사용</button></td>
					<tr>
						<td>결제 금액 <input type="text" id="payMentMoney" width="8" onclick="payMent()">
						</td>
					<tr>
						<td>적립금
							<div>
								<input type="text" id="clientStackPoint"/>
							</div>
						</td>
				</table>
			</div>


			<div class="c">
				<div class="c-1">
					<input class="input-large" type="textbox">
					<button class="btn btn-large" id="clePointSearch">조회</button>
					<div class="c-1-1">
						<input type="text" id="clientInfo">님 의 사용 가능한 적립금은 <input
							type="text" id="clientPoint" /><input type="text" id="clientId" style="color : brown;" />
					</div>
				</div>
				<div class="c-2">
					<button class="btn btn-block" id="payment">결제</button>
					<button class="btn btn-block-1" id="cancle">취소</button>
				</div>

			</div>
		</div>
</body>
</html>


