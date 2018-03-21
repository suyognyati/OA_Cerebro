(function(){
	"use strict";
	var app = angular.module("appnew");

	app.config(['$stateProvider',
	            '$urlRouterProvider',
	            '$ocLazyLoadProvider',
	            '$breadcrumbProvider',
	            StudentStates]);

/*Function StudentState START*/

function StudentStates($stateProvider, $urlRouterProvider, $ocLazyLoadProvider, $breadcrumbProvider) {

	$stateProvider

	/**
	* States for Student login and register
	* */
	.state('studentsimple.login', {
		url: '/login',
        templateUrl: 'ngapp/student/views/login.html',
        controller: "StudentLoginCtrl as vm",
		//page title goes here
		ncyBreadcrumb: {
			label: 'Student Login',
		},
		//page subtitle goes here
		params: { subtitle: 'Student Login' },
          resolve: {
			loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
				// you can lazy load controllers
				return $ocLazyLoad.load({
					files: ['ngapp/student/controllers/studentLoginCtrl.js',
					        'ngapp/student/services/studentLoginService.js']
				});
			}]
		}
	})

	/**
	* States for LoggedIn Students
	* */
	.state('student.dashboard', {
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
					serie: true,
					files: ['ngapp/home/controllers/dashboard.js']
				});
			}]
		}
	})

	.state('student.profile', {
		url: '/profile',
		abstract: true,
		//templateUrl: 'ngapp/home/views/dashboard.html',
		//controller:'dashboardCtrl as vm',

		//page title goes here
		ncyBreadcrumb: {
			label: 'Dashboard',
		},
		//page subtitle goes here
		params: { subtitle: 'Welcome to home' },
	})
	.state('student.profile.personalDetail', {
		url: '/personaldetail',
		templateUrl: 'ngapp/student/views/studentprofile/personalDetailView.html',
		controller: 'PersonalDetailCtrl as vm',

		//page title goes here
		ncyBreadcrumb: {
			label: 'Personal Detail',
		},
		//page subtitle goes here
		params: { subtitle: 'Personal Details' },
		resolve: {
			loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
				// you can lazy load controllers
				return $ocLazyLoad.load({
					serie: true,
					files: [
					        'ngapp/student/controllers/personalDetailCtrl.js',
					        'ngapp/student/services/personalDetailService.js'
					        ]
				});
			}]
		}
	})
	.state('student.profile.userDetail', {
		url: '/personaldetail',
		templateUrl: 'ngapp/student/views/studentprofile/userDetailView.html',
		controller: 'UserDetailCtrl as vm',

		//page title goes here
		ncyBreadcrumb: {
			label: 'User Detail',
		},
		//page subtitle goes here
		params: { subtitle: 'User Details' },
		resolve: {
			loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
				// you can lazy load controllers
				return $ocLazyLoad.load({
					serie: true,
					files: [
					        'ngapp/student/controllers/userDetailCtrl.js',
					        'ngapp/student/services/userDetailService.js'
					        ]
				});
			}]
		}
	})
	.state('student.profile.address', {
		url: '/address',
		templateUrl: 'ngapp/student/views/studentprofile/addressView.html',
		controller: 'AddressCtrl as vm',

		//page title goes here
		ncyBreadcrumb: {
			label: 'Address Detail',
		},
		//page subtitle goes here
		params: { subtitle: 'Address Details' },
		resolve: {
			loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
				// you can lazy load controllers
				return $ocLazyLoad.load({
					serie: true,
					files: [
					        'ngapp/student/controllers/addressCtrl.js',
					        'ngapp/student/services/addressService.js'
					        ]
				});
			}]
		}
	})
	.state('student.profile.educationInformation', {
		url: '/educationinformation',
		templateUrl: 'ngapp/student/views/studentprofile/educationInformationView.html',
		controller: 'EducationInformationCtrl as vm',

		//page title goes here
		ncyBreadcrumb: {
			label: 'Educational Detail',
		},
		//page subtitle goes here
		params: { subtitle: 'Educational Details' },
		resolve: {
			loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
				// you can lazy load controllers
				return $ocLazyLoad.load({
					serie: true,
					files: [
					        'ngapp/student/controllers/educationInformationCtrl.js',
					        'ngapp/student/services/educationInformationService.js'
					        ]
				});
			}]
		}
	})
	.state('student.profile.qualificationDetail', {
		url: '/educationinformation/:qualification?:qualificationMainLevel',
		templateUrl:
			function (stateParams){
				if(stateParams.qualificationMainLevel == 1
						/*&& stateParams.qualification == "ssc"*/) {
					return "ngapp/student/views/studentprofile/sscView.html"
				} else if((stateParams.qualificationMainLevel >= 2 && stateParams.qualificationMainLevel <= 3)
						/*&& stateParams.qualification == "hsc"*/) {
					return "ngapp/student/views/studentprofile/hscView.html"
				} else if(stateParams.qualificationMainLevel == 4
						/*&& stateParams.qualification == "diploma"*/) {
					return "ngapp/student/views/studentprofile/diplomaView.html"
				} else {
					return false;
				}

				//return basePath + "templates/states/" + stateParams.qualification + "View.html"
			},
		controller: 'QualificationDetailCtrl as vm',

		//page title goes here
		ncyBreadcrumb: {
			label: 'Qualification Detail',
		},
		//page subtitle goes here
		params: { subtitle: 'Qualification Details', qualificationId : null, newQualification : false },
		resolve: {
			loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
				// you can lazy load controllers
				return $ocLazyLoad.load({
					serie: true,
					files: [
					        'ngapp/student/controllers/qualificationDetailCtrl.js',
					        'ngapp/student/services/qualificationDetailService.js'
					        ]
				});
			}]
		}
	})

	.state("student.profile.occupationReservation",{
			url: "/occupationreservation",
			templateUrl: 'ngapp/student/views/studentprofile/occupationReservationView.html',
			controller:"OccupationReservationCtrl as vm",

			//page title goes here
			ncyBreadcrumb: {
				label: 'OccupationReservation Detail',
			},
			//page subtitle goes here
			params: { subtitle: 'OccupationReservation Detail' },
			resolve: {
				loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
					// you can lazy load controllers
					return $ocLazyLoad.load({
						serie: true,
						files: [
							   'ngapp/student/controllers/occupationReservationCtrl.js',
							   'ngapp/student/services/occupationReservationService.js'
							   ]
					});
				}]
			}
	})

	.state("student.profile.uploadPhotoSign",{
		url: "/uploadphotosign",
		templateUrl:'ngapp/student/views/studentprofile/uploadPhotoSignView.html',
		controller:"UploadPhotoSignCtrl as vm",

		//page title goes here
		ncyBreadcrumb: {
			label: 'UploadPhotoSign',
		},
		//page subtitle goes here
		params: { subtitle: 'UploadPhotoSign' },
		resolve: {
			loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
				// you can lazy load controllers
				return $ocLazyLoad.load({
					serie: true,
					files: [
						   'ngapp/student/controllers/uploadPhotoSignCtrl.js',
						   'ngapp/student/services/uploadPhotoSignService.js'
						   ]
				});
			}]
		}
	})

	.state("student.profile.uploadDocuments",{
		url: "/uploaddocuments",
		templateUrl:'ngapp/student/views/studentprofile/uploadDocumentsView.html',
		controller:"UploadDocumentsCtrl as vm",

		//page title goes here
		ncyBreadcrumb: {
			label: 'UploadDocuments',
		},
		//page subtitle goes here
		params: { subtitle: 'UploadDocuments' },
		resolve: {
			loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
				// you can lazy load controllers
				return $ocLazyLoad.load({
					serie: true,
					files: [
						   'ngapp/student/controllers/uploadDocumentsCtrl.js',
						   'ngapp/student/services/uploadDocumentsService.js'
						   ]
				});
			}]
		}
	})

};

/*Function StudentState END*/

}());
