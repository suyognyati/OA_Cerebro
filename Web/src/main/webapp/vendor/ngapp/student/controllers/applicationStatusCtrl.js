(function(){
	"use strict";
	angular
		.module("app")
		.controller("ApplicationStatusCtrl",
					["$scope",
					 "$http",
					 "$window",
					 "applicationStatusService",
					 ApplicationStatusCtrl]);

	function ApplicationStatusCtrl($scope, $http, $window, applicationStatusService) {
		var vm = this;

		vm.accessTokenParam = $scope.getAccessTokenParam();
		
		vm.getApplicationStatus = function() {
			applicationStatusService.get(vm.accessTokenParam)
			.then(function(success) {
				vm.appliedCourses = success.data;
			})			
		}

		setTimeout(function() {
		    vm.getApplicationStatus();
		}, $scope.getDataDelay);
	};
}());
