/**
 * 
 */

$(document).ready(function(){
	var windo = null;
	$('#refresh').click(function(){
		window.location.href="/coffeePOS/mng/employeeList.do";
	});
	//파업창 띄우기
	$('#clietRegister').click(function(){
		window = window.open("register.jsp",  "register", "width=300, height=360");
	});
	$('#clientDelete').click(function(){
		window = window.open("delete.jsp",  "delete.jsp", "width=300, height=360");
	});
})