<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<style>
    .badge-danger {
        background-color: red; /* Ensures background color is red */
        color: red; /* Sets text color to white */
    }
</style>
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
               		<c:choose>
	              		<c:when test="${buyer!=null}"> <!-- member is not null + buyer -->
		                   	<!-- Buyer Login status start-->
		                   	
		                  	<a class="btn btn-outline-dark" href="${pageContext.request.contextPath}/buyerhistory">
							    History
							</a>
							&nbsp;
							<a class="btn btn-outline-dark" href="${pageContext.request.contextPath}/cart">
							    <i class="bi-cart-fill me-1"></i>
							    Cart
							    <span class="badge badge-danger">${cart_list.size()}</span>
							</a>
	                   		&nbsp;
			                <a class="btn btn-outline-dark mt-auto" href="logout">logout</a>         
	                   		<!-- Buyer Login status end -->
	              		</c:when>
	              		
                   		<c:when test="${seller!=null}"> <!-- member is not null + seller -->
                   			<!-- seller login status start -->
			                <a class="btn btn-outline-dark mt-auto" href="logout">logout</a>                            		
                   			<!-- seller login status end -->
                   		</c:when>
                   		
	               		<c:otherwise>
		               		<!-- logout status start -->
		               		<a class="btn btn-outline-dark" href="${pageContext.request.contextPath}/cart">
							    <i class="bi-cart-fill me-1"></i>
							    Cart
							    <span class="badge badge-danger">${cart_list.size()}</span>
							</a>
							&nbsp;
		                   	<a class="btn btn-outline-dark mt-auto" href="loginForm">login</a>
		                   	&nbsp;
		                   	<a class="btn btn-outline-dark mt-auto" href="signinBuyer">SignUp(Buyer)</a>
		                   	&nbsp;
		                   	<a class="btn btn-outline-dark mt-auto" href="register">SignUp(Seller)</a>           
		                   	<!-- logout status end -->
	               		</c:otherwise>
              	   </c:choose>
               </form>
           </div>
       </div>
   </nav>
   <!-- Navigation End -->
</body>
</html>