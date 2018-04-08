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
		.state('collegeadmin.programLevel', {
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
		})
	    .state('collegeadmin.selectProgram', {
			url: '/selectProgram/:programCategoryId',
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
							'ngapp/collegeadmin/services/programSelectService.js'
							
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
