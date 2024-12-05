<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="mall.cart.Cart"%>
<%@page import="java.util.ArrayList"%>
<%ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
if (cart_list != null) {
	request.setAttribute("cart_list", cart_list);     
} 
%>
<!DOCTYPE html>
<html>
<head>

<style>
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
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<section>

<c:if test="${!empty history}">
	<table>
		<tr>
			<th>order number</th>
		</tr>
		<c:forEach var="historylist" items="${history}">
		<tr>
			<td><a href="buyertrade?history_number=${historylist.history_number}">${historylist.history_number}</a></td>
			
		</tr>
		
		</c:forEach>
		
	
	</table>

</c:if>

<c:if test="${empty history}">there is no history.</c:if>
</section>
<div>
<jsp:include page="/global/footer.jsp"/>
</div>



</body>
</html>