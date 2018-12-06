/**
 * 
 */

$(document).ready(function(){
	
	
	$('#add').click(function(){
		var a = ('#table').eq().attr('id');
		var query={
			pName : $('').value(),
			pPrice : $('#item.pPrice').value()
		};
		
		$.ajax({
			type : "POST",
			url : "/coffeePOS/add.do",
			data : query,
			success : function(data){
				if(data == 1){
					window.location.href="/coffee/get/counter.do";
				}
			}
		})
	})
})