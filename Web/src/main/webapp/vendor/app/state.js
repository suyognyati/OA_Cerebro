(function(){
	"use strict";
	var app = angular.module("vendor");
	
	app.config(["$stateProvider",
	            "$urlRouterProvider",
	            "$httpProvider",
	            "globalConstants",
	            "vendorConstants",
		         function($stateProvider, $urlRouterProvider, $httpProvider, globalConstants, vendorConstants){
		
					var basePath = "";
					basePath = globalConstants.rootLocation + vendorConstants.vendorLocation;
		
				    $urlRouterProvider.otherwise("/vendorHome/dashboard");
					
					$stateProvider
					
					.state("vendorHome",{
							url: "/vendorHome",
							views: {
								"mainview":{
				                	templateUrl: basePath + "templates/states/vendorHomeView.html",
				                	controller:"VendorHomeCtrl as vm",
								}
							},
							resolve: {
								userDetail : ['$ocLazyLoad', function($ocLazyLoad){
									return $ocLazyLoad.load({
										name : 'vendor',
										files : [
										     basePath + 'app/controllers/vendorHomeCtrl.js'
										     
										]
								
									})
								}]
							}
					})
					
					.state("newUser",{
						url: "/newUser",
						views: {
							"mainview":{
			                	templateUrl: basePath + "templates/states/newUserView.html",
			                	controller:"NewUserCtrl as vm",
							}
						},
						resolve: {
							userDetail : ['$ocLazyLoad', function($ocLazyLoad){
								return $ocLazyLoad.load({
									name : 'vendor',
									files : [
									     basePath + 'app/controllers/newUserCtrl.js',
									     basePath + 'app/services/newUserService.js'
									]
							
								})
							}]
						}
					})
					
					.state("existingEntry",{
						url: "/existingEntry",
						views: {
							"mainview":{
			                	templateUrl: basePath + "templates/states/existingUserView.html",
			                	controller:"ExistingUserCtrl as vm",
							}
						},
						resolve: {
							userDetail : ['$ocLazyLoad', function($ocLazyLoad){
								return $ocLazyLoad.load({
									name : 'vendor',
									files : [
									     basePath + 'app/controllers/existingUserCtrl.js',
									     basePath + 'app/services/existingUserService.js'
									]
							
								})
							}]
						}
					})
					
					.state("vendorHome.search",{
							url: "/search",
							views: {
								"view":{
				                	templateUrl: basePath + "templates/states/searchView.html",
				                	controller:"SearchCtrl as vm",
								}
							},
							resolve: {
								userDetail : ['$ocLazyLoad', function($ocLazyLoad){
									return $ocLazyLoad.load({
										name : 'vendor',
										files : [
										     basePath + 'app/controllers/searchCtrl.js'
										]
								
									})
								}]
							}
					})
				
					.state("vendorHome.dashboard",{
						url: "/dashboard",
						views: {
							"view":{
			                	templateUrl: basePath + "templates/states/dashboardView.html",
			                	controller:"DashboardCtrl as vm",
							}
						},
						resolve: {
							userDetail : ['$ocLazyLoad', function($ocLazyLoad){
								return $ocLazyLoad.load({
									name : 'vendor',
									files : [
									     basePath + 'app/controllers/dashboardCtrl.js',
									]
							
								})
							}]
						}
				})
			
				.state("vendorHome.collegeList",{
					url: "/collegeList",
					views: {
						"view":{
		                	templateUrl: basePath + "templates/states/collegeListView.html",
		                	controller:"CollegeListCtrl as vm",
						}
					},
					resolve: {
						userDetail : ['$ocLazyLoad', function($ocLazyLoad){
							return $ocLazyLoad.load({
								name : 'vendor',
								files : [
								     basePath + 'app/controllers/collegeListCtrl.js'
								]
						
							})
						}]
					}
			})
		
			}]
		);
	
}());