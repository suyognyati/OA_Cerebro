(function(){
	"use strict";
	angular
		.module("user")
		.controller("ApplyOnlineCtrl",
					["$state",
					 "$http",
					 "$window",
					 "applyOnlineService",
					 ApplyOnlineCtrl]);
	
	function ApplyOnlineCtrl($state, $http, $window, applyOnlineService) {
		var vm = this;
		
		vm.accessToken = $window.bearer_token;
		vm.accessTokenParam = "?access_token=" + vm.accessToken;
		
		vm.getCategories = function() {
			applyOnlineService.get(vm.accessTokenParam)
			.success(function (data, status, headers, config) {
				vm.categories = data;
			})
			.error(function (data, status, headers, config) {
				vm.categories = {};
	        });
		}
		
		vm.applyForGraduation = function(programCategoryId) {
			$state.go("application.bachelorCourses");
		}
		
		vm.getCategories();
	};
	
}());