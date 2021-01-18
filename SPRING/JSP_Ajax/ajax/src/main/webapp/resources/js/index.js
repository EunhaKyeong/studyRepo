$("#registerButton").click(function() {
	var name = $("#registerName").val();	//user 이름
	var age = Number($("#registerAge").val());	//user 나이
	var gender = $("input:radio[name='registerGender']:checked").val();	//user 성별
	var email = $("#registerEmail").val();	//user 이메일
	var form = {"userName" : name,
				"userAge" : age, 
				"userGender" : gender, 
				"userEmail" : email};
			
	$.ajax({
		url: "/",
	    type: "POST",
	    data: JSON.stringify(form),
	    contentType: "application/json; charset=utf-8;",
	    dataType: "json",
		success : function(data) {
			var html = "";
			html += "<tr>";
			html += "<td>" + data.userName + "</td>";
			html += "<td>" + data.userAge + "</td>";
			html += "<td>" + data.userGender + "</td>";
			html += "<td>" + data.userEmail + "</td>";
			html += "</tr>";
					
			$("#ajaxTable").append(html);
			alert("등록 성공");
		},
		error : function() {
			alert("등록 실패");
		}
	});
});