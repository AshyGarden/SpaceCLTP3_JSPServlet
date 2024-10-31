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

<script>
// Function to Add Item to Cart
function addToCart() {
    const productId = document.querySelector("#productId").value;
    const quantity = document.querySelector("#quantity").value;
    const url = "addToCart"; // URL to handle adding to cart in your backend
    const params = `productId=${productId}&quantity=${quantity}`;
    
    const xhr = new XMLHttpRequest();
    xhr.onreadystatechange = () => {
        if (xhr.readyState == xhr.DONE) {
            if (xhr.status == 200) {
                let cart = JSON.parse(xhr.responseText);
                renderCart(cart);
            }
        }
    };
    
    xhr.open("POST", url);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send(params);
}

// Render the Cart Contents
function renderCart(cart) {
    let output = "<ul>";
    for (let item of cart) {
        output += `<li>Product: ${item.productId}, Quantity: ${item.quantity}</li>`;
    }
    output += "</ul>";
    document.querySelector("#cartContents").innerHTML = output;
}

// Add Event Listener for Add to Cart Button
const addToCartBtn = document.querySelector("#addToCartBtn");
addToCartBtn.addEventListener('click', addToCart);

</script>

</body>
</html>
