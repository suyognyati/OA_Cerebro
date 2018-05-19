(function(){
	"use strict";
	angular
		.module("app")
		.controller("ApplicationStatusCtrl",
					["$scope",
					 "$http",
					 "$window",
					 "$state",
					 "applyOnlineService",
					 ApplicationStatusCtrl]);

	function ApplicationStatusCtrl($scope, $http, $window, $state, applyOnlineService) {
		var vm = this;

		vm.accessTokenParam = $scope.getAccessTokenParam();
		
		vm.getApplicationStatus = function() {
			applyOnlineService.getAppliedCourses(vm.accessTokenParam)
			.then(function(success) {
				vm.appliedCourses = success.data;
			}, function(error) {
				vm.appliedCourses = {};
			})
		}
		
		vm.deleteApplication = function(applicationId) {
			var canDelete = confirm("Are you sure to delete application");
			if(canDelete == true) {
				applyOnlineService.deleteApplication(applicationId, vm.accessTokenParam)
				.then(function(success) {
					var count = 0;
					angular.forEach(vm.appliedCourses, function(value, key) {
						if(value.applicationId == applicationId) {
							vm.appliedCourses.splice(count, 1);
						}
						count++;
					});
				}, function(error) {
				})
			}
		}
		
		vm.printApplication = function() {
			$state.go("student.application.printApplication");
		}

		setTimeout(function() {
		    vm.getApplicationStatus();
		}, $scope.getDataDelay);
	};
}());
