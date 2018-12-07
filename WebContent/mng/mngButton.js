/**
 * 
 */
var state = false;
$(document)
		.ready(
				function() {
					var windo = null;
					$('#refresh')
							.click(
									function() {
										window.location.href = "/coffeePOS/mng/employeeList.do";
									});
					// 파업창 띄우기
					$('#employeeRegister').click(
							function() {
								window = window.open("register.jsp",
										"register", "width=300, height=360");
							});
					$('#employeeDelete').click(
							function() {
								window = window.open("delete.jsp",
										"delete.jsp", "width=300, height=360");
							});
					// 사원수정
					$('#employeeModify').click(
							function() {
								window = window.open("delete.jsp",
										"delete.jsp", "width=300, height=360");
							});

					// 사원 등록

					$('#registerSubmit')
							.click(
									function() {
										if (state) {
											var query = {
												id : $('#eNum').val(),
												pw : $('#ePhone').val(),
												name : $('#eName').val(),
												pay : $('#ePay').val()
											};

											$
													.ajax({

														type : "POST",
														url : "/coffeePOS/mng/employeeInsert.do",
														data : query,
														success : function(data) {
															var array = JSON
																	.parse(data);

															if (array.name[0] == "1") {
																alert(array.name[1]
																		+ "사원이 등록 되었습니다..");
																$('#wrapper')
																		.html(
																				"<div>"
																						+ array.name[1]
																						+ "님 등록완료</div>");
															}
														}
													})
										} else {
											alert("아이디 체크를 해주세요");
										}

									})

					// 사원 삭제

					$('#deleteEmployee').click(
							function() {
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
											alert(array.name[1]
													+ "님 이 삭제 되었습니다.");
											$('#wrapper').html(
													"<div>" + array.name[1]
															+ "님 삭제완료</div>");
										} else if (array.name[0] == "0") {
											alert("삭제 실패 !!");
										}
									}
								})
							})

					// 사원 체크
					$('#userCheck').click(
							function() {
								var query = {
									id : $('#eNum').val()
								};

								$.ajax({
									type : "post",
									url : "/coffeePOS/mng/employeeCheck.do",
									data : query,
									success : function(data) {
										if (data == 1) {
											alert("사용 불가능한 아이디 입니다.");
										} else if (data == 0) {
											alert("사용 가능한 아이디 입니다.");
											$('#registerSubmit').html(
													'<button>확인완료</button>');
											checkIt();
										}
									}
								})
							})
					$('#modifyMember').click(
							function() {
								var query = {
									eNum : $('#eNum').val(),
									ePhone : $('#ePhone').val()
								};

								$.ajax({
									type : "POST",
									url : "/coffeePOS/mng/employeeModify.do",
									data : query,
									success : function(data) {
										var array = JSON.parse(data);
										if (array.name[0] >= 1) {
											alert(array.name[1] + "님 수정 완료");
											$('#wrapper').html(
													"<div>비밀번호 수정 완료</div>");
											close();
										} else {
											alert("수정 실패");
											close();
										}
									}
								})
							})
					$('#cancle').click(function() {
						close();
					})
				})
function checkIt() {
	state = true;
}