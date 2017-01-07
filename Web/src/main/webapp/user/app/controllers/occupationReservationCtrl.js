(function(){
	"use strict";
	angular
		.module("user")
		.controller("OccupationReservationCtrl",
					["$http",
					 "$window",
					 "OccupationReservationService",
					 UserDetailCtrl]);
	
	function UserDetailCtrl($http, $window, OccupationReservationService) {
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
			})
			.error(function(data, status, header, config) {
				vm.successMessage = "Error while saving data";
			});
		}
	};
}());