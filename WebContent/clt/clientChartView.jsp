<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
/* h2 {
	text-align: center;
} */
th {
	background-color: #a0b5a2;
}

table, th, td {
	text-align: center;
	padding: 10px;
	border-collapse: collapse;
}

td {
	border-bottom: 1px solid #EAEAEA;
}

table {
	table-layout: fixed;
	border-coollapse: collapse;
	text-align: center;
}

/* table {
	width: 500px;
} */
div {
	max-height: 300px;
	overflow-y: auto;
	overflow-x: hidden;
	width: 500px;
}

tbody tr:nth-child(2n) {
	background-color: #fbfbfb;
}
</style>
<script>
	$(function() {
		var query = {
			cId : "${clientLogincId}"
		};
		$.ajax({
			type : "POST",
			url : "/coffeePOS/clt/show/list.do",
			data : query,
			success : function(data) {

			}
		})
	})
</script>
</head>
<h2>
	<span style="color: brown;">${sessionScope.clientLogincId }</span> 님 <br>사용가능
	적립금 :
</h2>
<body>
	<table width="500" height="50" border="1" rules="none">
		<colgroup>

			<col width="5%">
			<col width="15%">
			<col width="20%">
			<col width="18%">
			<col width="21%">
		</colgroup>
		<thead>
			<tr>
				<th>순번</th>
				<th>결제코드</th>
				<th>날짜</th>
				<th>결제금액</th>
				<th>적립금액</th>
				<th>사용금액</th>
			</tr>
		</thead>
	</table>

	<div>
		<table width="485" height="350" align="center" border="1" rules="none">
			<colgroup>
				<col width="5%">
				<col width="18%">
				<col width="20%">
				<col width="20%">
				<col width="20%">
			</colgroup>
			<tbody>
				<c:forEach items="${sessionScope.clientInformationList}" var="item">
					<c:set var="counter" value="${counter + 1 }"></c:set>
					<tr>
						<td><c:out value="${counter}"></c:out></td>
						<td>${item.getpCOde()}</td>
						<td>${item.getpDate()}</td>
						<td>${item.getPtUsed()}</td>
						<td>${item.getpMoney()}</td>
						</tr>

				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>