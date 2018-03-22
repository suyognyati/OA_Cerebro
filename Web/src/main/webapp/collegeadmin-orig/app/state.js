(function(){
	"use strict";
	var app = angular.module("collegeadmin");
	
	app.config(["$stateProvider",
	            "$urlRouterProvider",
	            "$httpProvider",
	            "globalConstants",
	            "vendorConstants",
		         function($stateProvider, $urlRouterProvider, $httpProvider, globalConstants, vendorConstants){
		
					var basePath = "";
					basePath = globalConstants.rootLocation + vendorConstants.vendorLocation;
					
					var vendorTemplatesFolderPath = "app/templates/";
					var vendorControllersFolderPath = "app/controllers/";
					var vendorServicesFolderPath = "app/services/";
		
				    $urlRouterProvider.otherwise("/existingEntry");
					
					$stateProvider
					
					.state("vendorHome",{
							url: "/vendorHome",
							views: {
								"mainview":{
				                	templateUrl: basePath + vendorTemplatesFolderPath + "vendorHomeView.html",
				                	controller:"VendorHomeCtrl as vm",
								}
							},
							resolve: {
								userDetail : ['$ocLazyLoad', function($ocLazyLoad){
									return $ocLazyLoad.load({
										name : 'vendor',
										files : [
										     basePath + vendorControllersFolderPath + 'vendorHomeCtrl.js'
										     
										]
								
									})
								}]
							}
					})
					
					.state("newUser",{
						url: "/newUser",
						views: {
							"mainview":{
			                	templateUrl: basePath + vendorTemplatesFolderPath + "newUserView.html",
			                	controller:"NewUserCtrl as vm",
							}
						},
						resolve: {
							userDetail : ['$ocLazyLoad', function($ocLazyLoad){
								return $ocLazyLoad.load({
									name : 'vendor',
									files : [
									     basePath + vendorControllersFolderPath + 'newUserCtrl.js',
									     basePath + vendorServicesFolderPath + 'newUserService.js'
									]
							
								})
							}]
						}
					})
					
					.state("existingEntry",{
						url: "/existingEntry",
						views: {
							"mainview":{
			                	templateUrl: basePath + vendorTemplatesFolderPath + "existingUserView.html",
			                	controller:"ExistingUserCtrl as vm",
							}
						},
						resolve: {
							userDetail : ['$ocLazyLoad', function($ocLazyLoad){
								return $ocLazyLoad.load({
									name : 'vendor',
									files : [
									     basePath + vendorControllersFolderPath + 'existingUserCtrl.js',
									     basePath + vendorServicesFolderPath + 'existingUserService.js'
									]
							
								})
							}]
						}
					})
					
					.state("vendorHome.search",{
							url: "/search",
							views: {
								"view":{
				                	templateUrl: basePath + vendorTemplatesFolderPath + "searchView.html",
				                	controller:"SearchCtrl as vm",
								}
							},
							resolve: {
								userDetail : ['$ocLazyLoad', function($ocLazyLoad){
									return $ocLazyLoad.load({
										name : 'vendor',
										files : [
										     basePath + vendorControllersFolderPath + 'searchCtrl.js'
										]
								
									})
								}]
							}
					})
				
					.state("vendorHome.dashboard",{
						url: "/dashboard",
						views: {
							"view":{
			                	templateUrl: basePath + vendorTemplatesFolderPath + "dashboardView.html",
			                	controller:"DashboardCtrl as vm",
							}
						},
						resolve: {
							userDetail : ['$ocLazyLoad', function($ocLazyLoad){
								return $ocLazyLoad.load({
									name : 'vendor',
									files : [
									     basePath + vendorControllersFolderPath + 'dashboardCtrl.js',
									]
							
								})
							}]
						}
				})
			
				.state("vendorHome.collegeList",{
					url: "/collegeList",
					views: {
						"view":{
		                	templateUrl: basePath + vendorTemplatesFolderPath + "collegeListView.html",
		                	controller:"CollegeListCtrl as vm",
						}
					},
					resolve: {
						userDetail : ['$ocLazyLoad', function($ocLazyLoad){
							return $ocLazyLoad.load({
								name : 'vendor',
								files : [
								     basePath + vendorControllersFolderPath + 'collegeListCtrl.js'
								]
						
							})
						}]
					}
				})

				.state("vendorHome.appliedStudentList",{
					url: "/appliedStudentList",
					views: {
						"view":{
		                	templateUrl: basePath + vendorTemplatesFolderPath + "appliedStudentListView.html",
		                	//controller:"CollegeListCtrl as vm",
						}
					},
					/*resolve: {
						userDetail : ['$ocLazyLoad', function($ocLazyLoad){
							return $ocLazyLoad.load({
								name : 'vendor',
								files : [
								     basePath + vendorControllersFolderPath + 'collegeListCtrl.js'
								]
						
							})
						}]
					}*/
				})

			}]
		);
	
}());