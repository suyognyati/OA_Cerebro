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
		
		vm.getFeeDetail = function() {
			applicationConfirmationService.getFeeDetail(vm.collegeProgramMapId, vm.accessTokenParam)
			.then(function(success) {
				vm.feeDetail = success.data;
			}, function(error) {
				vm.appliedCourses = {};
			})
		}		
		
		setTimeout(function() {
		    vm.getFeeDetail();
		}, $scope.getDataDelay);
	};
}());
