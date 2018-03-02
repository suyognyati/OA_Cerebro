(function(){
	"use strict";
	angular
		.module("user")
		.controller("ProgramCtrl",
					["$http",
					 "$state",
					 "$window",
					 "$filter",
					 "programService",
					 "applicationStatusService",
					 ProgramCtrl]);
	
	function ProgramCtrl($http, $state, $window, $filter, programService, applicationStatusService) {
		var vm = this;
		
		vm.programCategoryId = $state.params.programCategoryId;
		vm.accessToken = $window.bearer_token;
		vm.accessTokenParam = "?access_token=" + vm.accessToken;
		
		vm.itemPerPage = 2;
		
		vm.init = function() {
			//Collect all available programs
			programService.get(vm.programCategoryId, vm.accessTokenParam)
			.success(function(data, status, header, config) {
				vm.programs = data;
				
				//Collect applied courses
				applicationStatusService.get(vm.accessTokenParam)
				.success(function(data, status, header, config) {
					vm.appliedCourses = data;
					//Setting isAlreadyApplied as true if applied for program
					angular.forEach(vm.programs, function(item) {
						item.isAlreadyApplied = vm.isAppliedForProgram(item.collegeProgramId, vm.appliedCourses);
					});
				})
				.error(function(data, status, header, config) {
					vm.appliedCourses = {};
				});
			})
			.error(function(data, status, header, config) {
				vm.programs = {};
			});
			
			
			
			
			var h = 10;
		}

		vm.applyProgram = function(collegeProgramId, programName, programCode, universityFolderName, viewFileName){
			$state.go("application.subject", {collegeProgramId:collegeProgramId, programName:programName, 
				programCode:programCode, universityFolderName: universityFolderName, fileNameForProgram: viewFileName});
		};	
		
		vm.isAppliedForProgram = function(collegeProgramId, appliedCourses) {
			var appliedCourses = $filter("filter")(appliedCourses, {collegeProgramMap:{collegeProgramMapId:collegeProgramId}}, true);
			if(appliedCourses.length > 0)
				return true;
			else
				return false;
		}
		
		vm.init();
	};
}());