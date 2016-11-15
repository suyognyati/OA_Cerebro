(function(){
	"use strict";
	var app = angular.module("hello");
	
	app.config(["$stateProvider",
	            "$urlRouterProvider",
	            "$httpProvider",
		         function($stateProvider, $urlRouterProvider, $httpProvider){
		
					$urlRouterProvider.otherwise("/login");
					
					$stateProvider
					
					.state("login",{
							url: "/login",
							views: {
								"view":{
				                	templateUrl:"static/templates/states/login.html",
				                	controller:"LoginCtrl as vm",
								}
							},
							resolve: {
								login : ['$ocLazyLoad', function($ocLazyLoad){
									return $ocLazyLoad.load({
										name : 'hello',
										files : [
										     'static/app/controllers/loginCtrl.js'
										]
								
									})
								}]
							}
					})
					.state("register",{
							url: "/register",
							views: {
								"view":{
				                	templateUrl:"static/templates/states/register.html",
				                	controller:"RegisterCtrl as vm",
								}
							},
							resolve: {
								login : ['$ocLazyLoad', function($ocLazyLoad){
									return $ocLazyLoad.load({
										name : 'hello',
										files : [
										     'static/app/controllers/registerCtrl.js'
										]
								
									})
								}]
							}
					})
					
					$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
			}]
		);
	
}());