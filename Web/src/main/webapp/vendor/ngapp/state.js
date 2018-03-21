angular
.module('app')
.config(['$stateProvider', '$urlRouterProvider', '$ocLazyLoadProvider', '$breadcrumbProvider', function($stateProvider, $urlRouterProvider, $ocLazyLoadProvider, $breadcrumbProvider) {

	var contextPath = "/Web";
	var rootPath = "/static/"
	var basePath = contextPath + rootPath;
     $urlRouterProvider.otherwise('/home/dashboard');

     $ocLazyLoadProvider.config({
          // Set to true if you want to see what and when is dynamically loaded
          debug: true
     });

     $breadcrumbProvider.setOptions({
          prefixStateName: 'home.dashboard',
          includeAbstract: true,
          template: '<li class="breadcrumb-item" ng-repeat="step in steps" ng-class="{active: $last}" ng-switch="$last || !!step.abstract"><a ng-switch-when="false" href="{{step.ncyBreadcrumbLink}}">{{step.ncyBreadcrumbLabel}}</a><span ng-switch-when="true">{{step.ncyBreadcrumbLabel}}</span></li>'
     });

	$stateProvider
	/**
	* States for Home
	* */
	.state('home', {
		url: '/home',
		abstract: true,
		templateUrl: 'ngapp/home/views/common/layouts/home.html',
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

	/**
	* Base state for Student Login
	*/
	.state('studentsimple', {
		url: '/student',
		abstract: true,
		templateUrl: 'ngapp/student/views/common/layouts/studentsimple.html',
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
	
	/**
	* Base state for Student
	*/
	.state('student', {
		url: '/student',
		abstract: true,
		templateUrl: 'ngapp/student/views/common/layouts/student.html',
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
