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

			//page title goes here
			ncyBreadcrumb: {
				label: 'Dashboard',
			},
			//page subtitle goes here
			params: { subtitle: 'Welcome to studentview' },
			resolve: {
				loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
					// you can lazy load controllers
					return $ocLazyLoad.load({
						files: ['ngapp/studentview/controllers/dashboard.js']
					});
				}]
			}
		})
	     .state('studentview.basicDetail', {
			url: '/basicdetail',
			templateUrl: 'ngapp/studentview/views/applicantDetailView.html',
			controller:"ApplicantDetailCtrl as vm",
			//page title goes here
			ncyBreadcrumb: {
				label: 'Basic Detail',
			},
			//page subtitle goes here
			params: { subtitle: 'Search colleges' },
			resolve: {
				loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
					// you can lazy load controllers
					return $ocLazyLoad.load({
						files: [
							'ngapp/studentview/controllers/applicantDetailCtrl.js',
							'ngapp/studentview/services/applicantDetailService.js'
						]
					});
				}]
			}
		})
		.state('studentview.educationalDetail', {
			url: '/educationdetail',
			templateUrl: 'ngapp/studentview/views/educationInformationView.html',
			controller:"EducationInformationCtrl as vm",
			//page title goes here
			ncyBreadcrumb: {
				label: 'Educational Detail',
			},
			//page subtitle goes here
			params: { subtitle: 'Educational Detail' },
			resolve: {
				loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
					// you can lazy load controllers
					return $ocLazyLoad.load({
						files: [
							'ngapp/studentview/controllers/educationInformationCtrl.js',
							'ngapp/studentview/services/educationInformationService.js'
						]
					});
				}]
			}
		})
		.state('studentview.qualificationDetail', {
			url: '/educationinformation/:qualification?:qualificationMainLevel',
			templateUrl:
			function (stateParams){
				if(stateParams.qualificationMainLevel == 1
						/*&& stateParams.qualification == "ssc"*/) {
					return "ngapp/studentview/views/qualificationDetailView/sscView.html"
				} else if((stateParams.qualificationMainLevel >= 2 && stateParams.qualificationMainLevel <= 3)
						/*&& stateParams.qualification == "hsc"*/) {
					return "ngapp/studentview/views/qualificationDetailView/hscView.html"
				} else if(stateParams.qualificationMainLevel == 4
						/*&& stateParams.qualification == "diploma"*/) {
					return "ngapp/studentview/views/qualificationDetailView/diplomaView.html"
				} else {
					return false;
				}

				//return basePath + "templates/states/" + stateParams.qualification + "View.html"
			},
			controller:"QualificationDetailCtrl as vm",
			//page title goes here
			ncyBreadcrumb: {
				label: 'Qualification Detail',
			},
			//page subtitle goes here
			params: {
				subtitle: 'Educational Detail',
				qualificationId : null,
				newQualification : false
			},
			resolve: {
				loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
					// you can lazy load controllers
					return $ocLazyLoad.load({
						files: [
							'ngapp/studentview/controllers/qualificationDetailCtrl.js',
							'ngapp/studentview/services/qualificationDetailService.js'
						]
					});
				}]
			}
		})

	};

}());
