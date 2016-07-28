(function() {
	"use strict";
	var app = angular.module("productmanagement", [ "ui.router", 
	                                                "oc.lazyLoad", 
	                                                'ngRoute', 
	                                                'common.services']);

	app.config([ "$stateProvider", "$urlRouterProvider", '$routeProvider',
			function($stateProvider, $urlRouterProvider, $routeProvider) {
				$urlRouterProvider.otherwise("/")
				$stateProvider
				//welcome page
				.state("home", {
					url:"/",
					templateUrl:"static/views-angular/welcomeView.html"
				})
				//product list page
				.state("productList", {
					url : "/products",
					templateUrl : "static/views-angular/productListView.html",
					controller : "ProductListCtrl as vm",
					resolve: {
		                productList: ['$ocLazyLoad', function ($ocLazyLoad) {
		                    return $ocLazyLoad.load({
		                        name: 'productmanagement',
		                        files: [
		                            'static/app/controllers/productListCtrl.js',
		                            'static/common/services/productResource.js'
		                        ]
		                    })		                    
		                }]
		            }
				})
				//product edit page
				.state("productEdit", {
					url : "/productedit/:productId",
					templateUrl : "static/views-angular/editProductView.html",
					controller : "EditProductCtrl as vm",
					resolve: {
		                productList: ['$ocLazyLoad', function ($ocLazyLoad) {
		                    return $ocLazyLoad.load({
		                        name: 'productmanagement',
		                        files: [
		                            'static/app/controllers/editProductCtrl.js'
		                        ]
		                    })		                    
		                }]
		            }
				})
			} ]);

}());
