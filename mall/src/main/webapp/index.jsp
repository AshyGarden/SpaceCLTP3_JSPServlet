<%@page import="mall.cart.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jy.servlet.Product"%>
<%@page import="java.util.List"%>
<%@page import="jy.servlet.ProductDao"%>
<%@page import="jy.servlet.JdbcProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%ProductDao productDao = new JdbcProductDao();
List<Product> products = productDao.findAll();

ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
if (cart_list != null) {
	request.setAttribute("cart_list", cart_list);     
} 
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<title>Shop Main</title>
	<style>
	.wrapper{
	 background-image: url("${pageContext.request.contextPath}/resources/image/background/indexbg.png"); /* 이미지 경로 설정 */
        background-size: cover; 
        background-position: center; 
        width: 100%;
	}
	</style>
</head>
<body>
	<div class="wrapper">
	   <jsp:include page="/global/navbar.jsp"/>
	   <!-- Header Start -->
	   <header class="bg-dark py-5">
	       <div class="container px-4 px-lg-5 my-5">
	           <div class="text-center text-white">
	               <h1 class="display-4 fw-bolder">Welcome To the Mall!</h1>
	               <p class="lead fw-normal text-white-50 mb-0">We'll hope your enjoy shopping</p>
	           </div>
	       </div>
	   </header>
	   <!-- Header End -->
	   <!-- Younghun show all product practice -->
	   <!-- Section-->
	   <section class="py-5">
	       <div class="container px-4 px-lg-5 mt-5">
	           <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
	           <%
	                   		if(!products.isEmpty()){
	                   			for(Product product:products){%>
	                   				<div class="col mb-5">
				                   <div class="card h-100">
				                   
				                       <!-- Product image-->
				                       <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
				                       <!-- Product details-->
				                       <div class="card-body p-4">
				                           <div class="text-center">
				                               <!-- Product name-->
				                               <h5 class="fw-bolder"><%= product.getName() %></h5>
				                               <!-- Product price-->
				                               <h6 class="price"><%= product.getPrice() %></h6>
				                               <h6 class="category"><%= product.getCategory() %></h6>
				                           </div>
				                       </div>
				                       <!-- Product actions-->
				                       <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
				                           <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="${pageContext.request.contextPath}/productinfo?productname=${product.name}">View item</a></div>
				                       </div>

				                       <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
				                           <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="AddToCartServlet?productNumber=<%= product.getProductNumber()%>">Add to cart</a></div>
				                       </div>
				
				                   </div>
				               </div>
	                   				
	                   			<%}
	                   		}
	                   %>
	            
	               
	           </div>
	       </div>
	   </section>
	   <jsp:include page="/global/footer.jsp"/>
	</div>
</body>
</html>