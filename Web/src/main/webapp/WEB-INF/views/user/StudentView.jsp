<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<title>Admission Details</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Style sheets -->
<link href="<c:url value='/static/vendors/bootstrap-3.3.6-dist/css/bootstrap.css' />" rel="stylesheet" />
<link href="<c:url value='/static/vendors/select/css/bootstrap-select.css' />" rel="stylesheet" />
<link href="<c:url value='/studentview/css/user.css' />" rel="stylesheet" />
<link href="<c:url value='/studentview/css/user-bootstrap-modified.css' />" rel="stylesheet" />

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
<script src="<c:url value='/studentview/js/main.js' />"></script>

<!-- Application Scripts -->
<script src="<c:url value='/static/app/app.js' />"></script>
<script src="<c:url value='/studentview/app/app.js' />"></script>
<script src="<c:url value='/studentview/app/state.js' />"></script>

</head>
<body ng-app="user">
	<%!String imgsrc_old = "https://lh3.googleusercontent.com/-0tBZQoBE-QI/UwD16xm0m3I/AAAAAAAAAkU/mL1WSMcKfqA9il1M_4a0zt_yLP8z_YvSwCEw/w140-h140-p/f1bafc98-5fb5-4bc4-be04-f28b1c60332c";
	String imgsrc_old2 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT3ZxBKSEMF2gsHcvLH3NlMothBXSiSanwj-pxr6IEgZZtecMtJdA";
	String imgsrc = "/Web/static/images/user-icon.png";
	String img_new_user = "/Web/static/images/new-user.png";
	String img_existing_user = "/Web/static/images/existing-user.png";
	String img_search = "/Web/static/images/search.png";
	String img_dashboard = "/Web/static/images/dashboard.png";
	String img_logo = "/Web/static/images/logo.jpg";
	String logoImage = "/Web/vendor/images/c-logo.png";
	String photo = "/Web/vendor/images/image.jpg";%>

	<header>
		<div class="container-fluid no-padding">
			<div class="row no-margin">
				<div class="col-md-6 no-padding">
					<img src=<%=logoImage%> class="logo">
					Online Admission Portal
				</div>
				<div class="col-md-6 no-padding headernav">
					<nav>
						<ul>
							<li><a ui-sref="vendorHome" class="active">Home</a></li>
							<li><a ui-sref="existingEntry">User</a></li>
							<li class="profileBorder">
								<div class="collapse navbar-collapse"
									id="bs-example-navbar-collapse-1">
									<ul class="nav navbar-nav navbar-right">
										<li class="dropdown-open"><a class="dropdown-toggle no-padding logout"
											href="" data-toggle="dropdown"> <img src=<%=imgsrc%>
												class="img-circle profileimg" width="40px" height="35px">
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
														<label><span>${student.firstName}</span>&nbsp;<span>${student.lastName}</span></label>
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
			</div>
		</div>
	</header>
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
							<li id="studentStatus" class="active"><a>Student Status</a></li>
							<li id="userProfile"> <a>User Profile</a></li>
							<li id="applyOnline"><a>Apply Online</a></li>
						</ul>
					</div>
				</div>
			</div>
		</nav>
				
		<div class="main">
			<div class="row row-custom-margin">
			    <div class="col-sm-2 left-nav col-sm-custompadding" id="mySidenav">
					<ul class="nav nav-pills nav-stacked submenu" data-spy="affix" data-offset-top="100">
						<li id="applicantlDetail"><a ui-sref="applicantDetail"><i class="glyphicon glyphicon-briefcase"></i> <span id="nav-text1" class="nav-text-display">Applicant's Details</span></a></li>
						<li id="educationInformation"><a ui-sref="educationInformation"><i class="glyphicon glyphicon-education"></i> <span id="nav-text3" class="nav-text-display">Educational Details</span></a></li>
					</ul>
			    </div>
				<div class="col-sm-10 main-content col-sm-custompadding" id="main-content"> <a class="btn btn-toggleleft nav-button-col" onclick="toggle()"><i class="glyphicon glyphicon-menu-hamburger"></i></a>
					<div ui-view="view"></div>
				</div>
			</div>
		</div>
	</div>
	<!-- <div class="footer fixed-bar">
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-12 col-sm-custompadding headercontent"></div>
			</div>
		</div>
	</div> -->
</body>

<script type="text/javascript">
	var bearer_token = "${Bearer}";
</script>

</html>