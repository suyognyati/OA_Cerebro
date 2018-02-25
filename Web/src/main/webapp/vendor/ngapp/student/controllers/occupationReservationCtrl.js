(function(){
	"use strict";
	angular
		.module("app")
		.controller("OccupationReservationCtrl",
					["$scope",
					 "$http",
					 "$state",
					 "$window",
					 "OccupationReservationService",
					 OccupationReservationCtrl]);

	function OccupationReservationCtrl($scope, $http, $state, $window, OccupationReservationService) {
		var vm = this;
		vm.occupationReservationTemp = {};

		vm.accessTokenParam = $scope.getAccessTokenParam();

		vm.loadData = function () {
			OccupationReservationService.get(vm.accessTokenParam)
			.then(function (success) {
				vm.occupationandreservation = success.data;
			}, function (error) {
				vm.occupationandreservation = {};
			})
			refreshSelectPickerWithDelay();
		}

		vm.submit = function() {
			OccupationReservationService.save(vm.occupationandreservation, vm.accessTokenParam)
			.then(function (success) {
				vm.successMessage = "Saved successfully";
				$state.go("student.profile.uploadPhotoSign");
			}, function (error) {
				vm.errorMessage = "Error while saving data";
			})

		}
		
		setTimeout(function() {
		    vm.loadData();
		}, $scope.getDataDelay);
	};
}());
