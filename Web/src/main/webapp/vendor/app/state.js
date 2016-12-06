(function(){
	"use strict";
	var app = angular.module("vendor");
	
	app.config(["$stateProvider",
	            "$urlRouterProvider",
	            "$httpProvider",
	            "globalConstants",
	            "vendorConstants",
		         function($stateProvider, $urlRouterProvider, $httpProvider, globalConstants, vendorConstants){
		
					var basePath = "";
					basePath = globalConstants.rootLocation + vendorConstants.vendorLocation;
		
				    $urlRouterProvider.otherwise("/vendorHome");
					
					$stateProvider
					
					.state("vendorHome",{
							url: "/vendorHome",
							views: {
								"view":{
				                	templateUrl: basePath + "templates/states/vendorHomeView.html",
				                	controller:"VendorHomeCtrl as vm",
								}
							},
							resolve: {
								userDetail : ['$ocLazyLoad', function($ocLazyLoad){
									return $ocLazyLoad.load({
										name : 'vendor',
										files : [
										     basePath + 'app/controllers/vendorHomeCtrl.js'
										]
								
									})
								}]
							}
					})					
			}]
		);
	
}());