<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<title>Admission Details</title>
	<!-- Style sheets -->
<link href="<c:url value='/static/vendors/bootstrap-3.3.6-dist/css/bootstrap.css' />"
	rel="stylesheet" />
	<link href="<c:url value='/static/css/angularapp.css' />" rel="stylesheet" />
	<link href="<c:url value='/static/css/customnavbar.css' />" rel="stylesheet" />
	<link href="<c:url value='/static/css/custombootstrap.css' />" rel="stylesheet" />
	<link href="<c:url value='/vendor/css/vendor.css' />" rel="stylesheet" />
	<link href="<c:url value='/vendor/css/vendor-dashboard-custom.css' />" rel="stylesheet" />

	<!-- Library Scripts -->
<script src="<c:url value='/static/js/jquery-1.10.2.js' />"></script>
<script src="<c:url value='/static/js/angular.js' />"></script>
<script src="<c:url value='/static/js/angular-resource.js' />"></script>
<script src="<c:url value='/static/js/angular-mocks.js' />"></script>
<script src="<c:url value='/static/js/angular-ui-router.js' />"></script>
<script src="<c:url value='/static/vendors/ocLazyLoad.min.js' />"></script>
<script src="<c:url value='/static/js/bootstrap.js' />"></script>
<script src="<c:url value='/static/js/angular-ui-bootstrap.min.js' />"></script>
<script src="<c:url value='/vendor/js/vendor.js' />"></script>

	<!-- Application Scripts -->
<script src="<c:url value='/static/app/app.js' />"></script>
<script src="<c:url value='/vendor/app/app.js' />"></script>
<script src="<c:url value='/vendor/app/state.js' />"></script>

</head>
<body ng-app="vendor">
	<%! 
		String imgsrc_old = "https://lh3.googleusercontent.com/-0tBZQoBE-QI/UwD16xm0m3I/AAAAAAAAAkU/mL1WSMcKfqA9il1M_4a0zt_yLP8z_YvSwCEw/w140-h140-p/f1bafc98-5fb5-4bc4-be04-f28b1c60332c";
		String imgsrc_old2 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT3ZxBKSEMF2gsHcvLH3NlMothBXSiSanwj-pxr6IEgZZtecMtJdA";
		String imgsrc = "/Web/static/images/user-icon.png";
		String img_new_user = "/Web/static/images/new-user.png";
		String img_existing_user = "/Web/static/images/existing-user.png";
		String img_search = "/Web/static/images/search.png";
		String img_dashboard = "/Web/static/images/dashboard.png";
		String logoImage = "/Web/vendor/images/c-logo.png";
	%>

	<header>
		<div class="container-fluid no-padding">
			<div class="row no-margin">
				<div class="col-md-6 no-padding">
					<img src=<%=logoImage%>>
					Online Admission Portal
				</div>
				<div class="col-md-6 no-padding headernav">
					<nav>
						<ul>
								<li><a ui-sref="vendorHome" class="active" id="home">Home</a></li>
								<li><a ui-sref="existingEntry" id="user">User</a></li>
								<li class="profileBorder">
									<div class="collapse navbar-collapse"
										id="bs-example-navbar-collapse-1">
										<ul class="nav navbar-nav navbar-right">
											<li class="dropdown-open"><a class="dropdown-toggle no-padding"
												href="" data-toggle="dropdown"> <img src=<%=imgsrc%>
													class="img-circle" width="40px" height="35px"> <!-- style="margin-right:20px"> -->
											</a>
												<div class="dropdown-menu"
													style="width: 300px; height: 150px; margin: 10px;">
													<div class="">
														<div class="col-md-4 col-sm-4" style="padding-top: 15px">
															<img src=<%=imgsrc%> class="img-circle" width="100px"
																height="100px">
														</div>
														<div class="col-md-8 col-sm-8"
															style="padding-left: 50px; padding-top: 10px; color:#333;">
															<label><span>${vendordetail.firstName}</span>&nbsp<span>${vendordetail.lastName}</span></label>
															<br>
													 <input type="button" class="btn btn-primary"
																value="View Profile"> <br>
															<br> <a href="<c:url value="/logout" />"
																class="theme-color logout"> <span
																class="glyphicon glyphicon-log-out"></span> Logout
															</a>
														</div>
													</div>
												</div>
											</li>
										</ul>
									</div>
								</li>
							</ul>
						</nav>
			</div>
</header>

	<div class="col-sm-12 no-padding content">
		<div ui-view="mainview"></div>
	</div>

</body>
</html>