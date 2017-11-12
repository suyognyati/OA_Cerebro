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
					
					var userProfileTemplatesFolderPath = "app/templates/studentprofile/";
					var userApplicationTemplatesFolderPath = "app/templates/userapplication/";
					var userControllersFolderPath = "app/controllers/";
					var userServicesFolderPath = "app/services/";
		
				    //$urlRouterProvider.otherwise("/studentstatus/personaldetails");
					
					$stateProvider
					
					.state("studentStatus",{
						url: "/studentstatus",
						views: {
							"mainview":{
			                	templateUrl: basePath + userProfileTemplatesFolderPath + "studentStatusView.html",
			                	controller:"StudentStatusCtrl as vm",
							}
						},
						resolve: {
							userDetail : ['$ocLazyLoad', function($ocLazyLoad){
								return $ocLazyLoad.load({
									name : 'admission',
									files : [
									     basePath + userControllersFolderPath + 'studentStatusCtrl.js'
									]
							
								})
							}]
						}
					})
					
					.state("application",{
						url: "/application",
						views: {
							"mainview":{
			                	templateUrl: basePath + userApplicationTemplatesFolderPath + "applicationView.html",
			                	controller:"ApplicationCtrl as vm",
							}
						},
						resolve: {
							userDetail : ['$ocLazyLoad', function($ocLazyLoad){
								return $ocLazyLoad.load({
									name : 'admission',
									files : [
									     basePath + userControllersFolderPath + 'applicationCtrl.js'
									]
							
								})
							}]
						}
					})
					
					.state("application.applyOnline",{
						url: "/applyOnline",
						views: {
							"view":{
								templateUrl: basePath + userApplicationTemplatesFolderPath + "applyOnlineView.html",
								controller:"ApplyOnlineCtrl as vm",
							}
						},
						resolve: {
							basicDetail : ['$ocLazyLoad', function($ocLazyLoad){
								return $ocLazyLoad.load({
									name : 'admission',
									files : [
									     basePath + userControllersFolderPath + 'applyOnlineCtrl.js',
									     basePath + userServicesFolderPath + 'applyOnlineService.js'
									]
							
								})
							}]
						}
					})
					
					.state("application.program",{
						url: "/applyOnline/pcid/:programCategoryId",
						views: {
							"view":{
								templateUrl: basePath + userApplicationTemplatesFolderPath + "programView.html",
								controller:"ProgramCtrl as vm",
							}
						},
						resolve: {
							basicDetail : ['$ocLazyLoad', function($ocLazyLoad){
								return $ocLazyLoad.load({
									name : 'admission',
									files : [
									     basePath + userControllersFolderPath + 'programCtrl.js',
									     basePath + userServicesFolderPath + 'programService.js'
									]
							
								})
							}]
						}
						
					})
					
					.state("application.subject",{
						url: "/applyOnline/pid/:programId",
						views: {
							"view":{
								templateUrl: basePath + userApplicationTemplatesFolderPath + "course.artsView.html",
								controller:"SubjectCtrl as vm",
							}
						},
						params: {
							programName: {value: ""},
							programCode: {value: ""}
						},
						resolve: {
							basicDetail : ['$ocLazyLoad', function($ocLazyLoad){
								return $ocLazyLoad.load({
									name : 'admission',
									files : [
									     basePath + userControllersFolderPath + 'course.artsCtrl.js',
									     basePath + userServicesFolderPath + 'course.artsService.js'
									]
							
								})
							}]
						}
						
					})
					
					.state("application.applicationStatus",{
						url: "/applicationstatus",
						views: {
							"view":{
			                	templateUrl: basePath + userApplicationTemplatesFolderPath + "applyOnlineView.html",
			                	//controller:"applicationCtrl as vm",
							}
						},
						/*resolve: {
							userDetail : ['$ocLazyLoad', function($ocLazyLoad){
								return $ocLazyLoad.load({
									name : 'admission',
									files : [
									     basePath + userControllersFolderPath + 'applicationCtrl.js'
									]
							
								})
							}]
						}*/
					})
					
					.state("studentStatus.userDetail",{
							url: "/userdetails",
							views: {
								"view":{
				                	templateUrl: basePath + userProfileTemplatesFolderPath + "userDetailView.html",
				                	controller:"UserDetailCtrl as vm",
								}
							},
							resolve: {
								userDetail : ['$ocLazyLoad', function($ocLazyLoad){
									return $ocLazyLoad.load({
										name : 'admission',
										files : [
										     basePath + userControllersFolderPath + 'userDetailCtrl.js',
										     basePath + userServicesFolderPath + 'userDetailService.js'
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
									templateUrl: basePath + userProfileTemplatesFolderPath + "personalDetailView.html",
									controller:"PersonalDetailCtrl as vm",
								}
							},
							resolve: {
								personalDetail : ['$ocLazyLoad', function($ocLazyLoad){
									return $ocLazyLoad.load({
										name : 'admission',
										files : [
										     basePath + userControllersFolderPath + 'personalDetailCtrl.js',
										     basePath + userServicesFolderPath + 'personalDetailService.js'
										]
								
									})
								}]
							}
					})
					
					.state("studentStatus.address",{
							url: "/address",
							views: {
								"view":{
									templateUrl: basePath + userProfileTemplatesFolderPath + "addressView.html",
									controller:"AddressCtrl as vm",
								}
							},
							resolve: {
								address : ['$ocLazyLoad', function($ocLazyLoad){
									return $ocLazyLoad.load({
										name : 'admission',
										files : [
										     basePath + userControllersFolderPath + 'addressCtrl.js',
										     basePath + userServicesFolderPath + 'addressService.js'
										]
								
									})
								}]
							}
					})
					
					.state("studentStatus.educationInformation",{
							url: "/educationinformation",
							views: {
								"view":{
									templateUrl: basePath + userProfileTemplatesFolderPath + "educationInformationView.html",
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
										     basePath + userControllersFolderPath + 'educationInformationCtrl.js',
										     basePath + userServicesFolderPath + 'educationInformationService.js'
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
											return basePath + userProfileTemplatesFolderPath + "sscView.html"
										} else if((stateParams.qualificationMainLevel >= 2 && stateParams.qualificationMainLevel <= 3) 
												/*&& stateParams.qualification == "hsc"*/) {
											return basePath + userProfileTemplatesFolderPath + "hscView.html"
										} else if(stateParams.qualificationMainLevel == 4 
												/*&& stateParams.qualification == "diploma"*/) {
											return basePath + userProfileTemplatesFolderPath + "diplomaView.html"
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
										       basePath + userControllersFolderPath + 'qualificationDetailCtrl.js',
										       basePath + userServicesFolderPath + 'qualificationDetailService.js'
										]
								
									})
								}]
							}
					})
					
					.state("studentStatus.occupationReservation",{
							url: "/occupationreservation",
							views: {
								"view":{
									templateUrl: basePath + userProfileTemplatesFolderPath + "occupationReservationView.html",
									controller:"OccupationReservationCtrl as vm",
								}
							},
							resolve: {
								basicDetail : ['$ocLazyLoad', function($ocLazyLoad){
									return $ocLazyLoad.load({
										name : 'admission',
										files : [
										     basePath + userControllersFolderPath + 'occupationReservationCtrl.js',
										     basePath + userServicesFolderPath + 'occupationReservationService.js'
										]
								
									})
								}]
							}
					})
					.state("studentStatus.uploadPhotoSign",{
						url: "/uploadphotosign",
						views: {
							"view":{
								templateUrl: basePath + userProfileTemplatesFolderPath + "uploadPhotoSignView.html",
								controller:"UploadPhotoSignCtrl as vm",
							}
						},
						resolve: {
							basicDetail : ['$ocLazyLoad', function($ocLazyLoad){
								return $ocLazyLoad.load({
									name : 'admission',
									files : [
									     basePath + userControllersFolderPath + 'uploadPhotoSignCtrl.js',
									     basePath + userServicesFolderPath + 'uploadPhotoSignService.js'
									]
							
								})
							}]
						}
					})
					.state("studentStatus.uploadDocuments",{
						url: "/uploadDocuments",
						views: {
							"view":{
								templateUrl: basePath + userProfileTemplatesFolderPath + "uploadDocumentsView.html",
								controller:"UploadDocumentsCtrl as vm",
							}
						},
						resolve: {
							basicDetail : ['$ocLazyLoad', function($ocLazyLoad){
								return $ocLazyLoad.load({
									name : 'admission',
									files : [
									     basePath + userControllersFolderPath + 'uploadDocumentsCtrl.js',
									     basePath + userServicesFolderPath + 'uploadDocumentsService.js'
									]
							
								})
							}]
						}
					})
					
					
			}]
		);
	
}());