<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Accounts - Product Admin Template</title>
    <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Roboto:400,700"
    />
    <!-- https://fonts.google.com/specimen/Roboto -->
    <link rel="stylesheet" href="admin/css/fontawesome.min.css" />
    <!-- https://fontawesome.com/ -->
    <link rel="stylesheet" href="admin/css/bootstrap.min.css" />
    <!-- https://getbootstrap.com/ -->
    <link rel="stylesheet" href="admin/css/templatemo-style.css">
    <!--
	Product Admin CSS Template
	https://templatemo.com/tm-524-product-admin
	-->
</head>

<body id="reportsPage">
<div class="" id="home">
    <nav class="navbar navbar-expand-xl">
        <div class="container h-100">
            <a class="navbar-brand" href="/shop_war/Admin">
                <h1 class="tm-site-title mb-0">Product Admin</h1>
            </a>
            <button
                    class="navbar-toggler ml-auto mr-0"
                    type="button"
                    data-toggle="collapse"
                    data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent"
                    aria-expanded="false"
                    aria-label="Toggle navigation"
            >
                <i class="fas fa-bars tm-nav-icon"></i>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mx-auto h-100">
                    <li class="nav-item">
                        <a class="nav-link" href="/shop_war/Admin">
                            <i class="fas fa-tachometer-alt"></i> Dashboard
                            <span class="sr-only">(current)</span>
                        </a>
                    </li>
                    <li class="nav-item dropdown">
                        <a
                                class="nav-link dropdown-toggle"
                                href="#"
                                id="navbarDropdown"
                                role="button"
                                data-toggle="dropdown"
                                aria-haspopup="true"
                                aria-expanded="false"
                        >
                            <i class="far fa-file-alt"></i>
                            <span> Reports <i class="fas fa-angle-down"></i> </span>
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#">Daily Report</a>
                            <a class="dropdown-item" href="#">Weekly Report</a>
                            <a class="dropdown-item" href="#">Yearly Report</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/shop_war/admin-products">
                            <i class="fas fa-shopping-cart"></i> Products
                        </a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link active" href="/shop_war/AccountAdmin">
                            <i class="far fa-user"></i> Accounts
                        </a>
                    </li>
                    <li class="nav-item dropdown">
                        <a
                                class="nav-link dropdown-toggle"
                                href="#"
                                id="navbarDropdown"
                                role="button"
                                data-toggle="dropdown"
                                aria-haspopup="true"
                                aria-expanded="false"
                        >
                            <i class="fas fa-cog"></i>
                            <span> Settings <i class="fas fa-angle-down"></i> </span>
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#">Profile</a>
                            <a class="dropdown-item" href="#">Billing</a>
                            <a class="dropdown-item" href="#">Customize</a>
                        </div>
                    </li>
                </ul>
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link d-block" href="admin.html">
                            Admin <b>(Logout)</b>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container mt-5">
        <div class="row tm-content-row">
            <div class="col-12 tm-block-col">
                <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
                    <h2 class="tm-block-title">List of Accounts</h2>
                    <p class="text-white">Accounts</p>
                    <select class="custom-select">

                        <option value="0">Select account</option>
                        <option value="1">Admin</option>
                        <option value="2">Editor</option>
                        <option value="3">Merchant</option>
                        <option value="4">Customer</option>
                    </select>
</br>
                    <table class="table table-hover tm-table-small tm-product-table">
                        <thead>
                        <tr>
                            <th scope="col">&nbsp;</th>
                            <th scope="col">NAME</th>
                            <th scope="col">PHONE</th>
                            <th scope="col">MAIL</th>
                            <th scope="col">STATUS</th>
                            <th scope="col">&nbsp;</th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach items="${listS}" var="u">
                            <tr>
                                <th scope="row"><input type="checkbox" /></th>
                                <td class="tm-product-name">${u.name}</td>
                                <td>${u.phone}</td>
                                <td>Hi</td>

                                <td>${u.address}</td>
                                <td>
                                    <a href="#" onclick="showMess(${u.userid})" class="tm-product-delete-link">
                                        <i class="far fa-trash-alt tm-product-delete-icon"></i>
                                    </a>

                                    <a href="edit-account?sid=${u.userid}" class="tm-product-delete-link">


                                        <i class="fa-solid fa-pen"></i>

                                    </a>
                                </td>
                            </tr>
                        </c:forEach>



                        </tbody>
                    </table>
                </div>




                <a
                        href="admin/add-accounts.jsp"
                        class="btn btn-primary btn-block text-uppercase ">Add new Account</a>    <br>


                </div>
            </div>
        </div>

    <!-- table container -->



                </form>
            </div>
        </div>
    </div>
    <!-- table container -->
    <footer class="tm-footer row tm-mt-small">
        <div class="col-12 font-weight-light">
            <p class="text-center text-white mb-0 px-4 small">
                Copyright &copy; <b>2022</b> All rights reserved.

                Design: <a rel="nofollow noopener" href="https://templatemo.com" class="tm-footer-link">Team: Thong Dan Phuc</a>
            </p>
        </div>
    </footer>
</div>
<script>
    function showMess(userid){
        var option = confirm('Are you sure to delete');
        if(option == true ){
            window.location.href='admin-user-delete?sid='+userid;
        }
    }
</script>
<script src="admin/js/jquery-3.3.1.min.js"></script>
<!-- https://jquery.com/download/ -->
<script src="admin/js/bootstrap.min.js"></script>
<!-- https://getbootstrap.com/ -->
</body>
</html>
