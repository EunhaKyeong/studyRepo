<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Products</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>Shop Homepage - Start Bootstrap Template</title>

	<!-- Bootstrap core CSS -->
	<link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
	
	<!-- Custom styles for this template -->
	<link href="${pageContext.request.contextPath}/resources/css/shop-homepage.css" rel="stylesheet"/> 
</head>
<body>
  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="/">Start Bootstrap</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="#">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">About</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Services</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Contact</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Content -->
  <div class="container">

    <div class="row">

      <div class="col-lg-3">

        <h1 class="my-4">Shop Name</h1>
        <div class="list-group">
          <c:forEach items="${ categoryList }" var="category">
	          <a href="/category/${ category.category_id }" class="list-group-item">${ category.category_name }</a>
	      </c:forEach>
        </div>

      </div>
      <!-- /.col-lg-3 -->

      <div class="col-lg-9">
        <div class="row">
          <c:set var="products" value="${ productList }"/>
		  <c:choose>
		  	<%-- 카레고리가 비어있을 경우 --%>
		  	<c:when test="${ empty products }">
		  		<h2>현재 카테고리에 해당하는 상품이 존재하지 않습니다.</h2>
		  	</c:when>
		  	<%-- 카테고리에 상품이 있을 경우 --%>
		  	<c:otherwise>
		  	  <c:forEach items="${ products }" var="list">
		          <div class="col-lg-4 col-md-6 mb-4">
		            <div class="card h-100">
			              <a href="#"><img class="card-img-top" src="${ list.product_img }"></a>
			              <div class="card-body">
			                <h4 class="card-title">
			                  <a href="#">${ list.product_name }</a>
			                </h4>
			                <h5>${ list.product_price }</h5>
			                <p class="card-text">${ list.seller }</p>
			              </div>
		              <div class="card-footer">
		                <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
		              </div>
		            </div>
		          </div>
		        </c:forEach>
	         </c:otherwise>
	      	</c:choose>
          </div>
          <!-- /.row -->
      </div>
      <!-- /.col-lg-9 -->
    </div>
    <!-- /.row -->
  </div>
  <!-- /.container -->

  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; Your Website 2020</p>
    </div>
    <!-- /.container -->
  </footer>

	<!-- Bootstrap core JavaScript -->
  	<script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>