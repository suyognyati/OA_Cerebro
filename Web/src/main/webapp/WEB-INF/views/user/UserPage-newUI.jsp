<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<title>Admission Details</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Style sheets -->
<link href="<c:url value='/static/vendors/bootstrap-3.3.6-dist/css/bootstrap.css' />" rel="stylesheet" />
<link href="<c:url value='/static/vendors/select/css/bootstrap-select.css' />" rel="stylesheet" />
<link href="<c:url value='/user/css/user.css' />" rel="stylesheet" />
<link href="<c:url value='/user/css/user-bootstrap-modified.css' />" rel="stylesheet" />

<!-- Library Scripts -->
<script src="<c:url value='/static/js/jquery-1.10.2.js' />"></script>
<script src="<c:url value='/static/js/angular.js' />"></script>
<script src="<c:url value='/static/js/angular-resource.js' />"></script>
<script src="<c:url value='/static/js/angular-mocks.js' />"></script>
<script src="<c:url value='/static/js/angular-ui-router.js' />"></script>
<script src="<c:url value='/static/vendors/ocLazyLoad.min.js' />"></script>
<script src="<c:url value='/static/js/angular-ui-bootstrap.min.js' />"></script>
<script	src="<c:url value='/static/vendors/bootstrap-3.3.6-dist/js/bootstrap.min.js' />"></script>
<script	src="<c:url value='/static/vendors/select/js/bootstrap-select.js' />"></script>
<script src="<c:url value='/user/js/main.js' />"></script>

<!-- Application Scripts -->
<script src="<c:url value='/static/app/app.js' />"></script>
<script src="<c:url value='/user/app/app.js' />"></script>
<script src="<c:url value='/user/app/state.js' />"></script>

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
		<nav class="mainMenu">
			<div class="navbar navbar-inverse">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar"> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
						<a class="navbar-brand" href="#">Dashboard</a> 
					</div>
					<div class="collapse navbar-collapse" id="myNavbar">
						<ul class="nav navbar-nav">
							<li class="active"><a href="#">Student Status</a></li>
							<li> <a>User Profile</a></li>
							<li><a>Apply Online</a></li>
						</ul>
					</div>
				</div>
			</div>
		</nav>
				
		<div class="main">
			<div class="row row-custom-margin">
			    <div class="col-sm-2 left-nav col-sm-custompadding" id="mySidenav">
					<ul class="nav nav-pills nav-stacked submenu" data-spy="affix" data-offset-top="120">
						<li><a ui-sref="userDetail"><i class="glyphicon glyphicon-user"></i> <span id="nav-text0" class="nav-text-display">User Details</span></a></li>
						<li class="active"><a ui-sref="personalDetail"><i class="glyphicon glyphicon-briefcase"></i> <span id="nav-text1" class="nav-text-display">Personal Details</span></a></li>
						<li><a ui-sref="address"><i class="glyphicon glyphicon-book"></i> <span id="nav-text2" class="nav-text-display">Address Details</span></a></li>
						<li><a ui-sref="educationInformation"><i class="glyphicon glyphicon-education"></i> <span id="nav-text3" class="nav-text-display">Educational Information</span></a></li>
						<li><a ui-sref="occupationReservation"><i class="glyphicon glyphicon-cog"></i> <span id="nav-text4" class="nav-text-display">Occupation & Reservation</span></a></li>
						<li><a href="#"><i class="glyphicon glyphicon-cloud-upload"></i> <span id="nav-text5" class="nav-text-display">Upload Photo & Signature</span></a></li>
					</ul>
			    </div>
				<div class="col-sm-10 main-content col-sm-custompadding" id="main-content"> <a class="btn btn-toggleleft nav-button-col" href="#" onclick="toggle()"><i class="glyphicon glyphicon-menu-hamburger"></i></a>
					<div ui-view="view"></div>
				</div>
			</div>
		</div>
	</div>
	<div class="footer fixed-bar">
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-12 col-sm-custompadding headercontent"></div>
			</div>
		</div>
	</div>
</body>

<script type="text/javascript">
	var bearer_token = "${Bearer}";
</script>

</html>