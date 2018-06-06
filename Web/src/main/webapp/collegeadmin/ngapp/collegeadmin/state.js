(function(){
	"use strict";
	var app = angular.module("app");

	app.config(['$stateProvider',
	            '$urlRouterProvider',
	            '$ocLazyLoadProvider',
	            '$breadcrumbProvider',
	            StudentStates]);

	function StudentStates($stateProvider, $urlRouterProvider, $ocLazyLoadProvider, $breadcrumbProvider) {

		var contextPath = "/Web";
		var userPath = "/student/"
		var userBasePath = contextPath + userPath;
		
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
		.state('collegeadmin.setCategoryWeightage', {
			url: '/setweightage/:programId',
			templateUrl: 'ngapp/collegeadmin/views/categoryWeightageView.html',
			controller:"CategoryWeightageCtrl as vm",
			ncyBreadcrumb: {
				label: 'Select Program',
			},
			params: { subtitle: 'Select Program' },
			resolve: {
				loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
					return $ocLazyLoad.load({
						files: [
							'ngapp/collegeadmin/controllers/categoryWeightageCtrl.js',
							'ngapp/collegeadmin/services/programService.js'
							
						]
					});
				}]
			}
		})
		.state('collegeadmin.meritList', {
			url: '/meritList/:programLevelId/:programId',
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
		
		/*START - Student profile view states*/
		
		.state('collegeadmin.meritList.profile', {
			url: '/profiledetail?:studentId',
			templateUrl: userBasePath + 'ngapp/studentview/views/profileView.html',
			controller:"ProfileViewCtrl as vm",
			ncyBreadcrumb: {
				label: 'Profile Detail',
			},
			params: { subtitle: 'Search colleges' },
			resolve: {
				loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
					return $ocLazyLoad.load({
						files: [
							userBasePath + 'ngapp/studentview/controllers/profileViewCtrl.js',
							userBasePath + 'ngapp/studentview/services/profileViewService.js'
						]
					});
				}]
			}
		})
		.state('collegeadmin.meritList.educationalDetail', {
			url: '/educationaldetail?:studentId',
			templateUrl: userBasePath + 'ngapp/studentview/views/educationalView.html',
			controller:"EducationalViewCtrl as vm",
			ncyBreadcrumb: {
				label: 'Educational Detail',
			},
			params: { 
				subtitle: 'Educational Detail',
				baseState: 'collegeadmin.meritList'
			},
			resolve: {
				loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
					return $ocLazyLoad.load({
						files: [
							userBasePath + 'ngapp/studentview/controllers/educationalViewCtrl.js',
							userBasePath + 'ngapp/studentview/services/profileViewService.js'
						]
					});
				}]
			}
		})
		.state('collegeadmin.meritList.qualificationDetail', {
			url: '/educationaldetail/:qualification/:qualificationGroup/:qualificationId',
			templateUrl:
			function (stateParams){
				if((stateParams.qualificationGroup >= 1 && stateParams.qualificationGroup <= 2)) {
					return userBasePath + "ngapp/studentview/views/qualificationDetailView/sscView.html"
				} else if(stateParams.qualificationGroup == 3) {
					return userBasePath + "ngapp/studentview/views/qualificationDetailView/hscView.html"
				} else if(stateParams.qualificationGroup == 4) {
					return userBasePath + "ngapp/studentview/views/qualificationDetailView/diplomaView.html"
				} else if(stateParams.qualificationGroup == 5) {
					return userBasePath + "ngapp/studentview/views/qualificationDetailView/degreeView.html"
				} else if(stateParams.qualificationGroup == 6) {
					return userBasePath + "ngapp/studentview/views/qualificationDetailView/pgView.html"
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
							userBasePath + 'ngapp/studentview/controllers/qualificationDetailCtrl.js',
							userBasePath + 'ngapp/studentview/services/profileViewService.js'
						]
					});
				}]
			}
		})
		
		/*END - Student profile view states*/

	};
	
	

}());
