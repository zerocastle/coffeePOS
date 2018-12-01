/**
 * managerEmployeeView 버튼들
 */

//$.get('data/list.json', function(data) {
//	console.log(data);
//	var employees = data.employee;
//	var table = $('#table');
//
//	for ( var i in employees) {
//		var list = employees[i];
//		var cnt = 1;
//		for ( var j in list) {
//			var text = list[j];
//			var tr = table.find('tr').eq(parseInt(i) + 1);
//			var td = tr.find('>td').eq(cnt + 1);
//			td.text(text);
//			cnt++;
//		}
//
//	}
//
//}, 'json');

$(document).ready(function(){
	var windo = null;
	$('#refresh').click(function(){
		window.location.href="/coffeePOS/ele/clientList.do";
	});
	//파업창 띄우기
	$('#clietRegister').click(function(){
		window = window.open("register.jsp",  "register", "width=300, height=360");
	});
	$('#clientDelete').click(function(){
		window = window.open("delete.jsp",  "delete.jsp", "width=300, height=360");
	});
})
