/**
 * 메인 화면 로그인 js
 */

$(document).ready(function() {
	$('#eSubmit').click(function() {
		var query = {
			id : $('#eId').val(),
			pw : $('#ePw').val()
		};
		$.ajax({
			type : "POST",
			url : "/coffeePOS/index/employeeLogin.do",
			data : query,
			success : function(data) {
				console.log(data);
				
				if (data == 1) {
					alert("로그인성공");
					// locaiton.href="../index.jsp";
					window.location.href = "index.jsp";
					// window.location.href="ajaxCome/test.jsp";
					// 하 href 개 짜증나네 ... 비동기 처리 location 이동..
				} else if (data == -1) {
					alert("비밀번호 틀림");
					window.location.href = "index.jsp";
				} else {
					alert("그런 회원은 존재하지 않습니다.");
					window.location.href = "index.jsp";
				}

			}
		});
	});

	$('#mSubmit').click(function() {
		var query = {
			id : $('#mId').val(),
			pw : $('#mPw').val()
		};

		$.ajax({
			type : "POST",
			url : "/coffeePOS/index/managerLogin.do",
			data : query,
			success : function(data) {
				console.log(data);
				
				if (data == 1) {
					alert("로그인성공");
					// locaiton.href="../index.jsp";
					window.location.href = "index.jsp";
					// window.location.href="ajaxCome/test.jsp";
					// 하 href 개 짜증나네 ... 비동기 처리 location 이동..
				} else if (data == -1) {
					alert("비밀번호 틀림");
					window.location.href = "index.jsp";
				} else {
					alert("그런 회원은 존재하지 않습니다.");
					window.location.href = "index.jsp";
				}
			}
		})
	})
});
