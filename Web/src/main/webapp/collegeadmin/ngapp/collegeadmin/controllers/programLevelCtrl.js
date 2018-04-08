(function(){
	"use strict";
	angular
		.module("app")
		.controller("ProgramLevelCtrl",
					["$http",
					 "$state",
					 "$scope",
					 "programLevelService",
					 ProgramLevelCtrl]);
	
	function ProgramLevelCtrl($http, $state, $scope, programLevelService) {
		var vm = this;
		
		vm.getCategories = function() {
			programLevelService.get()
			.then(function(success) {
				vm.categories = success.data;
				vm.selectedCategoryId = null;
				refreshSelectPickerWithDelay(100);
			}, function(error) {
				vm.categories = {};
			})
		}
		
		vm.generateMeritList = function(programCategoryId) {
			var selectedCategoryId = vm.selectedCategoryId;
			$state.go("collegeadmin.selectProgram", {programCategoryId:programCategoryId});
		}
		
		setTimeout(function() {
			vm.getCategories();
		}, $scope.getDataDelay);
	};
}());