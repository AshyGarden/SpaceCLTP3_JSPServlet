<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart</title>
</head>
<body>

<h2>AJAX Shopping Cart Example</h2>

<!-- Form for Adding Item to Cart -->
<form action="#">
    <input type="text" id="productId" name="productId" placeholder="Product ID"/> 
    <input type="number" id="quantity" name="quantity" placeholder="Quantity" min="1"/>
    <button type="button" id="addToCartBtn">Add to Cart</button>
</form>

<!-- Div to Display Cart Contents -->
<div id="cart">
    <h3>Shopping Cart</h3>
    <div id="cartContents"></div>
</div>



</body>
</html>
