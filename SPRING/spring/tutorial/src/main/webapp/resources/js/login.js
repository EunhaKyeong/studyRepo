$(function() {	//페이지가 로드되면 실해한다.
	$("#btnLogin").click(function() {
		//http://localhost:8080/ajax2의 로그인폼에 입력한 아이디, 비밀번호
		id = $("#id").val();
		pw = $("#pw").val();
		param = {"id":id, "pw":pw};
		//비동기식 호출	
		$.ajax( {
			type:"post",
			url:"login_result.do",
			data:param,
			success:function(result) {
				$("#login_result").html(result);
			}
		});
	});
});