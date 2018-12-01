/**
 * 카테고리 버튼 눌렀을때
 */

$(document).ready(function() {

	$('#category>ul li:eq(0)>a').click(function() {
		// alert($('#product').html());
		$('#coffee').show();
		$('#tea').hide();
		$('#bread').hide();

	})
	$('#category>ul li:eq(1)>a').click(function() {
		$('#coffee').hide();
		$('#tea').show();
		$('#bread').hide();
	})
	$('#category>ul li:eq(2)>a').click(function() {
		$('#coffee').hide();
		$('#tea').hide();
		$('#bread').show();
	})

	$('#logout').click(function() {
		$.ajax({
			type : "POST",
			url : "/coffeePOS/index/logout.do",
			success : function(data) {

				alert("로그 아웃 하셨습니다.");
				window.location.href = "index.jsp";
			}
		})
	})
	

})