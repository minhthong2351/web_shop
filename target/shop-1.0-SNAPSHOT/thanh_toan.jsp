<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");

%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		 <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

		<title>Shop</title>

		<!-- Google font -->
		<link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

		<!-- Bootstrap -->
		<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>

		<!-- Slick -->
		<link type="text/css" rel="stylesheet" href="css/slick.css"/>
		<link type="text/css" rel="stylesheet" href="css/slick-theme.css"/>

		<!-- nouislider -->
		<link type="text/css" rel="stylesheet" href="css/nouislider.min.css"/>

		<!-- Font Awesome Icon -->
		<link rel="stylesheet" href="css/font-awesome.min.css">

		<!-- Custom stlylesheet -->
		<link type="text/css" rel="stylesheet" href="css/style.css"/>
		<link type="text/css" rel="stylesheet" href="css/thanh_toan.css"/>
		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

    </head>
	<body>
		<!-- HEADER -->
		<header>
			<!-- TOP HEADER -->
			<div id="top-header">
				<div class="container">
					<ul class="header-links pull-left">
						<li><a href="#"><i class="fa fa-phone"></i> +021-95-51-84</a></li>
						<li><a href="#"><i class="fa fa-envelope-o"></i> email@email.com</a></li>
						<li><a href="#"><i class="fa fa-map-marker"></i> 1734 Stonecoal Road</a></li>
					</ul>
					<ul class="header-links pull-right">
						<li><a href="#"><i class="fa fa-dollar"></i> USD</a></li>
						<c:if test="${sessionScope.username != null}">
							<li>
								<a href="profile.jsp"><i class="fa fa-user-o"></i><strong>Hello,</strong> ${username}.</a>
							</li>
							<li class="hidden-xs"><a href="/shop_war/doLogout">(Logout)</a></li>
						</c:if>

						<c:if test="${sessionScope.username == null}">
							<li><a href="./login.jsp">Login</a></li>
							<li><a href="">/</a></li>
							<li class="hidden-xs"><a href="./register.jsp">Register</a></li>
						</c:if>
					</ul>
				</div>
			</div>
			<!-- /TOP HEADER -->

			<!-- MAIN HEADER -->
			<div id="header">
				<!-- container -->
				<div class="container">
					<!-- row -->
					<div class="row">
						<!-- LOGO -->
						<div class="col-md-3">
							<div class="header-logo">
								<a href="/shop_war/Index" class="logo">
									<img src="img/logo.png" alt="">
								</a>
							</div>
						</div>
						<!-- /LOGO -->

						<!-- SEARCH BAR -->
						<div class="col-md-6">
							<div class="header-search">
								<form>
									<input class="input" placeholder="Search here">
									<button class="search-btn">Search</button>
								</form>
							</div>
						</div>
						<!-- /SEARCH BAR -->

						<!-- ACCOUNT -->
						<div class="col-md-3 clearfix">
							<div class="header-ctn">
								<!-- Wishlist -->
								<div>
									<a href="/shop_war/wishlist">
										<i class="fa fa-heart-o"></i>
										<span>Your Wishlist</span>
									</a>
								</div>
								<!-- /Wishlist -->

								<!-- Cart -->
								<div class="dropdown">
									<a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
										<i class="fa fa-shopping-cart"></i>
										<span>Your Cart</span>
									</a>
									<div class="cart-dropdown">
										<div class="cart-btns">
											<a href="/shop_war/cart">View Cart</a>
											<a href="thanh_toan.jsp">Checkout  <i class="fa fa-arrow-circle-right"></i></a>
										</div>
									</div>
								</div>
								<!-- /Cart -->

								<!-- Menu Toogle -->
								<div class="menu-toggle">
									<a href="#">
										<i class="fa fa-bars"></i>
										<span>Menu</span>
									</a>
								</div>
								<!-- /Menu Toogle -->
							</div>
						</div>
						<!-- /ACCOUNT -->
					</div>
					<!-- row -->
				</div>
				<!-- container -->
			</div>
			<!-- /MAIN HEADER -->
		</header>
		<!-- /HEADER -->

		<!-- NAVIGATION -->
		<nav id="navigation">
			<!-- container -->
			<div class="container">
				<!-- responsive-nav -->
				<div id="responsive-nav">
					<!-- NAV -->
					<ul class="main-nav nav navbar-nav">
						<li class="active"><a href="/shop_war/Index">Home</a></li>
						<li><a href="/shop_war/store">Store</a></li>
						<li><a href="contact.jsp">Contact</a></li>
					</ul>
					<!-- /NAV -->
				</div>
				
				<!-- /responsive-nav -->
			</div>
			<!-- /container -->
		</nav>
		<!-- /NAVIGATION -->

		<!-- BREADCRUMB -->
		<div id="breadcrumb" class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<div class="col-md-12">
						<h3 class="breadcrumb-header">Regular Page</h3>
						<ul class="breadcrumb-tree">
							<li><a href="/shop_war/Index">Home</a></li>
							<li class="active">Blank</li>
						</ul>
					</div>
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /BREADCRUMB -->

		<!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->




		<!--thanh toan-->
		<div class="row">
			<div class="col-75">
			  <div class="container">
				<form action="/shop_war/Checkout" methods="post" >
				  <div class="row">
					<div class="col-50">
					  <h3>Billing Address</h3>
						<p style="color:green; display: block;"><%=(request.getAttribute("Message") == null) ? "" : request.getAttribute("Message")%></p>
					  <label for="fname"><i class="fa fa-user"></i> Full Name</label>
					  <input type="text" id="fname" name="name" value="${sessionScope.name}">
					  <label for="email" style="display: none"><i class="fa fa-envelope" style="display: none"></i> Email</label>
						<input type="text" id="fname" name="userid" value="${sessionScope.userid}" style="display: none">
						<label for="email"><i class="fa fa-envelope"></i> Email</label>
					  <input type="text" id="email" name="email" value="${sessionScope.email}">
						<label for="email"><i class="fa fa-phone"></i> Phone</label>
						<input type="text" id="email" name="phone" value="${sessionScope.phone}">
					  <label for="adr"><i class="fa fa-address-card-o"></i> Address</label>
					  <input type="text" id="adr" name="address" value="${sessionScope.address}">
						<label for="adr" style="display: none"><i class="fa fa-address-card-o" style="display: none"></i> Total</label>
						<input type="text" id="adr" name="carttotal" value="${cart.getTotal()}$" style="display: none">
						<div class="col-50">
					  <h3>Payment</h3>
					  <label for="fname">Accepted Cards</label>
					  <div class="icon-container">
						<i class="fa fa-cc-visa" style="color:navy;"></i>
						<i class="fa fa-cc-amex" style="color:blue;"></i>
						<i class="fa fa-cc-mastercard" style="color:red;"></i>
						<i class="fa fa-cc-discover" style="color:orange;"></i>
					  </div>
					  <label for="cname">Name on Card</label>
					  <input type="text" id="cname" name="" value="${sessionScope.name}">
					  <label for="ccnum">Credit card number</label>
					  <input type="text" id="ccnum" name="" placeholder="1111-2222-3333-4444">
					</div>
					</div>
				  </div>
				  <label>
					<input type="checkbox" checked="checked" name=""> Shipping address same as billing
				  </label>
					<button type="submit" class="btn btn-success btn-block">Thanh toán <i class="fa fa-angle-right"></i></button>
				</form>
			  </div>
			</div>
		  
			<div class="col-25">
			  <div class="container">
				  <table id="cart" class="table table-hover table-condensed">
					  <thead>
					  <tr>
						  <th style="width:50%">Tên sản phẩm</th>
						  <th style="width:10%">Giá</th>
						  <th style="width:8%">Số lượng</th>
						  <th style="width:22%" class="text-center">Thành tiền</th>
						  <th style="width:10%"> </th>
					  </tr>
					  </thead>
					  <tbody>

					  <c:set var="product" value="${cart.products}"/>
					  <c:forEach items="${product}" var="product">
						  <tr>
							  <td data-th="Product">
								  <div class="row">
									  <div class="col-sm-2 hidden-xs"><img src="${product.img}" alt="Sản phẩm 1" class="img-responsive" width="100">
									  </div>
									  <div class="col-sm-10">
										  <h4 class="nomargin">${product.name}</h4>
										  <a href="productDetail.html">
											  <p>Mô tả của sản phẩm 1</p>
										  </a>
									  </div>
								  </div>
							  </td>
							  <td data-th="Price">${product.sellPrice}</td>
							  <td data-th="Quantity"><input class="form-control text-center " id="changeQuantity" pid="${product.id}" value="${product.quantitySold}" type="number">
							  </td>
							  <td data-th="Subtotal" class="text-center">${product.total}</td>
							  <td class="actions" data-th="">
								  <button class="btn btn-info btn-sm"><i class="fa fa-edit"></i>
								  </button>
								  <button class="btn btn-danger btn-sm"><a class="cart-remove" pid="${product.id}"> <i class="fa fa-trash-o"></i></a>
								  </button>
							  </td>
						  </tr>
					  </c:forEach>
					  </tbody>
					  <tfoot>
					  <tr>
						  <td colspan="2" class="hidden-xs"> </td>
						  <td class="hidden-xs text-center" items="${product}" var="product"><strong>Tổng tiền ${cart.getTotal()}$</strong>
						  </td>

					  </tr>
					  </tfoot>
				  </table>
			  </div>
			</div>
		  </div>
			<!--thanh toan-->
		

		<!-- NEWSLETTER -->
		<div id="newsletter" class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<div class="col-md-12">
						<div class="newsletter">
							<p>Sign Up for the <strong>NEWSLETTER</strong></p>
							<form>
								<input class="input" type="email" placeholder="Enter Your Email">
								<button class="newsletter-btn"><i class="fa fa-envelope"></i> Subscribe</button>
							</form>
							<ul class="newsletter-follow">
								<li>
									<a href="#"><i class="fa fa-facebook"></i></a>
								</li>
								<li>
									<a href="#"><i class="fa fa-twitter"></i></a>
								</li>
								<li>
									<a href="#"><i class="fa fa-instagram"></i></a>
								</li>
								<li>
									<a href="#"><i class="fa fa-pinterest"></i></a>
								</li>
							</ul>
						</div>
					</div>
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /NEWSLETTER -->

		<!-- FOOTER -->
		<footer id="footer">
			<!-- top footer -->
			<div class="section">
				<!-- container -->
				<div class="container">
					<!-- row -->
					<div class="row">
						<div class="col-md-3 col-xs-6">
							<div class="footer">
								<h3 class="footer-title">About Us</h3>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut.</p>
								<ul class="footer-links">
									<li><a href="#"><i class="fa fa-map-marker"></i>1734 Stonecoal Road</a></li>
									<li><a href="#"><i class="fa fa-phone"></i>+021-95-51-84</a></li>
									<li><a href="#"><i class="fa fa-envelope-o"></i>email@email.com</a></li>
								</ul>
							</div>
						</div>

						<div class="col-md-3 col-xs-6">
							<div class="footer">
								<h3 class="footer-title">Categories</h3>
								<ul class="footer-links">
									<li><a href="#">Hot deals</a></li>
									<li><a href="#">Laptops</a></li>
									<li><a href="#">Smartphones</a></li>
									<li><a href="#">Cameras</a></li>
									<li><a href="#">Accessories</a></li>
								</ul>
							</div>
						</div>

						<div class="clearfix visible-xs"></div>

						<div class="col-md-3 col-xs-6">
							<div class="footer">
								<h3 class="footer-title">Information</h3>
								<ul class="footer-links">
									<li><a href="#">About Us</a></li>
									<li><a href="#">Contact Us</a></li>
									<li><a href="#">Privacy Policy</a></li>
									<li><a href="#">Orders and Returns</a></li>
									<li><a href="#">Terms & Conditions</a></li>
								</ul>
							</div>
						</div>

						<div class="col-md-3 col-xs-6">
							<div class="footer">
								<h3 class="footer-title">Service</h3>
								<ul class="footer-links">
									<li><a href="#">My Account</a></li>
									<li><a href="#">View Cart</a></li>
									<li><a href="#">Wishlist</a></li>
									<li><a href="#">Track My Order</a></li>
									<li><a href="#">Help</a></li>
								</ul>
							</div>
						</div>
					</div>
					<!-- /row -->
				</div>
				<!-- /container -->
			</div>
			<!-- /top footer -->

			<!-- bottom footer -->
			<div id="bottom-footer" class="section">
				<div class="container">
					<!-- row -->
					<div class="row">
						<div class="col-md-12 text-center">
							<ul class="footer-payments">
								<li><a href="#"><i class="fa fa-cc-visa"></i></a></li>
								<li><a href="#"><i class="fa fa-credit-card"></i></a></li>
								<li><a href="#"><i class="fa fa-cc-paypal"></i></a></li>
								<li><a href="#"><i class="fa fa-cc-mastercard"></i></a></li>
								<li><a href="#"><i class="fa fa-cc-discover"></i></a></li>
								<li><a href="#"><i class="fa fa-cc-amex"></i></a></li>
							</ul>
							<span class="copyright">
								<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
								Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
							<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							</span>


						</div>
					</div>
						<!-- /row -->
				</div>
				<!-- /container -->
			</div>
			<!-- /bottom footer -->
		</footer>
		<!-- /FOOTER -->

		<!-- jQuery Plugins -->
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/slick.min.js"></script>
		<script src="js/nouislider.min.js"></script>
		<script src="js/jquery.zoom.min.js"></script>
		<script src="js/main.js"></script>

	</body>
</html>
