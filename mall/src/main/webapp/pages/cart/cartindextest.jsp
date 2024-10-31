<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
    <script>
        // Define contextPath globally
        const contextPath = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 1));

        function addToCart(productId) {
            const xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function () {
                if (xhr.readyState === XMLHttpRequest.DONE) {
                    if (xhr.status === 200) {
                        alert('Item added to cart!');
                    } else {
                        console.error('Error adding item to cart:', xhr.status, xhr.statusText);
                        alert('Failed to add item to cart. Please try again.');
                    }
                }
            };
            xhr.open("POST", contextPath + "/CartServlet", true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.send("productId=" + encodeURIComponent(productId));
        }
    </script>
</head>
<body>
    <h2>Product List</h2>
    <ul>
        <li>
            Product 1 <button onclick="addToCart(1)">Add to Cart</button>
        </li>
        <li>
            Product 2 <button onclick="addToCart(2)">Add to Cart</button>
        </li>
        <li>
            Product 3 <button onclick="addToCart(3)">Add to Cart</button>
        </li>
    </ul>
    <a href="carttest.jsp">View Cart</a>
</body>
</html>
