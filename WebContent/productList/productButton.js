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
				alert("눌러지니??");
				var query = {
					cId : $('#clientId').val(),
					ptUsed : $('#pointPrepared').val(),
					pointMoney : $('#clientStackPoint').val(),
					pMoney : $('#payMentMoney').val()
				};
				$.ajax({
					type : "POST",
					url : "/coffeePOS/product/payment/insert.do",
					data : query,
					success: function(data){
						if(data == 1){
							alert("결제 성공");
						}
						window.location.href="/coffeePOS/index.jsp";
					}
				})
			});

		})
