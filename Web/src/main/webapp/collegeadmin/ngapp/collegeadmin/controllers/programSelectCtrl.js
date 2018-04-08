(function(){
	"use strict";
	angular
		.module("app")
		.controller("ProgramSelectCtrl",
					["$http",
					 "$state",
					 "$scope",
					 "programSelectService",
					 ProgramSelectCtrl]);
	
	function ProgramSelectCtrl($http, $state, $scope, programSelectService) {
		var vm = this;
		
		vm.programCategoryId = $state.params.programCategoryId;
		
		vm.itemPerPage = 2;
		
		vm.getPrograms = function() {
			programSelectService.get(vm.programCategoryId)
			.then(function(success) {
				vm.programs = success.data;
				vm.selectedProgramId = null;
				refreshSelectPickerWithDelay(100);
			}, function(error) {
				vm.programs = {};
			})
		}
		
		vm.getReservations = function () {
			programSelectService.get()
			.then(function (success) {
				vm.reservations = success.data;
			}, function (error) {
				vm.reservations = {};
			})
			refreshSelectPickerWithDelay();
		}
		
		vm.generateMeritList = function(programId) {
			var selectedProgramId = vm.selectedProgramId;
			$state.go("collegeadmin.meritList",{programId:programId, programCategoryId:vm.programCategoryId});
		}
		
		setTimeout(function() {
			vm.getPrograms();
			//vm.getReservations();
		}, $scope.getDataDelay);
	};
}());