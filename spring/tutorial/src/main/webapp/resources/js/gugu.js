$(function(){
	$("#gugu_submit").click(function() {
		dan = $("#dan").val();
		param = {"dan":dan};
		$.ajax( {
			type:"post", 
			url:"gugu_ajax_result.do", 
			data:param,
			success:function(result) {
				$("#gugu_result").html(result);
			} 
		});
	});
});