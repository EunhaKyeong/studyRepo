<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
<br>
	<jsp:include page="../include/menu.jsp" />
	id <input type="text" id="id"> 
	pw <input type="password" id="pw">
	<input type=button id="btnLogin" value="로그인">
	
	<div id="login_result"></div>
	
	<script src="/resources/js/login.js"></script>
</body>
</html>