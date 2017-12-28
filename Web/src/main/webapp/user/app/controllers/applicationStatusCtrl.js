(function(){
	"use strict";
	angular
		.module("user")
		.controller("ApplicationStatusCtrl",
					["$http",
					 "$window",
					 "applicationStatusService",
					 ApplicationStatusCtrl]);
	
	function ApplicationStatusCtrl($http, $window, applicationStatusService) {
		var vm = this;
		
		vm.accessToken = $window.bearer_token;
		vm.accessTokenParam = "?access_token=" + vm.accessToken;
		
		vm.init = function() {
			applicationStatusService.get(vm.accessTokenParam)
			.success(function(data){
				vm.appliedCourses = data;
			});
		}
		
		vm.init();
	};
}());