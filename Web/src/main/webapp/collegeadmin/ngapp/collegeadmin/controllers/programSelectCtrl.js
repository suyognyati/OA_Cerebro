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
		vm.search = {};
		
		vm.labelForAllProgramCategories = "All";
		
		/*vm.programCategoryId = $state.params.programCategoryId;*/
		
		vm.itemPerPage = 2;
		
		vm.getProgramCategories = function() {
			generateMeritListService.get()
			.then(function(success) {
				vm.programCategories = success.data;
				vm.initProgramCategories(vm.programCategories);
				refreshSelectPickerWithDelay(100);
			}, function(error) {
				vm.programCategories = {};
			})
		}
		
		vm.getPrograms = function() {
			generateMeritListService.getAllPrograms()
			.then(function(success) {
				vm.programs = success.data;
			}, function(error) {
				vm.programs = {};
			})
		}
		
		vm.initProgramCategories = function(programCategories) {
			var allLevels = {};
			allLevels.programCategoryId = 0;
			allLevels.programCategoryName = vm.labelForAllProgramCategories;
			programCategories.splice(0, 0, allLevels);
			vm.selectedCategoryId = 0;
		}
		
		/*vm.getReservations = function () {
			generateMeritListService.get()
			.then(function (success) {
				vm.reservations = success.data;
			}, function (error) {
				vm.reservations = {};
			})
			refreshSelectPickerWithDelay();
		}*/
		
		vm.generateMeritList = function(programId, programLevelId) {
			var selectedProgramId = vm.selectedProgramId;
			$state.go("collegeadmin.meritList",{programId:programId, programLevelId:programLevelId});
		}
		
		vm.filterByProgramLevel = function() {
			if(vm.selectedCategoryId == 0)
				vm.search.programLevelId = "";
			else
				vm.search.programLevelId = vm.selectedCategoryId;
		}
		
		vm.setCategoryWeightage = function(programId) {
			$state.go("collegeadmin.setCategoryWeightage", {programId:programId})
		}
		
		setTimeout(function() {
			vm.getProgramCategories();
			vm.getPrograms();
		}, $scope.getDataDelay);
	};
}());