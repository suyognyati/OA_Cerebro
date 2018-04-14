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

		.state('collegeadmin.dashboard', {
			url: '/dashboard',
			templateUrl: 'ngapp/collegeadmin/views/dashboard.html',
	          controller:'dashboardCtrl as vm',

			ncyBreadcrumb: {
				label: 'Dashboard',
			},
			params: { subtitle: 'Welcome to College Admin View' },
			resolve: {
				loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
					return $ocLazyLoad.load({
						files: ['ngapp/collegeadmin/controllers/dashboard.js']
					});
				}]
			}
		})
		/*.state('collegeadmin.programLevel', {
			url: '/programLevel',
			templateUrl: 'ngapp/collegeadmin/views/programLevelView.html',
			controller:"ProgramLevelCtrl as vm",
			ncyBreadcrumb: {
				label: 'Program Level',
			},
			params: { subtitle: 'Program Level' },
			resolve: {
				loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
					return $ocLazyLoad.load({
						files: [
							'ngapp/collegeadmin/controllers/programLevelCtrl.js',
							'ngapp/collegeadmin/services/programLevelService.js'
							
						]
					});
				}]
			}
		})*/
	    .state('collegeadmin.selectProgram', {
			url: '/selectProgram',
			templateUrl: 'ngapp/collegeadmin/views/programSelectView.html',
			controller:"ProgramSelectCtrl as vm",
			ncyBreadcrumb: {
				label: 'Select Program',
			},
			params: { subtitle: 'Select Program' },
			resolve: {
				loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
					return $ocLazyLoad.load({
						files: [
							'ngapp/collegeadmin/controllers/programSelectCtrl.js',
							'ngapp/collegeadmin/services/generateMeritListService.js'
							
						]
					});
				}]
			}
		})
		.state('collegeadmin.meritList', {
			url: '/meritList/:programCategoryId/:programId',
			templateUrl: 'ngapp/collegeadmin/views/generateMeritListView.html',
			controller:"GenerateMeritListCtrl as vm",
			ncyBreadcrumb: {
				label: 'Merit List',
			},
			params: { 
				subtitle: 'Merit List' },
			resolve: {
				loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
					return $ocLazyLoad.load({
						files: [
							'ngapp/collegeadmin/controllers/generateMeritListCtrl.js',
							'ngapp/collegeadmin/services/generateMeritListService.js'
							
						]
					});
				}]
			}
		})
		.state('collegeadmin.provisionalAdmissionList', {
			url: '/provisionalAdmissionList',
			templateUrl: 'ngapp/collegeadmin/views/appliedStudentListView.html',
			ncyBreadcrumb: {
				label: 'Applied Student List',
			},
			params: { subtitle: 'Provisional Admission' }			
		})
		

	};

}());
