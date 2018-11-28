/**
 * 클라이언트 로그인 당담
 */

$(document).ready(function() {
	
	$('#cltLogin').click(function() {
		var query = {
				id : $('#cId').val(),
				pw : $('#cPw').val()
			};
		alert("눌러짐?")
		$.ajax({
			type : "POST",
			url : "/coffeePOS/clt/clientLogin.do",
			data : query,
			success : function(data) {
				console.log(data);
				alert(data)
				if (data == 1) {
					alert("로그인성공");
					// locaiton.href="../index.jsp";
					window.location.href = "clientChartView.jsp";
					// window.location.href="ajaxCome/test.jsp";
					// 하 href 개 짜증나네 ... 비동기 처리 location 이동..
				} else if (data == -1) {
					alert("비밀번호 틀림");
					window.location.href = "clientChartView.jsp";
				} else {
					alert("그런 회원은 존재하지 않습니다.");
					window.location.href = "clientChartView.jsp";
				}
			}
		})
	})

})