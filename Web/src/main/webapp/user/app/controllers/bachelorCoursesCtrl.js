(function(){
	"use strict";
	angular
		.module("user")
		.controller("BachelorCoursesCtrl",
					["$http",
					 "$state",
					 "$window",
					 "bachelorCoursesService",
					 BachelorCoursesCtrl]);
	
	function BachelorCoursesCtrl($http, $state, $window, bachelorCoursesService) {
		var vm = this;
		
		vm.accessToken = $window.bearer_token;
		vm.accessTokenParam = "?access_token=" + vm.accessToken;
		
		bachelorCoursesService.get(vm.accessTokenParam)
		.success(function(data, status, header, config) {
			vm.bachelorcourses = data;
		})
		.error(function(data, status, header, config) {
			vm.bachelorcourses = {};
		});

		
	};
}());