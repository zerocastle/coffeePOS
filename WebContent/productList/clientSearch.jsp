<!-- 고객 삭제 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<style>
h1 {
	text-align: center;
}

#wrapper {
	border: 1px solid black;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="productButton.js" charset="UTF-8"></script>

<script>
	$(document).ready(function() {
		$('#search').click(function() {
			var query = {
				cId : $('#cName').val()

			};

			$.ajax({
				type : "POST",
				url : "/coffeePOS/product/client/search.do",
				data : query,
				success : function(data) {

					var a = JSON.parse(data);
					if (a.cId[0] == "0") {
						alert("그런 회원은 없어요");
					} else if (a.cId[0] == "1") {
						alert(a.cId[1] + "님 확인 완료");
						/* $('#result').html("<span id='cId'>"+ a.cId[1] + "</span>님 의 사용 가능한 포인트 금액은 <span id='cPoint'>" + a.cId[2] + "</span>원 입니다" + 
								"<button id='use'>확인</button><button id='cancel'>취소</button>"); */
						$('#clientName').val(a.cId[1]);
						$('#availableMoney').val(a.cId[2]);
					}

				}
			})

			$('#use').click(function() {

				var query = {
					cId : $('cId').val(),
					cPoint : $('cPoint').val()
				};
				$.ajax({
					type : "POST",
					url : "/coffeePOS/ele/counterView.jsp",
					data : query,
					success : function() {
						window.opener.$('#clientInfo').val($('#clientName').val());
						window.opener.$('#clientPoint').val($('#availableMoney').val());
						close();
					}
				
				})
			})

		})
	})
</script>
</head>
<body>
	<div id="wrapper">
		<h1>고객 검색</h1>
		<table width="300" height="300" align="center">

			<tr>
				<td align="center" id="cId">아이디</td>
				<td><input type="text" placeholder="고객 검색" id="cName"></td>
				<td><button id="search" class="btn">검색</button></td>
			</tr>
		</table>
	</div>

	<div id="result">
		<input type="text" id="clientName" /> 님 의 사용 가능한 포인트 금액은 <input
			type="text" id="availableMoney"/> 입니다.
		<button id="use">확인</button>
		<button id="cancle">취소</button>
	</div>
</body>
</html>