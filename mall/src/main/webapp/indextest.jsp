<%@page import="jy.servlet.Product"%>
<%@page import="java.util.List"%>
<%@page import="jy.servlet.ProductDao"%>
<%@page import="jy.servlet.JdbcProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%ProductDao productDao = new JdbcProductDao();
List<Product> products = productDao.findAll();
out.println(products.size());
%>
<!DOCTYPE html>
<html>
<head>
	<title>Shop Main</title>
</head>
<body>


<div class="container">
    <div class="card-header my-3">
    <%
           		if(!products.isEmpty()){
           			for(Product product:products){%>
              <div class="col-md-3">
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
                      <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="CartServlet?id=${product.productNumber}">Add to cart</a></div>
                  </div>
              </div>
          </div>
           				
           			<%}
           		}
           %>
      
   </div>
   
   <div class="col mb-5">
	                   <div class="card h-100">
	                       <!-- Sale badge-->
	                       <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>
	                       <!-- Product image-->
	                       <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
	                       <!-- Product details-->
	                       <div class="card-body p-4">
	                           <div class="text-center">
	                               <!-- Product name-->
	                               <h5 class="fw-bolder">Special Item</h5>
	                               <!-- Product reviews-->
	                              <!--  <div class="d-flex justify-content-center small text-warning mb-2">
	                                   <div class="bi-star-fill"></div>
	                                   <div class="bi-star-fill"></div>
	                                   <div class="bi-star-fill"></div>
	                                   <div class="bi-star-fill"></div>
	                                   <div class="bi-star-fill"></div>
	                               </div> -->
	                               <!-- Product price-->
	                               <span class="text-muted text-decoration-line-through">$20.00</span>
	                               $18.00
	                           </div>
	                       </div>
	                       <!-- Product actions-->
	                       <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
	                           <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="productinfo">View item</a></div>
	                       </div>
	                       <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
	                           <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>
	                       </div>
	                   </div>
	               </div>
	               <div class="col mb-5">
	                   <div class="card h-100">
	                       <!-- Sale badge-->
	                       <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>
	                       <!-- Product image-->
	                       <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
	                       <!-- Product details-->
	                       <div class="card-body p-4">
	                           <div class="text-center">
	                               <!-- Product name-->
	                               <h5 class="fw-bolder">Sale Item</h5>
	                               <!-- Product price-->
	                               <span class="text-muted text-decoration-line-through">$50.00</span>
	                               $25.00
	                           </div>
	                       </div>
	                       <!-- Product actions-->
	                      <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
	                           <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="productinfo">View item</a></div>
	                       </div>
	                       <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
	                           <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>
	                       </div>
	                   </div>
	               </div>
	               <div class="col mb-5">
	                   <div class="card h-100">
	                       <!-- Product image-->
	                       <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
	                       <!-- Product details-->
	                       <div class="card-body p-4">
	                           <div class="text-center">
	                               <!-- Product name-->
	                               <h5 class="fw-bolder">Popular Item</h5>
	                               <!-- Product reviews-->
	                               <div class="d-flex justify-content-center small text-warning mb-2">
	                                   <div class="bi-star-fill"></div>
	                                   <div class="bi-star-fill"></div>
	                                   <div class="bi-star-fill"></div>
	                                   <div class="bi-star-fill"></div>
	                                   <div class="bi-star-fill"></div>
	                               </div>
	                               <!-- Product price-->
	                               $40.00
	                           </div>
	                       </div>
	                       <!-- Product actions-->
	                       <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
	                           <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="productinfo">View item</a></div>
	                       </div>
	                       <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
	                           <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>
	                       </div>
	                   </div>
	               </div>
	               <div class="col mb-5">
	                   <div class="card h-100">
	                       <!-- Sale badge-->
	                       <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>
	                       <!-- Product image-->
	                       <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
	                       <!-- Product details-->
	                       <div class="card-body p-4">
	                           <div class="text-center">
	                               <!-- Product name-->
	                               <h5 class="fw-bolder">Sale Item</h5>
	                               <!-- Product price-->
	                               <span class="text-muted text-decoration-line-through">$50.00</span>
	                               $25.00
	                           </div>
	                       </div>
	                       <!-- Product actions-->
	                       <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
	                           <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="${pageContext.request.contextPath}/mall/productinfo?productname=${product.name}">View item</a></div>
	                       </div>
	                       <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
	                           <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>
	                       </div>
	                   </div>
	               </div>
	               <div class="col mb-5">
	                   <div class="card h-100">
	                       <!-- Product image-->
	                       <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
	                       <!-- Product details-->
	                       <div class="card-body p-4">
	                           <div class="text-center">
	                               <!-- Product name-->
	                               <h5 class="fw-bolder">Fancy Product</h5>
	                               <!-- Product price-->
	                               $120.00 - $280.00
	                           </div>
	                       </div>
	                       <!-- Product actions-->
	                       <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
	                           <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="productinfo">View item</a></div>
	                       </div>
	                       <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
	                           <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>
	                       </div>
	                   </div>
	               </div>
	               <div class="col mb-5">
	                   <div class="card h-100">
	                       <!-- Sale badge-->
	                       <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>
	                       <!-- Product image-->
	                       <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
	                       <!-- Product details-->
	                       <div class="card-body p-4">
	                           <div class="text-center">
	                               <!-- Product name-->
	                               <h5 class="fw-bolder">Special Item</h5>
	                               <!-- Product reviews-->
	                               <div class="d-flex justify-content-center small text-warning mb-2">
	                                   <div class="bi-star-fill"></div>
	                                   <div class="bi-star-fill"></div>
	                                   <div class="bi-star-fill"></div>
	                                   <div class="bi-star-fill"></div>
	                                   <div class="bi-star-fill"></div>
	                               </div>
	                               <!-- Product price-->
	                               <span class="text-muted text-decoration-line-through">$20.00</span>
	                               $18.00
	                           </div>
	                       </div>
	                       <!-- Product actions-->
	                      <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
	                           <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="productinfo">View item</a></div>
	                       </div>
	                       <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
	                           <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>
	                       </div>
	                   </div>
	               </div>
	               <div class="col mb-5">
	                   <div class="card h-100">
	                       <!-- Product image-->
	                       <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
	                       <!-- Product details-->
	                       <div class="card-body p-4">
	                           <div class="text-center">
	                               <!-- Product name-->
	                               <h5 class="fw-bolder">Popular Item</h5>
	                               <!-- Product reviews-->
<!-- 	                               <div class="d-flex justify-content-center small text-warning mb-2">
	                                   <div class="bi-star-fill"></div>
	                                   <div class="bi-star-fill"></div>
	                                   <div class="bi-star-fill"></div>
	                                   <div class="bi-star-fill"></div>
	                                   <div class="bi-star-fill"></div>
	                               </div> -->
	                               <!-- Product price-->
	                               $40.00
	                           </div>
	                       </div>
	                       <!-- Product actions-->
	                       <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
	                           <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="productinfo">View item</a></div>
	                       </div>
	                       <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
	                           <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>
	                       </div>
	                   </div>
	               </div>
</body>
</html>