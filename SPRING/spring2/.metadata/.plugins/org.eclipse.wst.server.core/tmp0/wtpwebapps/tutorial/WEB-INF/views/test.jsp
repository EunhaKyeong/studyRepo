<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test</title>
</head>
<body>
	<!-- form enctype="multipart/form-data"를 적어줘야 한다. -->
	<!-- form 태그의 enctype을 multipart/form-data로 설정해줘야 파일업로드 기능이 적용된다. -->
	<form action="/test" enctype="multipart/form-data" method="post">
		<input type="file" name="imgFile" />
		<input type="submit" value="이미지저장"/>
	</form>
</body>
</html>