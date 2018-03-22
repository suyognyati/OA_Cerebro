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
	    .state('collegeadmin.programList', {
			url: '/programList',
			templateUrl: 'ngapp/collegeadmin/views/programListView.html',
			controller:"ProgramListCtrl as vm",
			ncyBreadcrumb: {
				label: 'Program List',
			},
			params: { subtitle: 'Search colleges' },
			resolve: {
				loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
					return $ocLazyLoad.load({
						files: [
							'ngapp/collegeadmin/controllers/programListCtrl.js',
							
						]
					});
				}]
			}
		})
		.state('collegeadmin.appliedStudentList', {
			url: '/appliedStudentList',
			templateUrl: 'ngapp/collegeadmin/views/appliedStudentListView.html',
			ncyBreadcrumb: {
				label: 'Applied Student List',
			},
			/*params: { subtitle: 'Search colleges' },
			resolve: {
				loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
					return $ocLazyLoad.load({
						files: [
							'ngapp/collegeadmin/controllers/programListCtrl.js',
							
						]
					});
				}]
			}*/
		})
		/*.state('studentview.educationalDetail', {
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
							'ngapp/studentview/services/educationalViewService.js'
						]
					});
				}]
			}
		})
		.state('studentview.qualificationDetail', {
			url: '/educationalinformation/:qualification/:qualificationMainLevel/:qualificationId',
			templateUrl:
			function (stateParams){
				if(stateParams.qualificationMainLevel == 1
						&& stateParams.qualification == "ssc") {
					return "ngapp/studentview/views/qualificationDetailView/sscView.html"
				} else if((stateParams.qualificationMainLevel >= 2 && stateParams.qualificationMainLevel <= 3)
						&& stateParams.qualification == "hsc") {
					return "ngapp/studentview/views/qualificationDetailView/hscView.html"
				} else if(stateParams.qualificationMainLevel == 4
						&& stateParams.qualification == "diploma") {
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
							'ngapp/studentview/services/qualificationDetailService.js'
						]
					});
				}]
			}
		})*/

	};

}());
