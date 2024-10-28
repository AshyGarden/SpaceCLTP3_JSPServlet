<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Navigation Bar</title>
</head>
<body>
<!-- Navigation Start -->
   <nav class="navbar navbar-expand-lg navbar-light bg-light">
       <div class="container px-4 px-lg-5">
           <a class="navbar-brand" href="index">SpaceCL Mall</a>
           <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
           <div class="collapse navbar-collapse" id="navbarSupportedContent">
               <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                   <li class="nav-item"><a class="nav-link active" aria-current="page" href="index">Home</a></li>
                   <li class="nav-item"><a class="nav-link" href="about">About</a></li>
                   <!-- <li class="nav-item dropdown">
                       <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
                       <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                           <li><a class="dropdown-item" href="#!">All Products</a></li>
                           <li><hr class="dropdown-divider" /></li>
                           <li><a class="dropdown-item" href="#!">Popular Items</a></li>
                           <li><a class="dropdown-item" href="#!">New Arrivals!</a></li>
                       </ul>
                   </li> -->       
               </ul>
               <form class="d-flex">
               		<!-- logout 状況 スタト -->
                   	<%-- <button class="btn btn-outline-dark" onclick="location.href='${pageContext.request.contextPath}/login'">Login</button> --%>
                   	<a class="btn btn-outline-dark mt-auto" href="login">Login</a>
                   	<button class="btn btn-outline-dark" onclick="location.href='http://localhost:8080/mall/';">Login</button>
                   	<!-- logout 状況　エンド -->
                   	&nbsp; &nbsp; 
                   	<!-- login 状況　スタト -->
                   	<button class="btn btn-outline-dark" type="submit">　
                       <i class="bi-cart-fill me-1"></i>
                       Cart
                       <span class="badge bg-dark text-white ms-1 rounded-pill">0</span>
                   </button>
                   <!-- login 状況　エンド -->
               </form>
               <form action = "buyerregister" method = "post">
               		<button type = "submit" class="btn btn-outline-dark">Sign Up</button>
               </form>
           </div>
       </div>
   </nav>
   <!-- Navigation End -->
</body>
</html>