(function(){
	"use strict";
	angular
		.module("app")
		.controller("ProgramListCtrl",
					["$http",
					 "$state",
					 "$scope",
					 "applyOnlineService",
					 ProgramListCtrl]);
	
	function ProgramListCtrl($http, $state, $scope, applyOnlineService) {
		var vm = this;
		
		vm.appliedStudents = function(){
			$state.go("collegeadmin.appliedStudentList");
		};
		
		vm.getCategories = function() {
			applyOnlineService.get()
			.then(function(success) {
				vm.categories = success.data;
			}, function(error) {
				vm.categories = {};
			})
		}
		
		setTimeout(function() {
			vm.getCategories();
		}, $scope.getDataDelay);
	};
}());