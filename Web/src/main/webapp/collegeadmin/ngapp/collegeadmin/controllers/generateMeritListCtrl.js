(function(){
	"use strict";
	angular
		.module("app")
		.controller("GenerateMeritListCtrl",
					["$http",
					 "$state",
					 "$scope",
					 "generateMeritListService",
					 GenerateMeritListCtrl]);
	
	function GenerateMeritListCtrl($http, $state, $scope, generateMeritListService) {
		var vm = this;
		
		vm.programId = $state.params.programId;
		vm.programCategoryId = $state.params.programLevelId;
		
		
		
		vm.getMeritList = function() {
			generateMeritListService.getMeritList(vm.programId)
			.then(function(success){
				vm.studentMeritList = success.data;
			},function(error){
				vm.studentMeritList = {};
			})
		}
		
		vm.backToPrograms = function() {
			$state.go("collegeadmin.selectProgram");
		}
		
		setTimeout(function() {
			vm.getMeritList();
		}, $scope.getDataDelay);
	};
}());