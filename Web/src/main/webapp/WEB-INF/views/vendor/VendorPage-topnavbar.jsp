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
<script src="<c:url value='/static/app/app.js' />"></script>
<script src="<c:url value='/vendor/app/app.js' />"></script>
<script src="<c:url value='/vendor/app/state.js' />"></script>

</head>
<body ng-app="vendor">
	<%! 
		String imgsrc_old = "https://lh3.googleusercontent.com/-0tBZQoBE-QI/UwD16xm0m3I/AAAAAAAAAkU/mL1WSMcKfqA9il1M_4a0zt_yLP8z_YvSwCEw/w140-h140-p/f1bafc98-5fb5-4bc4-be04-f28b1c60332c";
		String imgsrc_old2 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT3ZxBKSEMF2gsHcvLH3NlMothBXSiSanwj-pxr6IEgZZtecMtJdA";
		String imgsrc = "/Web/static/images/new-user.png";
		String img_new_user = "/Web/static/images/new-user.png";
	%>

	<div class="container-fluid">
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="container-fluid">
			    <div class="navbar-header">
			      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
			        <span class="sr-only">Toggle navigation</span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			      </button>
			      <a class="navbar-brand logo" href="#" style="color: black; font-family: 'Comic Sans MS', cursive, sans-serif; font-size: xx-large;">
			      	<!-- <span class="glyphicon glyphicon-home"></span> --> 
			      	Online admission system
			      </a>
			    </div>
			
			    <!-- Collect the nav links, forms, and other content for toggling -->
			    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			    	<ul class="nav navbar-nav navbar-right">
				    	<li class="dropdown-open">
				    		<a class="dropdown-toggle" href="#" data-toggle="dropdown">
				    			<img src= <%=imgsrc %>
				    				 class="img-circle"
				    				 width="60px"
				    				 height="55px">
				    				 <!-- style="margin-right:20px"> -->
				    		</a>
				    		<div class="dropdown-menu" style="width:300px; height:150px; margin:10px;">
				    			<div class="">
				    				<div class="col-md-4 col-sm-4" style="padding-top: 15px">
				    					<img src=<%=imgsrc %> 
				    						 class="img-circle"
				    						 width="100px"
				    						 height="100px">
				    				</div>
				    				<div class="col-md-8 col-sm-8" style="padding-left: 50px; padding-top: 10px">
				    					<label><span>${userdetail.firstName}</span>&nbsp<span>${userdetail.lastName}</span></label>
				    					<br><br>
				    					<input type="button" class="btn btn-primary" value="View Profile">
				    					<br><br>
				    					<a href="<c:url value="/logout" />" class="theme-color">
				        					<span class="glyphicon glyphicon-log-out"></span> Logout
				        				</a>
				    				</div>
				    			</div>
				    		</div>
				    	</li>
			      	</ul>
			    </div>
		    </div>
		</nav>
	</div>

	<div class="container-fluid" style="margin-top: 8%">
		<div class="col-md-3 col-sm-3">
			<div class="panel panel-primary menu-div">
				<a ui-sref="userDetail">
					<img src= <%=img_new_user%>
			    				 width="90px"
			    				 height="85px">
				</a>
			
			</div>
		</div>
		<div class="col-md-8 col-sm-8">
			<div ui-view="view"></div>
		</div>
	</div>

</body>
</html>