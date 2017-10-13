(function(){
	"use strict";
	var app = angular.module("user");
	
	app.config(["$stateProvider",
	            "$urlRouterProvider",
	            "$httpProvider",
	            "globalConstants",
	            "userConstants",
		         function($stateProvider, $urlRouterProvider, $httpProvider, globalConstants, userConstants){
		
					var basePath = "";
					basePath = globalConstants.rootLocation + userConstants.userLocation;
					
					var userProfileFolderPath = "templates/states/studentprofile/";
					var userApplicationFolderPath = "templates/states/userapplication/";
		
				    //$urlRouterProvider.otherwise("/studentstatus/personaldetails");
					
					$stateProvider
					
					.state("studentStatus",{
						url: "/studentstatus",
						views: {
							"mainview":{
			                	templateUrl: basePath + userProfileFolderPath + "studentStatusView.html",
			                	controller:"StudentStatusCtrl as vm",
							}
						},
						resolve: {
							userDetail : ['$ocLazyLoad', function($ocLazyLoad){
								return $ocLazyLoad.load({
									name : 'admission',
									files : [
									     basePath + 'app/controllers/studentStatusCtrl.js'
									]
							
								})
							}]
						}
					})
					
					.state("application",{
						url: "/application",
						views: {
							"mainview":{
			                	templateUrl: basePath + userApplicationFolderPath + "applicationView.html",
			                	controller:"ApplicationCtrl as vm",
							}
						},
						resolve: {
							userDetail : ['$ocLazyLoad', function($ocLazyLoad){
								return $ocLazyLoad.load({
									name : 'admission',
									files : [
									     basePath + 'app/controllers/applicationCtrl.js'
									]
							
								})
							}]
						}
					})
					
					.state("application.applyOnline",{
						url: "/applyOnline",
						views: {
							"view":{
								templateUrl: basePath + userApplicationFolderPath + "applyOnlineView.html",
								controller:"ApplyOnlineCtrl as vm",
							}
						},
						resolve: {
							basicDetail : ['$ocLazyLoad', function($ocLazyLoad){
								return $ocLazyLoad.load({
									name : 'admission',
									files : [
									     basePath + 'app/controllers/applyOnlineCtrl.js',
									]
							
								})
							}]
						}
					})
					
					.state("application.bachelorCourses",{
						url: "/bachelorCourses",
						views: {
							"view":{
								templateUrl: basePath + userApplicationFolderPath + "bachelorCoursesView.html",
								controller:"BachelorCoursesCtrl as vm",
							}
						},
						resolve: {
							basicDetail : ['$ocLazyLoad', function($ocLazyLoad){
								return $ocLazyLoad.load({
									name : 'admission',
									files : [
									     basePath + 'app/controllers/bachelorCoursesCtrl.js',
									     basePath + 'app/services/bachelorCoursesService.js'
									]
							
								})
							}]
						}
						
					})
					
					.state("application.subject",{
						url: "/subject",
						views: {
							"view":{
								templateUrl: basePath + userApplicationFolderPath + "subjectView.html",
								/*controller:"SubjectCtrl as vm",*/
							}
						},
						/*resolve: {
							basicDetail : ['$ocLazyLoad', function($ocLazyLoad){
								return $ocLazyLoad.load({
									name : 'admission',
									files : [
									     basePath + 'app/controllers/subjectCtrl.js',
									     basePath + 'app/services/subjectService.js'
									]
							
								})
							}]
						}*/
						
					})
					
					.state("application.applicationStatus",{
						url: "/applicationstatus",
						views: {
							"view":{
			                	templateUrl: basePath + userApplicationFolderPath + "applyOnlineView.html",
			                	//controller:"applicationCtrl as vm",
							}
						},
						/*resolve: {
							userDetail : ['$ocLazyLoad', function($ocLazyLoad){
								return $ocLazyLoad.load({
									name : 'admission',
									files : [
									     basePath + 'app/controllers/applicationCtrl.js'
									]
							
								})
							}]
						}*/
					})
					
					.state("studentStatus.userDetail",{
							url: "/userdetails",
							views: {
								"view":{
				                	templateUrl: basePath + userProfileFolderPath + "userDetailView.html",
				                	controller:"UserDetailCtrl as vm",
								}
							},
							resolve: {
								userDetail : ['$ocLazyLoad', function($ocLazyLoad){
									return $ocLazyLoad.load({
										name : 'admission',
										files : [
										     basePath + 'app/controllers/userDetailCtrl.js',
										     basePath + 'app/services/userDetailService.js'
										]
								
									})
								}]
							}
					})
					
					/*.state("basicDetail",{
							url: "/basicdetails",
							templateUrl:"static/templates/states/basicDetailView.html",
							controller:"BasicDetailCtrl as vm",
							resolve: {
								basicDetail : ['$ocLazyLoad', function($ocLazyLoad){
									return $ocLazyLoad.load({
										name : 'admission',
										files : [
										     'static/app/controllers/basicDetailCtrl.js'
										]
								
									})
								}]
							}
					})*/
					
					.state("studentStatus.personalDetail",{
							url: "/personaldetails",
							views: {
								"view":{
									templateUrl: basePath + userProfileFolderPath + "personalDetailView.html",
									controller:"PersonalDetailCtrl as vm",
								}
							},
							resolve: {
								personalDetail : ['$ocLazyLoad', function($ocLazyLoad){
									return $ocLazyLoad.load({
										name : 'admission',
										files : [
										     basePath + 'app/controllers/personalDetailCtrl.js',
										     basePath + 'app/services/personalDetailService.js'
										]
								
									})
								}]
							}
					})
					
					.state("studentStatus.address",{
							url: "/address",
							views: {
								"view":{
									templateUrl: basePath + userProfileFolderPath + "addressView.html",
									controller:"AddressCtrl as vm",
								}
							},
							resolve: {
								address : ['$ocLazyLoad', function($ocLazyLoad){
									return $ocLazyLoad.load({
										name : 'admission',
										files : [
										     basePath + 'app/controllers/addressCtrl.js',
										     basePath + 'app/services/addressService.js'
										]
								
									})
								}]
							}
					})
					
					.state("studentStatus.educationInformation",{
							url: "/educationinformation",
							views: {
								"view":{
									templateUrl: basePath + userProfileFolderPath + "educationInformationView.html",
									controller:"EducationInformationCtrl as vm",
								}
							},
							params: {
								success: {value: null}
							},
							resolve: {
								basicDetail : ['$ocLazyLoad', function($ocLazyLoad){
									return $ocLazyLoad.load({
										name : 'admission',
										files : [
										     basePath + 'app/controllers/educationInformationCtrl.js',
										     basePath + 'app/services/educationInformationService.js'
										]
								
									})
								}]
							}
					})
					
					.state("studentStatus.qualificationDetail",{
							url: "/educationinformation/:qualification?:qualificationMainLevel",
							views: {
								"view":{
									templateUrl: 
									function (stateParams){
										if(stateParams.qualificationMainLevel == 1
												/*&& stateParams.qualification == "ssc"*/) {
											return basePath + userProfileFolderPath + "sscView.html"
										} else if((stateParams.qualificationMainLevel >= 2 && stateParams.qualificationMainLevel <= 3) 
												/*&& stateParams.qualification == "hsc"*/) {
											return basePath + userProfileFolderPath + "hscView.html"
										} else if(stateParams.qualificationMainLevel == 4 
												/*&& stateParams.qualification == "diploma"*/) {
											return basePath + userProfileFolderPath + "diplomaView.html"
										} else {
											return false;
										}
										
										//return basePath + "templates/states/" + stateParams.qualification + "View.html"
									},
									controller:"QualificationDetailCtrl as vm",
								}
							},
							params: {
								qualificationId : null,
							    newQualification : false
							},
							resolve: {
								basicDetail : ['$ocLazyLoad', function($ocLazyLoad){
									return $ocLazyLoad.load({
										name : 'admission',
										files : [
										       basePath + 'app/controllers/qualificationDetailCtrl.js',
										       basePath + 'app/services/qualificationDetailService.js'
										]
								
									})
								}]
							}
					})
					
					.state("studentStatus.occupationReservation",{
							url: "/occupationreservation",
							views: {
								"view":{
									templateUrl: basePath + userProfileFolderPath + "occupationReservationView.html",
									controller:"OccupationReservationCtrl as vm",
								}
							},
							resolve: {
								basicDetail : ['$ocLazyLoad', function($ocLazyLoad){
									return $ocLazyLoad.load({
										name : 'admission',
										files : [
										     basePath + 'app/controllers/occupationReservationCtrl.js',
										     basePath + 'app/services/occupationReservationService.js'
										]
								
									})
								}]
							}
					})
					.state("studentStatus.uploadPhotoSign",{
						url: "/uploadphotosign",
						views: {
							"view":{
								templateUrl: basePath + userProfileFolderPath + "uploadPhotoSignView.html",
								controller:"UploadPhotoSignCtrl as vm",
							}
						},
						resolve: {
							basicDetail : ['$ocLazyLoad', function($ocLazyLoad){
								return $ocLazyLoad.load({
									name : 'admission',
									files : [
									     basePath + 'app/controllers/uploadPhotoSignCtrl.js',
									     basePath + 'app/services/uploadPhotoSignService.js'
									]
							
								})
							}]
						}
					})
					.state("studentStatus.uploadDocuments",{
						url: "/uploadDocuments",
						views: {
							"view":{
								templateUrl: basePath + userProfileFolderPath + "uploadDocumentsView.html",
								controller:"UploadDocumentsCtrl as vm",
							}
						},
						resolve: {
							basicDetail : ['$ocLazyLoad', function($ocLazyLoad){
								return $ocLazyLoad.load({
									name : 'admission',
									files : [
									     basePath + 'app/controllers/uploadDocumentsCtrl.js',
									     basePath + 'app/services/uploadDocumentsService.js'
									]
							
								})
							}]
						}
					})
					
					
			}]
		);
	
}());