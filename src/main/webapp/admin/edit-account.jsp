
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Add Product - Dashboard HTML Template</title>
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

<body>
<nav class="navbar navbar-expand-xl">
    <div class="container h-100">
        <a class="navbar-brand" href="admin.html">
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
                    <a class="nav-link" href="/Admin">
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
                    <a class="nav-link active" href="/shop_war/admin-products">
                        <i class="fas fa-shopping-cart"></i> Products
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/shop_war/AccountAdmin">

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
                    <a class="nav-link d-block" href="login.html">
                        Admin <b>(Logout)</b>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container tm-mt-big tm-mb-big">
    <div class="row">
        <div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
            <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
                <div class="row">
                    <div class="col-12">
                        <h2 class="tm-block-title d-inline-block">Edit Account</h2>
                    </div>
                </div>
                <div class="row tm-edit-product-row">
                    <div class="col-xl-6 col-lg-6 col-md-12">
                        <form action="edit-account" method="post" class="tm-edit-product-form">
                            <div class="form-group mb-3">
                                <label

                                >Product UserId
                                </label>
                                <input
                                        value="${st.userid}"
                                        name="userid"
                                        type="text"
                                        class="form-control validate"
                                        readonly

                                />
                            </div>
                            <div class="form-group mb-3">
                                <label

                                >Product username
                                </label>
                                <input
                                        value="${st.name}"
                                        name="username"
                                        type="text"
                                        class="form-control validate"

                                />
                            </div>
                            <div class="form-group mb-3">
                                <label

                                >Product Password
                                </label>
                                <input
                                        value="${st.password}"
                                            name="password"
                                        type="text"
                                        class="form-control validate"

                                />
                            </div>
                            <div class="form-group mb-3">
                                <label

                                >Product Name
                                </label>
                                <input
                                        value="${st.name}"
                                        name="name"
                                        type="text"
                                        class="form-control validate"

                                />
                            </div>
                            <div class="form-group mb-3">
                                <label

                                >Product Phone
                                </label>
                                <input
                                        value="${st.phone}"
                                        name="phone"
                                        type="text"
                                        class="form-control validate"

                                />
                            </div>
                            <div class="form-group mb-3">
                                <label

                                >Product Email
                                </label>
                                <input
                                        value="${st.email}"
                                        name="email"
                                        type="text"
                                        class="form-control validate"

                                />
                            </div>
                            <div class="form-group mb-3">
                                <label

                                >Product address
                                </label>
                                <input
                                        value="${st.address}"
                                        name="address"
                                        type="text"
                                        class="form-control validate"

                                />
                            </div>


                            <div class="col-12">
                                <button type="submit" class="btn btn-primary btn-block text-uppercase">Add Product Now</button>
                            </div>



                        </form>
                    </div>
                    <div class="col-xl-6 col-lg-6 col-md-12 mx-auto mb-4">
                        <div class="tm-product-img-dummy mx-auto">
                            <i
                                    class="fas fa-cloud-upload-alt tm-upload-icon"
                                    onclick="document.getElementById('fileInput').click();"
                            ></i>
                        </div>
                        <div class="custom-file mt-3 mb-3">
                            <input id="fileInput" type="file" style="display:none;" />
                            <input
                                    type="button"
                                    class="btn btn-primary btn-block mx-auto"
                                    value="UPLOAD PRODUCT IMAGE"
                                    onclick="document.getElementById('fileInput').click();"
                            />
                        </div>
                    </div>


                </div>
            </div>
        </div>
    </div>
</div>
<footer class="tm-footer row tm-mt-small">
    <div class="col-12 font-weight-light">
        <p class="text-center text-white mb-0 px-4 small">
            Copyright &copy; <b>2022</b> All rights reserved.

            Design: <a rel="nofollow noopener" href="https://templatemo.com" class="tm-footer-link">Team: Thong Dan Phuc</a>
        </p>
    </div>
</footer>

<script src="admin/js/jquery-3.3.1.min.js"></script>
<!-- https://jquery.com/download/ -->
<script src="admin/js/bootstrap.min.js"></script>
<!-- https://getbootstrap.com/ -->
</body>
</html>
