<%@page import="mall.cart.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jy.servlet.Product"%>
<%@page import="java.util.List"%>
<%@page import="jy.servlet.ProductDao"%>
<%@page import="jy.servlet.JdbcProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
List<Cart> cartProduct = null;

if (cart_list != null) {
	ProductDao productDao = new JdbcProductDao();
	cartProduct = productDao.findCartProducts(cart_list);
	int totalprice = productDao.getTotalCartPrice(cart_list);
	
	request.setAttribute("cartProduct", cartProduct); 
	request.setAttribute("cart_list", cart_list);
	request.setAttribute("totalprice",totalprice);     
} else {
	cart_list = new ArrayList<>(); 
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
	
	.table tbody td{
	vertical-align: middle;
	}
	.btn-incre, .btn-decre{
	box-shadow: none;
	font-size: 25px;
	color: black;
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
   	</div>
	   <!-- Header End -->
	   <!-- Younghun show all product practice -->
	   <!-- Section-->
	   <div class="container my-3">
		<div class="d-flex py-3"><h3>Total Price: KRW${(totalprice>0)?totalprice:0} </h3></div>
		
		<form action="checkout" method="post">
		    <input type="hidden" name="userType" value="${sessionScope.buyer != null ? 'buyer' : 'seller'}">
		    <input type="submit" value="Checkout">
		</form>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Price</th>
					<th scope="col">Buy Now</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
				<%
				if (cartProduct != null) {
					for (Cart c : cartProduct) {
				%>
				<tr>
					<td><%=c.getName()%></td>
					<td><%=c.getCategory()%></td>
					<td><%=c.getPrice() %></td>
					<td>
						<form action="order-now" method="post" class="form-inline">
						<input type="hidden" name="productNumber" value="<%=c.getProductNumber() %>" class="form-input">
							<div class="form-group d-flex justify-content-between">
								<a class="btn btn-sm btn-incre" href="quantitychange?action=inc&productNumber=<%=c.getProductNumber() %>">
							    	<i class="fas fa-plus-square"></i>
								</a> 
								<input type="text" name="quantity" class="form-control" value="<%=c.getQuantity()%>" readonly> 
								<a class="btn btn-sm btn-decre" href="quantitychange?action=dec&productNumber=<%=c.getProductNumber() %>">
								    <i class="fas fa-minus-square"></i>
								</a>

							</div>
							
						</form>
					</td>
					<td><a href="removeitem?productNumber=<%=c.getProductNumber() %>" class="btn btn-sm btn-danger">Remove</a></td>
				</tr>

				<%}
				}%>
			</tbody>
		</table>
	</div>
	  
		
		
	   <jsp:include page="/global/footer.jsp"/>

</body>
</html>