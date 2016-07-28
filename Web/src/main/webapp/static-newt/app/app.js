(function() {
	"use strict";
	var app = angular.module("eenroll", [ "ui.router",
			"oc.lazyLoad", "ui.bootstrap" ]);

	app.config([ "$stateProvider", "$urlRouterProvider",

		function($stateProvider, $urlRouterProvider) {
			$urlRouterProvider.otherwise("/basicdetails");
			$stateProvider
			//Basic Details
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
								     'static/app/controllers/basicDetailCtrl.js'
								]
						
							})
						}]
					}
			})
		}]
	);

}());