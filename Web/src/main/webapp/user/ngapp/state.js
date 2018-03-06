angular
.module('app')
.config(['$stateProvider', '$urlRouterProvider', '$ocLazyLoadProvider', '$breadcrumbProvider', function($stateProvider, $urlRouterProvider, $ocLazyLoadProvider, $breadcrumbProvider) {

	var contextPath = "/Web";
	var rootPath = "/static/"
	var basePath = contextPath + rootPath;
     $urlRouterProvider.otherwise('/studentview/dashboard');

     $ocLazyLoadProvider.config({
          // Set to true if you want to see what and when is dynamically loaded
          debug: true
     });

     $breadcrumbProvider.setOptions({
          prefixStateName: 'studentview.dashboard',
          includeAbstract: true,
          template: '<li class="breadcrumb-item" ng-repeat="step in steps" ng-class="{active: $last}" ng-switch="$last || !!step.abstract"><a ng-switch-when="false" href="{{step.ncyBreadcrumbLink}}">{{step.ncyBreadcrumbLabel}}</a><span ng-switch-when="true">{{step.ncyBreadcrumbLabel}}</span></li>'
     });

	$stateProvider
	/**
	* States for studentview
	* */
	.state('studentview', {
		url: '/studentview',
		abstract: true,
		templateUrl: 'ngapp/studentview/views/common/layouts/studentview.html',
		//page title goes here
		ncyBreadcrumb: {
			label: 'Root',
			skip: true
		},
		resolve: {
			loadCSS: ['$ocLazyLoad', function($ocLazyLoad) {
				// you can lazy load CSS files
				return $ocLazyLoad.load([{
					serie: true,
					name: 'Font Awesome',
					files: [basePath + 'node_modules/font-awesome/css/font-awesome.min.css']
				},{
					serie: true,
					name: 'Simple Line Icons',
					files: [basePath + 'node_modules/simple-line-icons/css/simple-line-icons.css']
				}]);
			}]
		}
	})
     
}]);
