(function(){
	"use strict";
	angular
		.module("app")
		.controller("ApplicationFeeCtrl",
					["$scope",
					 "$http",
					 "$window",
					 "$state",
					 "applicationConfirmationService",
					 ApplicationStatusCtrl]);

	function ApplicationStatusCtrl($scope, $http, $window, $state, applicationConfirmationService) {
		var vm = this;

		vm.accessTokenParam = $scope.getAccessTokenParam();
		
		vm.collegeProgramMapId = $state.params.collegeProgramMapId;
		vm.applicationId = $state.params.applicationId;
		
		vm.getFeeDetail = function() {
			applicationConfirmationService.getFeeDetail(vm.collegeProgramMapId, vm.applicationId, vm.accessTokenParam)
			.then(function(success) {
				vm.feeDetail = success.data;
			}, function(error) {
				vm.appliedCourses = {};
			})
		}
		
		vm.payAndSubmit = function() {
			applicationConfirmationService.payAndSubmit(vm.collegeProgramMapId, vm.applicationId, vm.accessTokenParam)
			.then(function(success) {
				vm.response = success.data;
				if(vm.response == false) {
					alert("Error while paying. Please try again");
				} else {
					$state.go("student.application.applicationStatus");
				}
			}, function(error) {
				vm.response = {};
			})
		}
		
		setTimeout(function() {
		    vm.getFeeDetail();
		}, $scope.getDataDelay);
	};
}());
