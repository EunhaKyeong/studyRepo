<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>This is Member Page!</h1>
	<hr>
	<form method="post" action="/members">
		Email <input type="text" id="email" name="email">
		<input type="submit" id="submit" value="이메일 등록">
	</form>
</body>
</html>