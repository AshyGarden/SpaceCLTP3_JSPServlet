<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Shopping Cart</title>
</head>
<body>
    <h2>Your Shopping Cart</h2>
    <ul>
        <%
            List<String> cart = (List<String>) session.getAttribute("cart");
            if (cart == null || cart.isEmpty()) {
        %>
                <li>Your cart is empty.</li>
        <%
            } else {
                for (String productId : cart) {
        %>
                    <li>Product ID: <%= productId %></li>
        <%
                }
            }
        %>
    </ul>
    <a href="cartindextest.jsp">Continue Shopping</a>
</body>
</html>
