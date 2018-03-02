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
	     .state('home.basicDetail', {
			url: '/basicdetail',
			templateUrl: 'ngapp/home/views/applicantDetailView.html',
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
							'ngapp/home/controllers/applicantDetailCtrl.js',
							'ngapp/home/services/applicantDetailService.js'
						]
					});
				}]
			}
		})
		.state('home.educationalDetail', {
			url: '/educationdetail',
			templateUrl: 'ngapp/home/views/educationInformationView.html',
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
							'ngapp/home/controllers/educationInformationCtrl.js',
							'ngapp/home/services/educationInformationService.js'
						]
					});
				}]
			}
		})
		.state('home.qualificationDetail', {
			url: '/educationinformation/:qualification?:qualificationMainLevel',
			templateUrl:
			function (stateParams){
				if(stateParams.qualificationMainLevel == 1
						/*&& stateParams.qualification == "ssc"*/) {
					return "ngapp/home/views/qualificationDetailView/sscView.html"
				} else if((stateParams.qualificationMainLevel >= 2 && stateParams.qualificationMainLevel <= 3)
						/*&& stateParams.qualification == "hsc"*/) {
					return "ngapp/home/views/qualificationDetailView/hscView.html"
				} else if(stateParams.qualificationMainLevel == 4
						/*&& stateParams.qualification == "diploma"*/) {
					return "ngapp/home/views/qualificationDetailView/diplomaView.html"
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
							'ngapp/home/controllers/qualificationDetailCtrl.js',
							'ngapp/home/services/qualificationDetailService.js'
						]
					});
				}]
			}
		})

	};

}());
