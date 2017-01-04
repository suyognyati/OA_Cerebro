<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<title>Admission Details</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Style sheets -->
<link
	href="<c:url value='/static/vendors/bootstrap-3.3.6-dist/css/bootstrap.css' />"
	rel="stylesheet" />
<link href="<c:url value='/user/css/user.css' />" rel="stylesheet" />
<link href="<c:url value='/user/css/user-bootstrap-modified.css' />" rel="stylesheet" />

<!-- Library Scripts -->
<script src="<c:url value='/static/js/jquery-1.10.2.js' />"></script>
<script src="<c:url value='/static/js/angular.js' />"></script>
<script src="<c:url value='/static/js/angular-resource.js' />"></script>
<script src="<c:url value='/static/js/angular-mocks.js' />"></script>
<script src="<c:url value='/static/js/angular-ui-router.js' />"></script>
<script src="<c:url value='/static/vendors/ocLazyLoad.min.js' />"></script>
<script src="<c:url value='/static/js/bootstrap.js' />"></script>
<script src="<c:url value='/static/js/angular-ui-bootstrap.min.js' />"></script>
<script	src="<c:url value='/static/vendors/bootstrap-3.3.6-dist/js/bootstrap.min.js' />"></script>

<!-- Application Scripts -->
<script src="<c:url value='/static/app/app.js' />"></script>
<script src="<c:url value='/user/app/app.js' />"></script>
<script src="<c:url value='/user/app/state.js' />"></script>

<!-- Services -->
<script src="<c:url value='/user/common/common.services.js' />"></script>

</head>
<body ng-app="user">
	<%!String imgsrc_old = "https://lh3.googleusercontent.com/-0tBZQoBE-QI/UwD16xm0m3I/AAAAAAAAAkU/mL1WSMcKfqA9il1M_4a0zt_yLP8z_YvSwCEw/w140-h140-p/f1bafc98-5fb5-4bc4-be04-f28b1c60332c";
	String imgsrc_old2 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT3ZxBKSEMF2gsHcvLH3NlMothBXSiSanwj-pxr6IEgZZtecMtJdA";
	String imgsrc = "/Web/static/images/user-icon.png";
	String img_new_user = "/Web/static/images/new-user.png";
	String img_existing_user = "/Web/static/images/existing-user.png";
	String img_search = "/Web/static/images/search.png";
	String img_dashboard = "/Web/static/images/dashboard.png";
	String img_logo = "/Web/static/images/logo.jpg";%>

	<div class="header">
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-2">
					<img src=<%=img_logo %> class="img-responsive" style="height:100px"/>
				</div>
				<div class="col-sm-10">
					<h1 class="headercontent">Online Admission System</h1>
				</div>
			</div>
		</div>
	</div>
	<div class="section">
		<div class="menubar">
			<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle"
							data-toggle="collapse" data-target="#myNavbar">
							<span class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">Dashboard</a>
					</div>
					<div class="collapse navbar-collapse" id="myNavbar">
						<ul class="nav navbar-nav">
							<li class="active"><a href="#">Student Status</a></li>
							<li><a href="#">User Profile</a></li>
							<li><a href="#">Apply Online</a></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
		<div class="submenubar">
			<div class="container-fluid">
				<div class="row">
					<div class="col-sm-2 left-nav col-sm-custompadding ">
						<ul class="nav nav-pills nav-stacked customfont">
							<li><a ui-sref="userDetail"><strong>User Details </strong></a></li>
							<li class="active"><a ui-sref="personalDetail"><strong>Personal Details</strong></a></li>
							<li><a ui-sref="address"><strong>Address Details</strong></a></li>
							<li><a ui-sref="educationInformation"><strong>Educational Information</strong></a></li>
							<li><a href="#"><strong>Upload Photo & Signature</strong></a></li>
							<!-- <li class="active"><a href="#">View Profile</a></li>
							<li><a href="#">Application Status</a></li>
							<li><a href="#">Receipt/Transaction Details</a></li> -->
						</ul>
					</div>
					<div class="col-sm-10 col-sm-custompadding" style="background-color: #ffffff; padding-bottom: 50px">
						<div ui-view="view"></div>
					</div>
					<!-- <div class="col-sm-9 main-content"></div> -->
				</div>
			</div>
		</div>
	</div>
	<div class="footer fixed-bar">
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-12 headercontent"></div>
			</div>
		</div>
	</div>
</body>

<script type="text/javascript">
	var bearer_token = "${Bearer}";
</script>

</html>