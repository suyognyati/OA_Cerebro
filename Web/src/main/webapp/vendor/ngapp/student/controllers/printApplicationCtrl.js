(function(){
	"use strict";
	angular
		.module("app")
		.controller("PrintApplicationCtrl",
					["$scope",
					 "$http",
					 "$window",
					 "$state",
					 "applicationConfirmationService",
					 PrintApplicationCtrl]);

	function PrintApplicationCtrl($scope, $http, $window, $state, applicationConfirmationService) {
		var vm = this;
		
		vm.accessTokenParam = $scope.getAccessTokenParam();
		
		vm.collegeProgramMapId = $state.params.collegeProgramMapId;
		vm.applicationId = $state.params.applicationId;
		
		vm.getPrintDetail = function() {
			applicationConfirmationService.getPrintApplicationDetail(vm.collegeProgramMapId, vm.applicationId, vm.accessTokenParam)
			.then(function(success) {
				vm.printDetail = success.data;
			}, function(error) {
				vm.printDetail = {};
			})
		}
		
		vm.getQualificationDetail = function() {
			applicationConfirmationService.getListofQualification(vm.accessTokenParam)
			.then(function(success) {
				vm.qualificationList = success.data;
			}, function(error) {
				vm.qualificationList = error.data;
			})
		}
		
		setTimeout(function() {
		    vm.getPrintDetail();
		    vm.getQualificationDetail();
		}, $scope.getDataDelay);
	};
}());
