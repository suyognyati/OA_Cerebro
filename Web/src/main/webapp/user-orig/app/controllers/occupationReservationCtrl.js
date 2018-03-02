(function(){
	"use strict";
	angular
		.module("user")
		.controller("OccupationReservationCtrl",
					["$http",
					 "$state",
					 "$window",
					 "OccupationReservationService",
					 OccupationReservationCtrl]);
	
	function OccupationReservationCtrl($http, $state, $window, OccupationReservationService) {
		var vm = this;
		vm.accessToken = $window.bearer_token;
		vm.accessTokenParam = "?access_token=" + vm.accessToken;
		
		OccupationReservationService.get(vm.accessTokenParam)
		.success(function(data, status, header, config) {
			vm.occupationandreservation = data;
		})
		.error(function(data, status, header, config) {
			vm.occupationandreservation = {};
		});

		vm.submit = function() {
			OccupationReservationService.save(vm.occupationandreservation, vm.accessTokenParam)
			.success(function(data, status, header, config) {
				vm.successMessage = "Saved successfully";
				$state.go("educationInformation");
			})
			.error(function(data, status, header, config) {
				vm.errorMessage = "Error while saving data";
			});
		}
	};
}());