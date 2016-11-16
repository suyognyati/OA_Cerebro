(function(){
	"use strict";
	var app = angular.module("login");
	
	app.config(["$stateProvider",
	            "$urlRouterProvider",
	            "$httpProvider",
	            "globalConstants",
	            "loginConstants",
		         function($stateProvider, $urlRouterProvider, $httpProvider, globalConstants, loginConstants){
		
					var basePath = "";
					basePath = globalConstants.rootLocation + loginConstants.loginLocation;
		
					$urlRouterProvider.otherwise("/login");
					
					$stateProvider
					
					.state("login",{
							url: "/login",
							views: {
								"view":{
				                	templateUrl: basePath + "templates/states/login.html",
				                	controller:"LoginCtrl as vm",
								}
							},
							resolve: {
								login : ['$ocLazyLoad', function($ocLazyLoad){
									return $ocLazyLoad.load({
										name : 'hello',
										files : [
										       basePath + 'app/controllers/loginCtrl.js'
										]
								
									})
								}]
							}
					})
					.state("register",{
							url: "/register",
							views: {
								"view":{
				                	templateUrl: basePath + "templates/states/register.html",
				                	controller:"RegisterCtrl as vm",
								}
							},
							resolve: {
								login : ['$ocLazyLoad', function($ocLazyLoad){
									return $ocLazyLoad.load({
										name : 'hello',
										files : [
										       basePath + 'app/controllers/registerCtrl.js',
										       basePath + 'app/services/registerService.js'
										]
								
									})
								}]
							}
					})
					
					$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
			}]
		);
	
}());