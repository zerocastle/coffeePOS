/**
 * managerEmployeeView 버튼들
 */

// $.get('data/list.json', function(data) {
// console.log(data);
// var employees = data.employee;
// var table = $('#table');
//
// for ( var i in employees) {
// var list = employees[i];
// var cnt = 1;
// for ( var j in list) {
// var text = list[j];
// var tr = table.find('tr').eq(parseInt(i) + 1);
// var td = tr.find('>td').eq(cnt + 1);
// td.text(text);
// cnt++;
// }
//
// }
//
// }, 'json');
$(document).ready(
		function() {
			var windo = null;
			$('#refresh').click(function() {
				window.location.href = "/coffeePOS/ele/clientList.do";
			});
			// 파업창 띄우기
			$('#clietRegister').click(
					function() {
						window = window.open("register.jsp", "register",
								"width=400,height=450");
					});
			$('#clientDelete').click(
					function() {
						window = window.open("delete.jsp", "delete.jsp",
								"width=300, height=360");
					});

			// 회원 가입
			$('#registerSubmit').click(function() {
				var query = {
					id : $('#cId').val(),
					pw : $('#cPhone').val(),
					name : $('#cName').val()
				};
				$.ajax({
					type : "POST",
					url : "/coffeePOS/ele/clientInsert.do",
					data : query,
					success : function(data) {
						var array = JSON.parse(data);

//						alert(array.name[0]); //파싱된 객체에 key값에 인덱스로 접근한다.

						if (array.name[0] == "1") {
							alert(array.name[1] + "님 이 가입 되었습니다.");
							$('#wrapper').html("<div>" + array.name[1] + "님 가입완료</div>");
						}
					}
				})
			})
		})
