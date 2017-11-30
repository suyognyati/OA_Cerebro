(function(){
	"use strict";
	angular
		.module("user")
		.controller("ProgramCtrl",
					["$http",
					 "$state",
					 "$window",
					 "programService",
					 ProgramCtrl]);
	
	function ProgramCtrl($http, $state, $window, programService) {
		var vm = this;
		
		vm.programCategoryId = $state.params.programCategoryId;
		vm.accessToken = $window.bearer_token;
		vm.accessTokenParam = "?access_token=" + vm.accessToken;
		
		vm.itemPerPage = 2;
		
		programService.get(vm.programCategoryId, vm.accessTokenParam)
		.success(function(data, status, header, config) {
			vm.programs = data;
		})
		.error(function(data, status, header, config) {
			vm.programs = {};
		});

		vm.applyProgram = function(programId, programName, programCode, universityFolderName, viewFileName){
			$state.go("application.subject", {programId:programId, programName:programName, programCode:programCode, 
				universityFolderName: universityFolderName, fileNameForProgram: viewFileName});
		};		
	};
}());