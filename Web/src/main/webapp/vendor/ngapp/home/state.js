(function(){
	"use strict";
	var app = angular.module("app");
	
	app.config(['$stateProvider', 
	            '$urlRouterProvider', 
	            '$ocLazyLoadProvider', 
	            '$breadcrumbProvider', 
	            StudentStates]);
	         
	function StudentStates($stateProvider, $urlRouterProvider, $ocLazyLoadProvider, $breadcrumbProvider) {
	
		$stateProvider
		
		.state('home.dashboard', {
			url: '/dashboard',
			templateUrl: 'ngapp/home/views/dashboard.html',
	          controller:'dashboardCtrl as vm',

			//page title goes here
			ncyBreadcrumb: {
				label: 'Dashboard',
			},
			//page subtitle goes here
			params: { subtitle: 'Welcome to home' },
			resolve: {
				loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
					// you can lazy load controllers
					return $ocLazyLoad.load({
						files: ['ngapp/home/controllers/dashboard.js']
					});
				}]
			}
		})
	     .state('home.searchcolleges', {
			url: '/colleges',
			templateUrl: 'ngapp/home/views/searchcolleges.html',
			//page title goes here
			ncyBreadcrumb: {
				label: 'Search Colleges',
			},
			//page subtitle goes here
			params: { subtitle: 'Search colleges' },
			resolve: {
				loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
					// you can lazy load controllers
					return $ocLazyLoad.load({
						files: ['ngapp/home/controllers/search-colleges.js']
					});
				}]
			}
		})
	
	};
	
}());