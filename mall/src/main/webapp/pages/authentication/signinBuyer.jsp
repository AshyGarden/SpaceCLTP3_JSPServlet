<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>구매자 회원가입</title>
	<style>
	.wrapper{
	 	background-image: url("${pageContext.request.contextPath}/resources/image/background/signinbg.png");
	    background-size: cover; 
	    background-position: center; 
	    width: 100%;
	}
	</style>
	<link href="${pageContext.request.contextPath}/resources/css/signin.css" rel="stylesheet" />
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="/global/navbar.jsp"/>
		<div class="container register">
             <div class="row">
                 <div class="col-md-3 register-left">
                     <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt=""/>
                     <h3>반갑습니다!</h3>
                     <p>저희 매장 직원들은 여러분의 <br>회원가입을 적극 환영합니다!</p>
                     <a href="login"><input type="submit" class="btnLogin" value="Login"/></a><br/>
                 </div>
                 <div class="col-md-9 register-right">
                     <ul class="nav nav-tabs nav-justified" id="myTab" role="tablist">
                         <li class="nav-item">
                             <a class="nav-link active" id="home-tab" data-toggle="tab" href="signinBuyer" role="tab" aria-controls="home" aria-selected="true">구매자</a>
                         </li>
                         <li class="nav-item">
                             <a class="nav-link" id="profile-tab" data-toggle="tab" href="signinSeller" role="tab" aria-controls="profile" aria-selected="false">판매자</a>
                         </li>
                     </ul>
                     <div class="tab-content" id="myTabContent">
                         <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                             <h3 class="register-heading">회원가입란</h3>
                             <div class="row register-form">
                                 <div class="col-md-6">
                                     <div class="form-group">
                                         <input type="text" class="form-control" placeholder="First Name *" value="" />
                                     </div>
                                     <div class="form-group">
                                         <input type="text" class="form-control" placeholder="Last Name *" value="" />
                                     </div>
                                     <div class="form-group">
                                         <input type="password" class="form-control" placeholder="Password *" value="" />
                                     </div>
                                     <div class="form-group">
                                         <input type="password" class="form-control"  placeholder="Confirm Password *" value="" />
                                     </div>
                                 </div>
                                 <div class="col-md-6">
                                     <div class="form-group">
                                         <input type="email" class="form-control" placeholder="Your Email *" value="" />
                                     </div>
                                     <div class="form-group">
                                         <input type="text" minlength="10" maxlength="10" name="txtEmpPhone" class="form-control" placeholder="Your Phone *" value="" />
                                     </div>
                                     <div class="form-group">
                                         <select class="form-control">
                                             <option class="hidden"  selected disabled>Please select your Sequrity Question</option>
                                             <option>What is your Birthdate?</option>
                                             <option>What is Your old Phone Number</option>
                                             <option>What is your Pet Name?</option>
                                         </select>
                                     </div>
                                     <div class="form-group">
                                         <input type="text" class="form-control" placeholder="Enter Your Answer *" value="" />
                                     </div>
                                     <input type="submit" class="btnRegister"  value="Register"/>
                                 </div>
                             </div>
                         </div>
                         <div class="tab-pane fade show" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                             <h3  class="register-heading">Apply as a Hirer</h3>
                             <div class="row register-form">
                                 <div class="col-md-6">
                                     <div class="form-group">
                                         <input type="text" class="form-control" placeholder="First Name *" value="" />
                                     </div>
                                     <div class="form-group">
                                         <input type="text" class="form-control" placeholder="Last Name *" value="" />
                                     </div>
                                     <div class="form-group">
                                         <input type="email" class="form-control" placeholder="Email *" value="" />
                                     </div>
                                     <div class="form-group">
                                         <input type="text" maxlength="10" minlength="10" class="form-control" placeholder="Phone *" value="" />
                                     </div>


                                 </div>
                                 <div class="col-md-6">
                                     <div class="form-group">
                                         <input type="password" class="form-control" placeholder="Password *" value="" />
                                     </div>
                                     <div class="form-group">
                                         <input type="password" class="form-control" placeholder="Confirm Password *" value="" />
                                     </div>
                                     <div class="form-group">
                                         <select class="form-control">
                                             <option class="hidden"  selected disabled>Please select your Sequrity Question</option>
                                             <option>What is your Birthdate?</option>
                                             <option>What is Your old Phone Number</option>
                                             <option>What is your Pet Name?</option>
                                         </select>
                                     </div>
                                     <div class="form-group">
                                         <input type="text" class="form-control" placeholder="`Answer *" value="" />
                                     </div>
                                     <input type="submit" class="btnRegister"  value="Register"/>
                                 </div>
                             </div>
                         </div>
                     </div>
                 </div>
             </div>
         </div>
         <jsp:include page="/global/footer.jsp"/>
	</div>
</body>
</html>