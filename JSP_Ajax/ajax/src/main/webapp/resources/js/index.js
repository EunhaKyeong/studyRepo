$("#registerButton").click(function() {
	var name = $("#registerName").val();	//user 이름
	var age = $("#registerAge").val();	//user 나이
	var gender = $("input:radio[name='registerGender']:checked").val();	//user 성별
	var email = $("#registerEmail").val();	//user 이메일
	
	$.ajax({
		url : "/insertUser",
		type: "POST",
		data : {"name" : name,
				"age" : age, 
				"gender" : gender, 
				"email" : email}, 
		success : function(data) {
			var html = "";
			html += "<td>" + data.name + "</td>";
			html += "<td>" + data.age + "</td>";
			html += "<td>" + data.gender + "</td>";
			html += "<td>" + data.email + "</td>";
			
			$("#ajaxTr").html(html);
			alert("등록 성공");
		},
		error : function() {
			alert("등록 실패");
		}
	});
})