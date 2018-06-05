<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="utf-8" />
    <title>Online Admission</title>
    
    <!-- Style sheets -->
	<link href="<c:url value='/static/vendors/bootstrap-3.3.6-dist/css/bootstrap.css' />" rel="stylesheet" />
	<!-- Library Scripts -->	
    <script src="<c:url value='/static/js/jquery-1.10.2.js' />"></script>
    <script src="<c:url value='/static/js/angular.js' />"></script>
	<script src="<c:url value='/static/js/angular-ui-router.js' />"></script>
	<script src="<c:url value='/static/vendors/ocLazyLoad.min.js' />"></script>
    <script src="<c:url value='/static/js/bootstrap.js' />"></script>
	<script src="<c:url value='/static/js/angular-ui-bootstrap.min.js' />"></script>
   	<!-- Application Scripts -->
   	<script src="<c:url value='/static/app/app.js' />"></script>
	<script src="<c:url value='/login/app/app.js' />"></script>
	<script src="<c:url value='/login/app/state.js' />"></script>
	<script src="<c:url value='/login/app/controllers/loginCtrl.js' />"></script>
</head>                       
<body ng-app="login">
	<%! int data=50; %>  
    <div class="jumbotron">
        <div class="container">
            <div class="col-sm-8 col-sm-offset-2">
            	<div class="col-md-6 col-md-offset-3">
	                <div ng-class="{ 'alert': flash, 'alert-success': flash.type === 'success', 'alert-danger': flash.type === 'error' }" ng-if="flash" ng-bind="flash.message"></div>
	                <div ui-view="view"></div>
                </div>
            </div>
        </div>
    </div>
</body>

<script type="text/javascript">
    var csrfparamname = "${_csrf.parameterName}";
    var csrfparamvalue = "${_csrf.token}";
    var isInvalidUser = ${param.error != null};
    var isLoggedOutUser = ${param.logout != null};
</script>   

</html>