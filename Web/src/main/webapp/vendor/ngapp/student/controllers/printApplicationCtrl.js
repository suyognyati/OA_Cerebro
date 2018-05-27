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
		
		var userId = 1;

		vm.accessToken = $window.bearer_token;
		vm.accessTokenParam = "?access_token=" + vm.accessToken;
		
		vm.getPrintDetail = function() {
			applicationConfirmationService.getPrintApplicationDetail()
			.then(function(success) {
				vm.printDetail = success.data;
			}, function(error) {
				vm.printDetail = {};
			})
		}
		
		applicationConfirmationService.setApplicant(userId)
		.then(function(success) {
			applicationConfirmationService.getListofQualification(vm.accessTokenParam)
			.then(function(success) {
				vm.qualificationList = success.data;
			}, function(error) {
				vm.qualificationList = error.data;
			})
		}, function(error) {
			vm.qualificationList = {};
		})
		
		setTimeout(function() {
		    vm.getPrintDetail();
		}, $scope.getDataDelay);
	};
}());
