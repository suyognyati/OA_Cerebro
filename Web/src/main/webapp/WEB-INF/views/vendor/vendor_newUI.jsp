<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en" ng-app="app">
<head>

	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<title>CoreUI - Open Source Bootstrap Admin Template</title>

	<!-- LOADING STYLE SHEET -->
		<!-- Styles from vendor -->
		<link href="<c:url value='/static/dependency/bootstrap-3.3.6-dist/css/bootstrap.css' />" rel="stylesheet" />
		<link href="<c:url value='/static/dependency/select/css/bootstrap-select.css' />" rel="stylesheet" />
		
		<!-- Bootstrap Custom Styles -->
		<link href="<c:url value='css/bootstrap-custom.css' />" rel="stylesheet" />
		
		<!-- CoreUI Style -->
		<link href="<c:url value='css/coreui-style.css' />" rel="stylesheet" />
		
		<!-- Image Editor Style -->
		<link href="<c:url value='/static/vendors/pm-image-crop-master/compile/unminified/ng-img-crop.css' />" rel="stylesheet" />
		
		<!-- Date Picker Style -->
		<link href="<c:url value='/static/css/angular-datepicker.css' />" rel="stylesheet" />
		
		<!-- My Custom Styles -->
		<link href="<c:url value='/user/css/userstyle.css' />" rel="stylesheet" />
		
		<link href="<c:url value='css/left-nav.css' />" rel="stylesheet" />
		<link href="<c:url value='css/aside-menu.css' />" rel="stylesheet" />
		<link href="<c:url value='css/mystyle.css' />" rel="stylesheet" />
     
	<!-- LOADING SCRIPTS -->	
		<!-- Bootstrap and necessary plugins -->
		<script src="<c:url value='/static/dependency/jquery-1.10.2.js' />"></script>
		<script src="<c:url value='/static/dependency/bootstrap-3.3.6-dist/js/bootstrap.min.js' />"></script>
		<script src="<c:url value='/static/dependency/select/js/bootstrap-select.js' />"></script>
		
		<!-- AngularJS -->
		<script src="<c:url value='/static/node_modules/angular/angular.min.js' />"></script>
		
		<!-- AngularJS plugins -->
		<script src="<c:url value='/static/node_modules/angular-animate/angular-animate.min.js' />"></script>
		<script src="<c:url value='/static/node_modules/angular-sanitize/angular-sanitize.min.js' />"></script>
		<script src="<c:url value='/static/node_modules/@uirouter/angularjs/release/angular-ui-router.min.js' />"></script>
		<script src="<c:url value='/static/node_modules/oclazyload/dist/ocLazyLoad.min.js' />"></script>
		<script src="<c:url value='/static/node_modules/angular-breadcrumb/dist/angular-breadcrumb.min.js' />"></script>
		<script src="<c:url value='/static/node_modules/angular-loading-bar/build/loading-bar.min.js' />"></script>
		
		<script src="<c:url value='/static/dependency/angular-ui-bootstrap.min.js' />"></script>
		
		<!-- Datepicker plugin -->
		<script src="<c:url value='/static/js/angular-datepicker.js' />"></script>
		
		<!-- Pagination plugin -->
		<script src="<c:url value='/static/js/dirPagination.js' />"></script>
		
		<!-- Multiselect plugin -->
		<script src="<c:url value='/static/node_modules/angularjs-dropdown-multiselect/dist/src/angularjs-dropdown-multiselect.js' />"></script>
		
		<!-- Image editor plugins -->
		<script src="<c:url value='/static/vendors/pm-image-crop-master/compile/unminified/ng-img-crop.js' />"></script>
		
		<!-- Custom js -->
		<script src="<c:url value='/user/js/user.js' />"></script>
		<script src="<c:url value='js/custom.js' />"></script>
		
		<!-- AngularJS CoreUI App scripts -->
		<script src="<c:url value='/static/app/app.js' />"></script>
		<script src="<c:url value='ngapp/app.js' />"></script>
		<script src="<c:url value='ngapp/student/services/sessionService.js' />"></script>
		
		<script src="<c:url value='ngapp/state.js' />"></script>
		<script src="<c:url value='ngapp/home/state.js' />"></script>
		<script src="<c:url value='ngapp/student/state.js' />"></script>
		
		<script src="<c:url value='ngapp/directives.js' />"></script>


</head>

<body class="header-fixed sidebar-fixed aside-menu-fixed aside-menu-hidden">

  <!-- User Interface -->
  <ui-view class="app"></ui-view>

</body>

<script type="text/javascript">
	var base_path = "${pageContext.request.contextPath}";
</script>

</html>
