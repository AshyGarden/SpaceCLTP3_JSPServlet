<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

<table>
	<tr>
		<th>history number</th>
		<th>product number</th>
		<th>product count</th>
		<th>trade_time</th>
	</tr>
	<c:forEach var="trades" items="${trade}">
		<tr>
			<td>${trades.history.history_number}</td>
			<td>${trades.product.productNumber}</td>
			<td>${trades.product_count}</td>
			<td>${trades.trade_time}</td>
			
		</tr>
		
	</c:forEach>
	

</table>

</section>
<div>
<jsp:include page="/global/footer.jsp"/>
</div>



</body>
</html>