/**
 * 
 */

$(document).ready(
		function() {
			var windo = null;
			$('#refresh').click(function() {
				window.location.href = "/coffeePOS/mng/employeeList.do";
			});
			// 파업창 띄우기
			$('#employeeRegister').click(
					function() {
						window = window.open("register.jsp", "register",
								"width=300, height=360");
					});
			$('#employeeDelete').click(
					function() {
						window = window.open("delete.jsp", "delete.jsp",
								"width=300, height=360");
					});

			// 사원 등록

			$('#registerSubmit').click(function() {
				var query = {
					id : $('#eNum').val(),
					pw : $('#ePhone').val(),
					name : $('#eName').val(),
					pay : $('#ePay').val()
				};

				$.ajax({

					type : "POST",
					url : "/coffeePOS/mng/employeeInsert.do",
					data : query,
					success : function(data) {
						var array = JSON.parse(data);
						
						if (array.name[0] == "1") {
							alert(array.name[1] + "사원이 등록 되었습니다..");
							$('#wrapper').html(
									"<div>" + array.name[1]
											+ "님 등록완료</div>");
						}
					}
				})

			})
			
			//사원 삭제
			
			$('#deleteEmployee').click(function(){
				var query = {
						id : $('#dId').val()
					};

					$.ajax({
						type : "POST",
						url : "/coffeePOS/mng/employeeDelete.do",
						data : query,
						success : function(data) {
							var array = JSON.parse(data);
							if (array.name[0] == "1") {
								alert(array.name[1] + "님 이 삭제 되었습니다.");
								$('#wrapper').html(
										"<div>" + array.name[1]
												+ "님 삭제완료</div>");
							}else if(array.name[0] == "0"){
								alert("삭제 실패 !!");
							}
						}
					})
			})
		})