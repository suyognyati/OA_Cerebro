(function(){
	"use strict";
	angular
		.module("app")
		.controller("ProgramCtrl",
					["$scope",
					 "$http",
					 "$state",
					 "$window",
					 "$filter",
					 "applyOnlineService",
					 ProgramCtrl]);

	function ProgramCtrl($scope, $http, $state, $window, $filter, applyOnlineService) {
		var vm = this;

		vm.programCategoryId = $state.params.programCategoryId;

		vm.itemPerPage = 2;
		vm.accessTokenParam = $scope.getAccessTokenParam();

		vm.getPrograms = function() {
			//Collect all available programs
			applyOnlineService.getPrograms(vm.programCategoryId, vm.accessTokenParam)
			.then(function(success) {
				vm.programs = success.data;

				//Collect applied courses
				applyOnlineService.getAppliedCourses(vm.accessTokenParam)
				.then(function(success) {
					vm.appliedCourses = success.data;
					//Setting isAlreadyApplied as true if applied for program
					angular.forEach(vm.programs, function(item) {
						item.isAlreadyApplied = vm.isAppliedForProgram(item.collegeProgramId, vm.appliedCourses);
					});
				},function(error) {
					vm.appliedCourses = {};
				})
			}, function(error) {
				vm.programs = {};
			})

			var h = 10;
		}

		vm.applyProgram = function(collegeProgramId, programName, programCode, universityFolderName, viewFileName){
			$state.go("student.application.subject", {collegeProgramId:collegeProgramId, programName:programName,
				programCode:programCode, universityFolderName: universityFolderName, fileNameForProgram: viewFileName});
		};

		vm.isAppliedForProgram = function(collegeProgramId, appliedCourses) {
			var appliedCourses = $filter("filter")(appliedCourses, {collegeProgramMap:{collegeProgramMapId:collegeProgramId}}, true);
			if(appliedCourses.length > 0)
				return true;
			else
				return false;
		}

		setTimeout(function() {
		    vm.getPrograms();
		}, $scope.getDataDelay);
	};
}());
