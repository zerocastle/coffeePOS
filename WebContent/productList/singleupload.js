$(document).ready(function() {
	// Ajax방식으로 요청페이지를 호출해 파일을 업로드한다.

	//	$('#upload').click(function() {
	//		var query = {
	//			fileName : $('#fileName').val(),
	//			filePrice : $('#filePrice').val(),
	//			category : $('#category').val()
	//		};
	//		$("#fileUpload").ajaxForm({
	//			type : "POST",
	//			url : " /coffeePOS/file/upload.do",
	//			data : query,
	//			success : function(data, status) {// 업로드에 성공하면 수행
	//
	//			}
	//		});
	//	})

	$("#fileUpload").ajaxForm({
		success : function(data, status) { //업로드 성공하면 수행
			window.location.href = "/coffeePOS/file/upload.do";
		}
	});

});