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
	$('#refresh').click(function(){
		window.location.href="/coffeePOS/ele/employeeList.do";
	})
})
