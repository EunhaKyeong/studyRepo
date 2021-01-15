<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
</head>
<body>
	<h1>This is main page!</h1>
	<c:if test="${ userName!=null }">
		<p>${ userName }님 반갑습니다!</p>
		<a href="logout"><button>로그아웃</button></a>
	</c:if>
	<c:if test="${ userName==null }">
		<a href="/login"><button>로그인</button></a>
	</c:if>
</body>
</html>