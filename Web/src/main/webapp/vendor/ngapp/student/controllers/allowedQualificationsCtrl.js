(function(){
	"use strict";
	angular
		.module("app")
		.controller("AllowedQualificationsCtrl",
					["$http",
					 "$window",
					 "$state",
					 "$scope",
					 "applyOnlineService",
					 AllowedQualificationsCtrl]);

	function AllowedQualificationsCtrl($http, $window, $state, $scope, applyOnlineService) {

		var userId = 1;
		var vm = this;
		vm.qualificationList = [];
		
		vm.collegeProgramId = $state.params.collegeProgramId;

		vm.accessTokenParam = $scope.getAccessTokenParam();
		
		vm.selectedAllowedQualification = 0;

		vm.getAllowedQualifications = function() {
			applyOnlineService.getAllowedQualifications(vm.collegeProgramId, vm.accessTokenParam)
			.then(function(success) {
				vm.qualificationList = success.data;
			}, function(error) {
				vm.qualificationList = error.data;
			})
		}
		
		vm.submit = function() {
			$state.go("student.application.subject", {collegeProgramId:vm.collegeProgramId});
		}

		setTimeout(function() {
		    vm.getAllowedQualifications();
		}, $scope.getDataDelay);
	};

}());
