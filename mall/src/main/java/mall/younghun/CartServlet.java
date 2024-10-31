package mall.younghun;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("productId");

        // Get or create session
        HttpSession session = request.getSession();
        System.out.println("Session ID: " + session.getId()); // Log session ID for debugging

        // Retrieve or initialize the cart attribute
        List<String> cart = (List<String>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart); // Set the cart in the session
            System.out.println("New cart initialized and added to session.");
        } else {
            System.out.println("Cart found in session with current items: " + cart);
        }

        // Add product to cart if productId is valid
        if (productId != null && !productId.isEmpty()) {
            cart.add(productId);
            System.out.println("Product ID " + productId + " added to cart.");

            // Send a success message
            response.setContentType("text/plain");
            response.getWriter().write("Product added to cart");
        } else {
            System.out.println("Invalid product ID received.");
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid product ID");
        }
    }
}