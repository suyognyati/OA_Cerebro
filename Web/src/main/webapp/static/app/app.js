(function(){
	"use strict";
	var app = angular
		.module("admission", ["common.services",
		                      "ui.router",
		                      "oc.lazyLoad",
		                      "ui.bootstrap"]);
		
	app.config(["$stateProvider",
	            "$urlRouterProvider",
		         function($stateProvider, $urlRouterProvider){
					$urlRouterProvider.otherwise("/basicdetails");
					
					$stateProvider
					
					.state("basicDetail",{
							url: "/basicdetails",
							views: {
								"view":{
				                	templateUrl:"static/templates/states/basicDetailView.html",
				                	controller:"BasicDetailCtrl as vm",
								}
							},
							resolve: {
								basicDetail : ['$ocLazyLoad', function($ocLazyLoad){
									return $ocLazyLoad.load({
										name : 'admission',
										files : [
										     'static/app/controllers/basicDetailCtrl.js',
										     'static/common/services/basicDetailResource.js'
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
									templateUrl:"static/templates/states/personalDetailView.html",
									controller:"PersonalDetailCtrl as vm",
								}
							},
							resolve: {
								personalDetail : ['$ocLazyLoad', function($ocLazyLoad){
									return $ocLazyLoad.load({
										name : 'admission',
										files : [
										     'static/app/controllers/personalDetailCtrl.js'
										]
								
									})
								}]
							}
					})
					
					.state("educationInformation",{
							url: "/educationinformation",
							views: {
								"view":{
									templateUrl:"static/templates/states/educationInformationView.html",
									controller:"EducationInformationCtrl as vm",
								}
							},
							resolve: {
								basicDetail : ['$ocLazyLoad', function($ocLazyLoad){
									return $ocLazyLoad.load({
										name : 'admission',
										files : [
										     'static/app/controllers/educationInformationCtrl.js'
										]
								
									})
								}]
							}
					})
					
					.state("familyInformation",{
							url: "/familyinformation",
							views: {
								"view":{
									templateUrl:"static/templates/states/familyInformationView.html",
									controller:"FamilyInformationCtrl as vm",
								}
							},
							resolve: {
								basicDetail : ['$ocLazyLoad', function($ocLazyLoad){
									return $ocLazyLoad.load({
										name : 'admission',
										files : [
										     'static/app/controllers/familyInformationCtrl.js'
										]
								
									})
								}]
							}
					})
					
					.state("otherInformation",{
							url: "/otherinformation",
							views: {
								"view":{
									templateUrl:"static/templates/states/otherInformationView.html",
									controller:"OtherInformationCtrl as vm",
								}
							},
							resolve: {
								basicDetail : ['$ocLazyLoad', function($ocLazyLoad){
									return $ocLazyLoad.load({
										name : 'admission',
										files : [
										     'static/app/controllers/otherInformationCtrl.js'
										]
								
									})
								}]
							}
					})
					
			}]
		);
	
}());