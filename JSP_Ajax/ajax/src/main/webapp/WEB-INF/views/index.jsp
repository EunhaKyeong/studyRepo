<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP AJAX</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
</head>
<body>
	<br>
	<div class="container">
		<div class="form-group row pull-right">
			<div class="col-xs-8">
				<input class="form-control" type="text" size="20">
			</div>
			<div class="col-xs-2">
				<button class="btn btn-primary" type="button">검색</button>
			</div>
		</div>
		<table class="table" style="text-align: center; border: 1px solid #dddddd">
			<thead>
				<tr>
					<th style="background-color: #fafafa; text-align:center;">이름</th>
					<th style="background-color: #fafafa; text-align:center;">나이</th>
					<th style="background-color: #fafafa; text-align:center;">성별</th>
					<th style="background-color: #fafafa; text-align:center;">이메일</th>
				</tr>
			</thead>
			<tbody id="ajaxTable">
				<c:forEach items="${userList}" var="user">
				<tr>
					<td>${user.userName}</td>
					<td>${user.userAge}</td>
					<td>${user.userGender}</td>
					<td>${user.userEmail}</td>
				</tr>
				</c:forEach>
				<tr id="ajaxTr">
				</tr>
			</tbody>
		</table>	
	</div>
	<div class="container">
		<table class="table" style="text-align:center; border:1px solid #dddddd">
			<thead>
				<tr>
					<th colspan="2" style="background-color: #fafafa; text-align:center;">회원 등록 양식</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td style="background-color: #fafafa; text-align:center;"><h5>이름</h5></td>
					<td><input class="form-control" type="text" id="registerName" size="20"></td>
				</tr>
				<tr>
					<td style="background-color: #fafafa; text-align:center;"><h5>나이</h5></td>
					<td><input class="form-control" type="text" id="registerAge" size="20"></td>
				</tr>
				<tr>
					<td style="background-color: #fafafa; text-align:center;"><h5>성별</h5></td>
					<td>
						<div class="form-group" style="text-align:center; margin:0 auto;">
							<div class="btn-group" data-toggle="buttons">
								<label class="btn btn-primary">
									<input type="radio" name="registerGender" autocomplete="off" value="남자" checked>남자
								</label>
								<label class="btn btn-primary">
									<input type="radio" name="registerGender" autocomplete="off" value="여자">여자
								</label>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<td style="background-color: #fafafa; text-align:center;"><h5>이메일</h5></td>
					<td><input class="form-control" type="text" id="registerEmail"></td>
				</tr>
				<tr>
					<td colspan="2"><button class="btn btn-primary pull-right" id="registerButton" type="button">등록</button>
				</tr>
			</tbody>
		</table>
	</div>
	
	<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/index.js"></script>
</body>
</html>