(function(){
	"use strict";
	var app = angular.module("app");

	app.config(['$stateProvider',
	            '$urlRouterProvider',
	            '$ocLazyLoadProvider',
	            '$breadcrumbProvider',
	            StudentStates]);

/*Function StudentState START*/

function StudentStates($stateProvider, $urlRouterProvider, $ocLazyLoadProvider, $breadcrumbProvider) {

	var contextPath = "/Web";
	var userPath = "/student/"
	var userBasePath = contextPath + userPath;
	
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
	
	.state('studentsimple.register', {
		url: '/register',
        templateUrl: 'ngapp/student/views/register.html',
        controller: "RegisterCtrl as vm",
		//page title goes here
		ncyBreadcrumb: {
			label: 'Register Student',
		},
		//page subtitle goes here
		params: { subtitle: 'Register Student' },
          resolve: {
			loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
				// you can lazy load controllers
				return $ocLazyLoad.load({
					files: ['ngapp/student/controllers/registerCtrl.js',
					        'ngapp/student/services/registerService.js']
				});
			}]
		}
	})

	/**
	* States for LoggedIn Students
	* */
	.state('student.dashboard', {
		url: '/dashboard',
		templateUrl: 'ngapp/student/views/dashboard.html',
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
	/*
	.state("student.profile.userDetail",{
		url: "/userdetails",
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
	})*/
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
					        'ngapp/student/services/profileDetailService.js'
					        ]
				});
			}]
		}
	})
	.state('student.profile.userDetail', {
		url: '/userdetail',
		templateUrl: 'ngapp/student/views/studentprofile/userDetailView.html',
		controller: 'UserDetailCtrl as vm',

		ncyBreadcrumb: {
			label: 'User Detail',
		},
		params: { subtitle: 'User Details' },
		resolve: {
			loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
				return $ocLazyLoad.load({
					serie: true,
					files: [
					        'ngapp/student/controllers/userDetailCtrl.js',
					        'ngapp/student/services/profileDetailService.js'
					        ]
				});
			}]
		}
	})
	.state('student.profile.address', {
		url: '/address',
		templateUrl: 'ngapp/student/views/studentprofile/addressView.html',
		controller: 'AddressCtrl as vm',

		ncyBreadcrumb: {
			label: 'Address Detail',
		},
		params: { subtitle: 'Address Details' },
		resolve: {
			loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
				return $ocLazyLoad.load({
					serie: true,
					files: [
					        'ngapp/student/controllers/addressCtrl.js',
					        'ngapp/student/services/profileDetailService.js'
					        ]
				});
			}]
		}
	})
	.state('student.profile.educationInformation', {
		url: '/educationinformation',
		templateUrl: 'ngapp/student/views/studentprofile/educationInformationView.html',
		controller: 'EducationInformationCtrl as vm',

		ncyBreadcrumb: {
			label: 'Educational Detail',
		},
		params: { subtitle: 'Educational Details' },
		resolve: {
			loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
				return $ocLazyLoad.load({
					serie: true,
					files: [
					        'ngapp/student/controllers/educationInformationCtrl.js',
					        'ngapp/student/services/profileDetailService.js'
					        ]
				});
			}]
		}
	})
	.state('student.profile.qualificationDetail', {
		url: '/educationinformation/:qualification/:qualificationGroup?:qualificationId:newQualification',
		templateUrl:
			function (stateParams){
				if((stateParams.qualificationGroup >= 1 && stateParams.qualificationGroup <= 2)
						/*&& stateParams.qualification == "ssc"*/) {
					return "ngapp/student/views/studentprofile/sscView.html"
				} else if((stateParams.qualificationGroup == 3)
						/*&& stateParams.qualification == "hsc"*/) {
					return "ngapp/student/views/studentprofile/hscView.html"
				} else if(stateParams.qualificationGroup >= 4
						/*&& stateParams.qualification == "diploma"*/) {
					return "ngapp/student/views/studentprofile/diplomaView.html"
				} else {
					return false;
				}

				//return basePath + "templates/states/" + stateParams.qualification + "View.html"
			},
		controller: 'QualificationDetailCtrl as vm',

		ncyBreadcrumb: {
			label: 'Qualification Detail',
		},
		params: { subtitle: 'Qualification Details' },
		resolve: {
			loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
				return $ocLazyLoad.load({
					serie: true,
					files: [
					        'ngapp/student/controllers/qualificationDetailCtrl.js',
					        'ngapp/student/services/profileDetailService.js'
					        ]
				});
			}]
		}
	})

	.state("student.profile.occupationReservation",{
			url: "/occupationreservation",
			templateUrl: 'ngapp/student/views/studentprofile/occupationReservationView.html',
			controller:"OccupationReservationCtrl as vm",

			ncyBreadcrumb: {
				label: 'OccupationReservation Detail',
			},
			params: { subtitle: 'OccupationReservation Detail' },
			resolve: {
				loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
					return $ocLazyLoad.load({
						serie: true,
						files: [
							   'ngapp/student/controllers/occupationReservationCtrl.js',
							   'ngapp/student/services/profileDetailService.js'
							   ]
					});
				}]
			}
	})

	.state("student.profile.uploadPhotoSign",{
		url: "/uploadphotosign",
		templateUrl:'ngapp/student/views/studentprofile/uploadPhotoSignView.html',
		controller:"UploadPhotoSignCtrl as vm",

		ncyBreadcrumb: {
			label: 'UploadPhotoSign',
		},
		params: { subtitle: 'UploadPhotoSign' },
		resolve: {
			loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
				return $ocLazyLoad.load({
					serie: true,
					files: [
						   'ngapp/student/controllers/uploadPhotoSignCtrl.js',
						   'ngapp/student/services/fileUploadService.js'
						   ]
				});
			}]
		}
	})

	.state("student.profile.uploadDocuments",{
		url: "/uploaddocuments",
		templateUrl:'ngapp/student/views/studentprofile/uploadDocumentsView.html',
		controller:"UploadDocumentsCtrl as vm",

		ncyBreadcrumb: {
			label: 'UploadDocuments',
		},
		params: { subtitle: 'UploadDocuments' },
		resolve: {
			loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
				return $ocLazyLoad.load({
					serie: true,
					files: [
						   'ngapp/student/controllers/uploadDocumentsCtrl.js',
						   'ngapp/student/services/fileUploadService.js'
						   ]
				});
			}]
		}
	})

	.state('student.application', {
		url: '/application',
		abstract: true,
		//templateUrl: 'ngapp/home/views/dashboard.html',
		//controller:'dashboardCtrl as vm',

		ncyBreadcrumb: {
			label: 'Application',
		},
		params: { subtitle: 'Welcome to home' },
	})
	/*.state("application",{
		url: "/application",
		templateUrl: 'ngapp/student/views/userapplication/applicationView.html',
		controller:"ApplicationCtrl as vm",

		//page title goes here
		ncyBreadcrumb: {
			label: 'Application',
		},
		//page subtitle goes here
		params: { subtitle: 'Application' },
		resolve: {
			loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
				// you can lazy load controllers
				return $ocLazyLoad.load({
					serie: true,
					files: [
						   'ngapp/student/controllers/applicationCtrl.js',
						  ]
				});
			}]
		}
	})*/

	.state("student.application.applyOnline",{
		url: "/applyonline",
		templateUrl: 'ngapp/student/views/userapplication/applyOnlineView.html',
		controller:"ApplyOnlineCtrl as vm",

		ncyBreadcrumb: {
			label: 'Apply Online',
		},
		params: { subtitle: 'Apply Online' },
		resolve: {
			loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
				return $ocLazyLoad.load({
					serie: true,
					files: [
						   'ngapp/student/controllers/applyOnlineCtrl.js',
						   'ngapp/student/services/applyOnlineService.js'
						  ]
				});
			}]
		}
	})

	.state("student.application.program",{
		url: "/applyonline/pcid/:programCategoryId",
		templateUrl: 'ngapp/student/views/userapplication/programView.html',
		controller:"ProgramCtrl as vm",

		ncyBreadcrumb: {
			label: 'Program',
		},
		params: { subtitle: 'Program' },
		resolve: {
			loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
				return $ocLazyLoad.load({
					serie: true,
					files: [
						   'ngapp/student/controllers/programCtrl.js',
						   /*'ngapp/student/services/programService.js',*/
						   'ngapp/student/services/applyOnlineService.js'
						  ]
				});
			}]
		}
	})
	
	.state("student.application.allowedQualifications",{
		url: "/allowedqualifications/:collegeProgramId",
		templateUrl: 'ngapp/student/views/userapplication/allowedQualificationsView.html',
		controller:"AllowedQualificationsCtrl as vm",

		ncyBreadcrumb: {
			label: 'Educational View',
		},
		params: { subtitle: 'Educational View' },
		resolve: {
			loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
				return $ocLazyLoad.load({
					serie: true,
					files: [
						   'ngapp/student/controllers/allowedQualificationsCtrl.js',
						   'ngapp/student/services/applyOnlineService.js'
						  ]
				});
			}]
		}
	})

	.state("student.application.subject",{
		url: "/applyonline/pid/:collegeProgramId/:selectedAllowedQualification",
		templateUrl:
				function (stateParams){
					var fileToAccess = ""
					if(stateParams.fileNameForProgram == "course" || stateParams.fileNameForProgram == "") {
						fileToAccess = "course";
					} else {
						fileToAccess = "universities/" + stateParams.universityFolderName + "/" + stateParams.fileNameForProgram;
					}
					return 'ngapp/student/views/userapplication/' + fileToAccess + "View.html";
				},
		controller:"SubjectCtrl as vm",

		params: {
			programName: {value: ""},
			programCode: {value: ""},
			universityFolderName: {value: ""},
			fileNameForProgram: {value: "course"},
			subtitle: 'Subject'
		},

		ncyBreadcrumb: {
			label: 'Subject',
		},

		resolve: {
			loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
				return $ocLazyLoad.load({
					serie: true,
					files: [
						   'ngapp/student/controllers/courseCtrl.js',
						   'ngapp/student/services/applyOnlineService.js',
						  ]
				});
			}]
		}

	})

	.state("student.application.applicationStatus",{
		url: "/applicationstatus",
		templateUrl: 'ngapp/student/views/userapplication/applicationStatusView.html',
		controller:"ApplicationStatusCtrl as vm",

		ncyBreadcrumb: {
			label: 'Application Status',
		},
		params: { subtitle: 'Application Status' },
		resolve: {
			loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
				return $ocLazyLoad.load({
					serie: true,
					files: [
						   'ngapp/student/controllers/applicationStatusCtrl.js',
						   'ngapp/student/services/applyOnlineService.js',
						  ]
				});
			}]
		}
	})
	
	.state("student.application.payApplicationFee",{
		url: "/payapplicationfee/:collegeProgramMapId/:applicationId",
		templateUrl: 'ngapp/student/views/userapplication/applicationFee.html',
		controller:"ApplicationFeeCtrl as vm",

		ncyBreadcrumb: {
			label: 'Application Fee Payment',
		},
		params: { subtitle: 'Application Fee' },
		resolve: {
			loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
				return $ocLazyLoad.load({
					serie: true,
					files: [
						   'ngapp/student/controllers/applicationFeeCtrl.js',
						   'ngapp/student/services/applicationConfirmationService.js',
						  ]
				});
			}]
		}
	})
	
	.state("student.application.printApplication",{
		url: "/printapplication/:collegeProgramMapId/:applicationId",
		templateUrl: 'ngapp/student/views/userapplication/printApplicationView.html',
		controller:"PrintApplicationCtrl as vm",

		ncyBreadcrumb: {
			label: 'Print Application',
		},
		params: { subtitle: 'Print Application' },
		resolve: {
			loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
				return $ocLazyLoad.load({
					serie: true,
					files: [
						   'ngapp/student/controllers/printApplicationCtrl.js',
						   'ngapp/student/services/applicationConfirmationService.js',
						  ]
				});
			}]
		}
	})
	
	/*START - Student profile view states*/
	.state('student.profileview', {
		url: '/profileview',
		abstract: true,
		ncyBreadcrumb: {
			label: 'Profile View',
		},
		params: { subtitle: 'Welcome to home' },
	})
	
	.state('student.profileview.profileDetail', {
		url: '/profiledetail',
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
	.state('student.profileview.educationalDetail', {
		url: '/educationaldetail',
		templateUrl: userBasePath + 'ngapp/studentview/views/educationalView.html',
		controller:"EducationalViewCtrl as vm",
		ncyBreadcrumb: {
			label: 'Educational Detail',
		},
		params: { 
			subtitle: 'Educational Detail',
			baseState: 'student.profileview'
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
	.state('student.profileview.qualificationDetail', {
		url: '/educationaldetail/:qualification/:qualificationGroup/:qualificationId',
		templateUrl:
		function (stateParams){
			if(stateParams.qualificationGroup == 1
					/*&& stateParams.qualification == "ssc"*/) {
				return userBasePath + "ngapp/studentview/views/qualificationDetailView/sscView.html"
			} else if((stateParams.qualificationGroup >= 2 && stateParams.qualificationGroup <= 3)
					/*&& stateParams.qualification == "hsc"*/) {
				return userBasePath + "ngapp/studentview/views/qualificationDetailView/hscView.html"
			} else if(stateParams.qualificationGroup == 4
					/*&& stateParams.qualification == "diploma"*/) {
				return userBasePath + "ngapp/studentview/views/qualificationDetailView/diplomaView.html"
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

/*Function StudentState END*/

}());
