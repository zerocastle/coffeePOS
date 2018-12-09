/**
 * 클라이언트 로그인 당담
 */

$(document).ready(function() {

	$('#cltLogin').click(function() {
		var query = {
			id : $('#cId').val(),
			pw : $('#cPw').val()
		};

		$.ajax({
			type : "POST",
			url : "/coffeePOS/clt/clientLogin.do",
			data : query,
			success : function(data) {
				console.log(data);
				if (data == 1) {
					alert("로그인 성공");
					window.location.href = "/coffeePOS/clt/clientChartView.jsp";
					
				} else if (data == -1) {
					alert("비밀번호 틀림");
					location.reload();
				} else {
					alert("그런 회원은 존재하지 않습니다.");
					location.reload();
				}
			}
		})
	})

})