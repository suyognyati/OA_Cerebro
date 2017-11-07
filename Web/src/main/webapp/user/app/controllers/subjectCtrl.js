(function(){
	"use strict";
	angular
		.module("user")
		.controller("SubjectCtrl",
					["$http",
					 "$state",
					 "$window",
					 "subjectService",
					 SubjectCtrl]);
	
	function SubjectCtrl($http, $state, $window, subjectService) {
		var vm = this;
		
		vm.courseId = "1";
		vm.programName = $state.params.programName;
		vm.programCode = $state.params.programCode;
		
		vm.accessToken = $window.bearer_token;
		vm.accessTokenParam = "?access_token=" + vm.accessToken;
		
		subjectService.getBachelorCourse(vm.courseId, vm.accessTokenParam)
		.success(function(data, status, header, config) {
			vm.subjects = data;
		})
		.error(function(data, status, header, config) {
			vm.subjects = {};
		});
		
	};
}());