(function(){
	"use strict";
	angular
		.module("app")
		.controller("ProgramSelectCtrl",
					["$http",
					 "$state",
					 "$scope",
					 "generateMeritListService",
					 ProgramSelectCtrl]);
	
	function ProgramSelectCtrl($http, $state, $scope, generateMeritListService) {
		var vm = this;
		
		/*vm.programCategoryId = $state.params.programCategoryId;*/
		
		vm.itemPerPage = 2;
		
		vm.getCategories = function() {
			generateMeritListService.get()
			.then(function(success) {
				vm.categories = success.data;
				vm.selectedCategoryId = null;
				//vm.getPrograms();
				refreshSelectPickerWithDelay(100);
			}, function(error) {
				vm.categories = {};
			})
		}
		
		vm.getPrograms = function() {
			generateMeritListService.getPrograms(vm.selectedCategoryId)
			.then(function(success) {
				vm.programs = success.data;
				vm.selectedProgramId = null;
				refreshSelectPickerWithDelay(100);
			}, function(error) {
				vm.programs = {};
			})
		}
		
		vm.getReservations = function () {
			generateMeritListService.get()
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
			vm.getCategories();
			
			//vm.getReservations();
		}, $scope.getDataDelay);
	};
}());