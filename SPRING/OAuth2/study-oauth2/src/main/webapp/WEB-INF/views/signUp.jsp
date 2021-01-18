<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUp Page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.2/flatly/bootstrap.min.css" integrity="sha384-qF/QmIAj5ZaYFAeQcrQ6bfVMAh4zZlrGwTPY7T/M+iTTLJqJBJjwwnsE5Y0mV7QK" crossorigin="anonymous">
<link rel="stylesheet" href="/resources/bootstrap.min.css">
<!-- Global Site Tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-23019901-1"></script>
<script>
	window.dataLayer = window.dataLayer || [];
    function gtag(){
        dataLayer.push(arguments);
    }
    gtag('js', new Date());
	gtag('config', 'UA-23019901-1');
</script>
</head>
<body>
	<div class="navbar navbar-expand-lg fixed-top navbar-dark bg-primary">
      <div class="container">
        <a href="" class="navbar-brand">Bootswatch</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav">
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" id="themes">Themes <span class="caret"></span></a>
              <div class="dropdown-menu" aria-labelledby="themes">
                <a class="dropdown-item" href="">Default</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="">Cerulean</a>
                <a class="dropdown-item" href="">Cosmo</a>
                <a class="dropdown-item" href="">Cyborg</a>
                <a class="dropdown-item" href="">Darkly</a>
                <a class="dropdown-item" href="">Flatly</a>
                <a class="dropdown-item" href="">Journal</a>
                <a class="dropdown-item" href="">Litera</a>
                <a class="dropdown-item" href="">Lumen</a>
                <a class="dropdown-item" href="">Lux</a>
                <a class="dropdown-item" href="">Materia</a>
                <a class="dropdown-item" href="">Minty</a>
                <a class="dropdown-item" href="">Pulse</a>
                <a class="dropdown-item" href="">Sandstone</a>
                <a class="dropdown-item" href="">Simplex</a>
                <a class="dropdown-item" href="">Sketchy</a>
                <a class="dropdown-item" href="">Slate</a>
                <a class="dropdown-item" href="">Solar</a>
                <a class="dropdown-item" href="">Spacelab</a>
                <a class="dropdown-item" href="">Superhero</a>
                <a class="dropdown-item" href="">United</a>
                <a class="dropdown-item" href="">Yeti</a>
              </div>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="">Help</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="https://blog.bootswatch.com/">Blog</a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" id="download">Flatly <span class="caret"></span></a>
              <div class="dropdown-menu" aria-labelledby="download">
                <a class="dropdown-item" rel="noopener" target="_blank" href="https://jsfiddle.net/bootswatch/jmg3gykg/">Open in JSFiddle</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="" download>bootstrap.min.css</a>
                <a class="dropdown-item" href="" download>bootstrap.css</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="" download>_variables.scss</a>
                <a class="dropdown-item" href="" download>_bootswatch.scss</a>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </div>

    <div class="container">
      <div class="page-header" id="banner">
        <div class="row">
          <div class="col-lg-8 col-md-7 col-sm-6">
            <h1>Flatly</h1>
            <p class="lead">Flat and modern</p>
          </div>
          <div class="col-lg-4 col-md-5 col-sm-6">
            <div class="sponsor">
              <script async src="https://cdn.carbonads.com/carbon.js?serve=CKYIE23N&placement=bootswatchcom" id="_carbonads_js"></script>
            </div>
          </div>
        </div>
      </div>
	  
      <!-- Forms
      ================================================== -->
      <div class="bs-docs-section">
        <div class="row">
          <div class="col-lg-12">
            <div class="page-header">
              <h1 id="forms">Forms</h1>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-lg-6">
            <div class="bs-component">
              <form action="/signUp" method="POST">
              	<c:set var="user" value="${ user }" />
                <fieldset>
<!--                   <legend>Legend</legend> -->
				  <input type="hidden" id="exampleInputId" name="userId" value="${ user.userId }">
				  <input type="hidden" id="exampleInputSocial" name="social" value="${ user.social }">
                  <div class="form-group">
                    <label for="exampleInputEmail">Email address</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" name="userEmail" aria-describedby="emailHelp" placeholder="${ user.userEmail }" value="${ user.userEmail }">
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                  </div>
                  <div class="form-group">
                    <label for="exampleInputName">이름</label>
                    <input type="text" class="form-control" id="exampleInputName" name="userName" placeholder="${ user.userName }" value="${ user.userName }">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPhone">전화번호</label>
                    <input type="text" class="form-control" id="exampleInputPhone" name="userPhone" placeholder="${ user.userPhone }" value="${ user.userPhone }">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputAddress">주소</label>
                    <input type="text" class="form-control" id="exampleInputAddress" name="userAddress" placeholder="">
                  </div>
                  <button type="submit" class="btn btn-primary">Submit</button>
                </fieldset>
              </form>
            </div>
          </div>
        </div>
      </div>

      <footer id="footer">
        <div class="row">
          <div class="col-lg-12">
            <ul class="list-unstyled">
              <li class="float-lg-right"><a href="#top">Back to top</a></li>
              <li><a href="https://blog.bootswatch.com/">Blog</a></li>
              <li><a href="https://blog.bootswatch.com/rss/">RSS</a></li>
              <li><a href="https://twitter.com/bootswatch">Twitter</a></li>
              <li><a href="https://github.com/thomaspark/bootswatch">GitHub</a></li>
              <li><a href="">API</a></li>
              <li><a href="">Donate</a></li>
            </ul>
            <p>Made by <a href="https://thomaspark.co/">Thomas Park</a>.</p>
            <p>Code released under the <a href="https://github.com/thomaspark/bootswatch/blob/master/LICENSE">MIT License</a>.</p>
            <p>Based on <a href="https://getbootstrap.com/" rel="nofollow">Bootstrap</a>. Icons from <a href="https://fontawesome.com/" rel="nofollow">Font Awesome</a>. Web fonts from <a href="https://fonts.google.com/" rel="nofollow">Google</a>.</p>

          </div>
        </div>
      </footer>
    </div>
	
<!--     <script src="../_vendor/jquery/dist/jquery.min.js"></script>
    <script src="../_vendor/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
    <script src="../_assets/js/custom.js"></script> -->
</body>
</html>