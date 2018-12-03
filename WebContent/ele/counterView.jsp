<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width = device-width, initial-scale = 1.0">
<link href="css/bootstrap-responsive.css" rel="stylesheet">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/counterView.css">
<title>Insert title here</title>
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
								<tr>
									<td>아메리카노</td>
									<td>1500원</td>
									<td><i class="fa fa-minus" title="Decrease Qty"></i> <input
										class="qty" value="3" name="qty" maxlength="3" /> <i
										class="fa fa-plus" title="Increase Qty"></i></td>
									<td>4500원</td>
									<td class="last"><i class="fa fa-trash-o"
										title="Delete Item"></i></td>
								</tr>
							</tbody>
						</table>


					</div>
				</div>
			</div>
			<div class="bcd">
				<div class="b">
					<p class="b-1">총 금액</p>
					<p class="b-2">
						적립금 사용 <input class="text1" type="textbox">
						<button class="btn btn-large">사용</button>
					</p>
					<p class="b-3">결제 금액</p>
					<p class="b-4">적립금</p>
				</div>
				<div class="c">
					<div class="c-1">
						<input class="text2" type="textbox">
						<button class="btn">조회</button>
					</div>
					<div class="c-2">적립금 정보</div>
				</div>
				<div class="d">
					<button class="button1">결제</button>
					<button class="button2">삭제</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>