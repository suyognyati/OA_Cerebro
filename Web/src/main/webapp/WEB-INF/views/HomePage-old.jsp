<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<title>Product List</title>
<!-- Style sheets -->
<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet" />
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet" />

<!-- Library Scripts -->
<script src="<c:url value='/static/js/jquery-1.10.2.js' />"></script>
<script src="<c:url value='/static/js/angular.1.5.6.min.js' />"></script>
<script src="<c:url value='/static/js/angular-resource.js' />"></script>
<script src="<c:url value='/static/js/angular-route.min.js' />"></script>
<script src="<c:url value='/static/js/angular-ui-router.min.js' />"></script>
<script src="<c:url value='/static/js/bootstrap.js' />"></script>
<script src="<c:url value='/static/vendors/ocLazyLoad.min.js' />"></script>

<!-- Application Scripts -->
<script src="<c:url value='/static/app/app.js' />"></script>
<script src="<c:url value='/static/common/common.services.js' />"></script>

<!-- Product Controllers -->
<%-- <script src="<c:url value='/static/app/controllers/productListCtrl.js' />"></script> --%>
</head>
<body ng-app="productmanagement">
	<nav class="navbar navbar-inverse">
        <div class="container">
            <a class="navbar-brand"
               ui-sref="home">Acme Product Management</a>
            <div class="navbar-header">
                <button type="button"
                        class="navbar-toggle"
                        data-toggle="collapse"
                        data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><a ui-sref="productList">Product List</a></li>
                    <li><a ui-sref="productEdit({productId:0})">
                        <i class="glyphicon glyphicon-plus"></i>
                        Add Product</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container">
        <div ui-view></div>
    </div>
    
</body>
</html>