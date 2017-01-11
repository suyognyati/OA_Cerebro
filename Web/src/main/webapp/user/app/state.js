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
		
				    $urlRouterProvider.otherwise("/personaldetails");
					
					$stateProvider
					
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
										     basePath + 'common/services/userDetailService.js'
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
										     basePath + 'common/services/personalDetailService.js'
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
							resolve: {
								basicDetail : ['$ocLazyLoad', function($ocLazyLoad){
									return $ocLazyLoad.load({
										name : 'admission',
										files : [
										     basePath + 'app/controllers/educationInformationCtrl.js'
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
					
					.state("familyInformation",{
							url: "/familyinformation",
							views: {
								"view":{
									templateUrl: basePath + "templates/states/familyInformationView.html",
									controller:"FamilyInformationCtrl as vm",
								}
							},
							resolve: {
								basicDetail : ['$ocLazyLoad', function($ocLazyLoad){
									return $ocLazyLoad.load({
										name : 'admission',
										files : [
										       basePath + 'app/controllers/familyInformationCtrl.js'
										]
								
									})
								}]
							}
					})
					
					.state("otherInformation",{
							url: "/otherinformation",
							views: {
								"view":{
									templateUrl: basePath + "templates/states/otherInformationView.html",
									controller:"OtherInformationCtrl as vm",
								}
							},
							resolve: {
								basicDetail : ['$ocLazyLoad', function($ocLazyLoad){
									return $ocLazyLoad.load({
										name : 'admission',
										files : [
										       basePath + 'app/controllers/otherInformationCtrl.js'
										]
								
									})
								}]
							}
					})
			}]
		);
	
}());