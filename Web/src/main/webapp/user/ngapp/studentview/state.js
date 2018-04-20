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

		.state('studentview.dashboard', {
			url: '/dashboard',
			templateUrl: 'ngapp/studentview/views/dashboard.html',
	          controller:'dashboardCtrl as vm',

			ncyBreadcrumb: {
				label: 'Dashboard',
			},
			params: { subtitle: 'Welcome to studentview' },
			resolve: {
				loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
					return $ocLazyLoad.load({
						files: ['ngapp/studentview/controllers/dashboard.js']
					});
				}]
			}
		})
	     .state('studentview.profileDetail', {
			url: '/profiledetail',
			templateUrl: 'ngapp/studentview/views/profileView.html',
			controller:"ProfileViewCtrl as vm",
			ncyBreadcrumb: {
				label: 'Profile Detail',
			},
			params: { subtitle: 'Search colleges' },
			resolve: {
				loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
					return $ocLazyLoad.load({
						files: [
							'ngapp/studentview/controllers/profileViewCtrl.js',
							'ngapp/studentview/services/profileViewService.js'
						]
					});
				}]
			}
		})
		.state('studentview.educationalDetail', {
			url: '/educationaldetail',
			templateUrl: 'ngapp/studentview/views/educationalView.html',
			controller:"EducationalViewCtrl as vm",
			ncyBreadcrumb: {
				label: 'Educational Detail',
			},
			params: { 
				subtitle: 'Educational Detail',
				baseState: 'studentview'
			},
			resolve: {
				loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
					return $ocLazyLoad.load({
						files: [
							'ngapp/studentview/controllers/educationalViewCtrl.js',
							'ngapp/studentview/services/profileViewService.js'
						]
					});
				}]
			}
		})
		.state('studentview.qualificationDetail', {
			url: '/educationalinformation/:qualification/:qualificationMainLevel/:qualificationId',
			templateUrl:
			function (stateParams){
				if((stateParams.qualificationMainLevel >= 1 && stateParams.qualificationMainLevel <= 2)
						/*&& stateParams.qualification == "ssc"*/) {
					return "ngapp/studentview/views/qualificationDetailView/sscView.html"
				} else if(stateParams.qualificationMainLevel == 3
						/*&& stateParams.qualification == "hsc"*/) {
					return "ngapp/studentview/views/qualificationDetailView/hscView.html"
				} else if(stateParams.qualificationMainLevel >= 4
						/*&& stateParams.qualification == "diploma"*/) {
					return "ngapp/studentview/views/qualificationDetailView/diplomaView.html"
				} else {
					return false;
				}

				//return basePath + "templates/states/" + stateParams.qualification + "View.html"
			},
			controller:"QualificationDetailCtrl as vm",
			ncyBreadcrumb: {
				label: 'Qualification Detail',
			},
			params: {
				subtitle: 'Educational Detail',
			},
			resolve: {
				loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
					return $ocLazyLoad.load({
						files: [
							'ngapp/studentview/controllers/qualificationDetailCtrl.js',
							'ngapp/studentview/services/profileViewService.js'
						]
					});
				}]
			}
		})

	};

}());
