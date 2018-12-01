/**
 * 컨텐츠 목록 클릭
 */

// 사원이 고객 관리를 눌렀을떄
$(document).ready(function(){
	$('#home').click(function(){
		window.location.href="/coffeePOS/index.jsp"
	})

	$('#menuList>div>div>ul li:eq(0)>a').click(function() {
		window.location.href = "/coffeePOS/ele/managerClientView.jsp";
	});
	$('#menuList>div>div>ul li:eq(1)>a').click(function() {
		window.location.href = "/coffeePOS/mng/managerEmployeeView.jsp";
	});
	$('#menuList>div>div>ul li:eq(2)>a').click(function() {
		window.location.href = "/coffeePOS/mng/mngChartView.jsp";
	});
	$('#menuList>div>div>ul li:eq(3)>a').click(function() {
		window.location.href = "/coffeePOS/mng/managerPoint.jsp";
	});
	$('#menuList>div>div>ul li:eq(4)>a').click(function() {
		window.location.href = "/coffeePOS/mng/managerMenu.jsp";
	});
})


