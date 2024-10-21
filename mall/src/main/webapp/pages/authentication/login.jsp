<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Login</title>
	<style>
	.wrapper{
	 	background-image: url("${pageContext.request.contextPath}/resources/image/background/loginbg.jpg"); /* 이미지 경로 설정 */
	    background-size: cover; 
	    background-position: center; 
	    width: 100%;
	    height: 100vh; 
	}
	</style>
	<link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet" />
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<div class="wrapper">
	<jsp:include page="/global/navbar.jsp"></jsp:include>
	<div class="container login-container">
	      <div class="row">
	          <div class="col-md-6 login-form-1">
	              <h3>구매자 로그인</h3>
	              <form>
	                  <div class="form-group">
	                      <input type="text" class="form-control" placeholder="ID" />
	                  </div>
	                  <div class="form-group">
	                      <input type="password" class="form-control" placeholder="Password"/>
	                  </div>
	                  <div class="form-group">
	                      <input type="submit" class="btnSubmit" value="Login" />
	                  </div>
	                  <div class="form-group">
	                      <a href="signinBuyer" class="signin">구매자 회원가입</a>
	                  </div>
	              </form>
	          </div>
	          <div class="col-md-6 login-form-2">
	              <h3>판매자 로그인</h3>
	              <form>
	                  <div class="form-group">
	                      <input type="text" class="form-control" placeholder="ID" />
	                  </div>
	                  <div class="form-group">
	                      <input type="password" class="form-control" placeholder="Password"/>
	                  </div>
	                  <div class="form-group">
	                      <input type="submit" class="btnSubmit" value="Login" />
	                  </div>
	                  <div class="form-group">
	                      <a href="signinSeller" class="signin">판매자 회원가입</a>
	                  </div>
	              </form>
	          </div>
	      </div>
	  </div>  
	  </div>
	<jsp:include page="/global/footer.jsp"/>
</body>
</html>