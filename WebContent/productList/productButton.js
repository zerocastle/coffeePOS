/**
 * 
 */

$(document).ready(
		function() {
			$('#cancle').click(function() {
				$.ajax({
					type : "POST",
					url : "/coffeePOS/product/session/reset.do",
					data : null,
					success : function(data) {
						location.reload();

					}
				});

			});
			// 고객포인트 서치
			$('#clePointSearch').click(
					function() {
						window = window.open("productList/clientSearch.jsp",
								"search", "width=400,height=450");
					});

			//고객 인서트
			$('#payment').click(function() {
				var query = {
					cId : $('#clientId').val(),
					ptUsed : $('#pointPrepared').val(),
					pointMoney : $('#clientStackPoint').val(),
					pMoney : $('#payMentMoney').val(),
					totalMoney : $('#totalMoney').val() // 이 녀석은 고객정보가 없을때 비회원 로그인을 처리 해주기 위해서 만들었다
				};
				$.ajax({
					type : "POST",
					url : "/coffeePOS/product/payment/insert.do",
					data : query,
					success: function(data){
						if(data == 1){
							alert("결제 성공");
						}else{
							alert("결제 실패");
						}
						window.location.href="/coffeePOS/index.jsp";
					}
				})
			});

		})
