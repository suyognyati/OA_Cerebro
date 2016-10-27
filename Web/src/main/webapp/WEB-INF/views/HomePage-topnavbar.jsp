<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<title>Admission Details</title>
	<!-- Style sheets -->
<link href="<c:url value='/static/vendors/bootstrap-3.3.6-dist/css/bootstrap.css' />"
	rel="stylesheet" />
	<link href="<c:url value='/static/css/angularapp.css' />" rel="stylesheet" />

	<!-- Library Scripts -->
<script src="<c:url value='/static/js/jquery-1.10.2.js' />"></script>
<script src="<c:url value='/static/js/angular.js' />"></script>
<script src="<c:url value='/static/js/angular-resource.js' />"></script>
<script src="<c:url value='/static/js/angular-mocks.js' />"></script>
<script src="<c:url value='/static/js/angular-ui-router.js' />"></script>
<script src="<c:url value='/static/vendors/ocLazyLoad.min.js' />"></script>
<script src="<c:url value='/static/js/bootstrap.js' />"></script>
<script src="<c:url value='/static/js/angular-ui-bootstrap.min.js' />"></script>

	<!-- Application Scripts -->
<script src="<c:url value='/user/app/app.js' />"></script>
<script src="<c:url value='/user/app/state.js' />"></script>

	<!-- Services -->
<script src="<c:url value='/user/common/common.services.js' />"></script>

</head>
<body ng-app="admission">
	<div class="container-fluid">
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container-fluid">
			    <div class="navbar-header">
			      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
			        <span class="sr-only">Toggle navigation</span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			      </button>
			      <a class="navbar-brand theme-color logo" href="#">
			      	<span class="glyphicon glyphicon-home"></span> 
			      	F.Y.J.C. Admissions
			      </a>
			    </div>
			
			    <!-- Collect the nav links, forms, and other content for toggling -->
			    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			    	<ul class="nav navbar-nav navbar-right">
				    	<li>
				        	<a href="<c:url value="/logout" />" class="theme-color">
				        		<span class="glyphicon glyphicon-log-out"></span> Logout
				        	</a>
				        </li>
				        <!-- <button type="button" class="btn btn-primary btn-warning-style navbar-btn" 
				        	id="signUpButton" data-toggle="modal" onclick="location.href='/Web/logout'">
				        	Log out
				        </button> -->
			      	</ul>
			    </div>
		    </div>
		</nav>
	</div>

	<div class="container-fluid" style="margin-top: 5%">
		<div class="col-md-3 col-sm-3">
			<div class="panel panel-primary">
			<!-- <div class="panel-heading">
				<span style="font-family: Verdana; font-size: 15pt">
		        	<strong>Hi</strong>
		        </span>
			</div> -->
			<ul class="nav nav-pills nav-stacked">
				<li class="pills-content"><a ui-sref="basicDetail"><strong>Basic Details </strong></a></li>
				<li class="pills-content"><a ui-sref="personalDetail"><strong>Personal Details</strong></a></li>
				<li class="pills-content"><a ui-sref="educationInformation"><strong>Education Information</strong></a></li>
				<li class="pills-content"><a ui-sref="familyInformation"><strong>Family Information</strong></a></li>
				<li class="pills-content"><a ui-sref="otherInformation"><strong>Other Information</strong></a></li>
				<li class="pills-content"><a href="#"><strong>Upload Documents</strong></a></li>
				<li class="pills-content"><a href="#"><strong>Apply Courses</strong></a></li>
			</ul>
			</div>
		</div>
		<div class="col-md-8 col-sm-8">
			<div ui-view="view"></div>
		</div>
	</div>

</body>
</html>