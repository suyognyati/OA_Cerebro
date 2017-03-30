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
		
				    $urlRouterProvider.otherwise("/existingEntry");
					
					$stateProvider
					
					.state("existingEntry",{
						url: "/existingEntry",
						views: {
							"view":{
			                	templateUrl: basePath + "templates/states/existingUserView.html",
			                	controller:"ExistingUserCtrl as vm",
							}
						},
						resolve: {
							userDetail : ['$ocLazyLoad', function($ocLazyLoad){
								return $ocLazyLoad.load({
									name : 'vendor',
									files : [
									     basePath + 'app/controllers/existingUserCtrl.js',
									     basePath + 'app/services/existingUserService.js'
									]
							
								})
							}]
						}
					})
					
					.state("userDetail",{
							url: "/userdetails",
							views: {
								"view":{
				                	templateUrl: basePath + "templates/states/userDetailView.html",
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
					
					.state("personalDetail",{
							url: "/personaldetails",
							views: {
								"view":{
									templateUrl: basePath + "templates/states/personalDetailView.html",
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
					
					.state("address",{
							url: "/address",
							views: {
								"view":{
									templateUrl: basePath + "templates/states/addressView.html",
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
					
					.state("educationInformation",{
							url: "/educationinformation",
							views: {
								"view":{
									templateUrl: basePath + "templates/states/educationInformationView.html",
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
					
					.state("qualificationDetail",{
							url: "/educationinformation/:qualification?:qualificationMainLevel",
							views: {
								"view":{
									templateUrl: 
									function (stateParams){
										if(stateParams.qualificationMainLevel == 1
												/*&& stateParams.qualification == "ssc"*/) {
											return basePath + "templates/states/sscView.html"
										} else if((stateParams.qualificationMainLevel >= 2 && stateParams.qualificationMainLevel <= 3) 
												/*&& stateParams.qualification == "hsc"*/) {
											return basePath + "templates/states/hscView.html"
										} else if(stateParams.qualificationMainLevel == 4 
												/*&& stateParams.qualification == "diploma"*/) {
											return basePath + "templates/states/diplomaView.html"
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
					
					.state("occupationReservation",{
							url: "/occupationreservation",
							views: {
								"view":{
									templateUrl: basePath + "templates/states/occupationReservationView.html",
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
			}]
		);
	
}());