<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<title>Admission Details</title>
	<!-- Style sheets -->
<link href="<c:url value='/static/vendors/bootstrap-3.3.6-dist/css/bootstrap.css' />"
	rel="stylesheet" />

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
<body ng-app="user">
<div class="container-fluid">
	<ul class="nav nav-pills" role="tablist">
		<a href="<c:url value="/logout" />">Logout</a>
		<!-- <li ng-show="authenticated"><a href="" ng-click="nav.logout()">logout</a></li> -->
	</ul>
	<div>
		<h4 align="center">Narmada Shaligram Kasat Charitable Trust</h4>
		<h1 align="center">Suyog Jr College</h1>
		<h5 align="center"><big>Online Admission for FYJC</big></h5>
	</div>
	<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <!-- <a class="navbar-brand" href="#">Brand</a> -->
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav nav-pills">
        <li><a ui-sref="basicDetail"><h4>Basic Details </h4></a></li>
        <li><a ui-sref="personalDetail"><h4>Personal Details</h4></a></li>
        <li><a ui-sref="educationInformation"><h4>Education Information</h4></a></li>
        <li><a ui-sref="familyInformation"><h4>Family Information</h4></a></li>
        <li><a ui-sref="otherInformation"><h4>Other Information</h4></a></li>
        <li><a href="#"><h4>Upload Documents</h4></a></li>
        <li><a href="#"><h4>Apply Courses</h4></a></li>
      </ul>
    </div>
  </div>
</nav>
</div>

	<div class="container">
		<div ui-view="view"></div>
	</div>

</body>
</html>