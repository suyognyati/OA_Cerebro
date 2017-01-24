(function(){
	"use strict";
	angular
		.module("user")
		.controller("EducationInformationCtrl",
					["$http",
					 "$window",
					 "educationInformationService",
					 EducationInformationCtrl]);
	
	function EducationInformationCtrl($http, $window, educationInformationService) {
		
		var vm = this;		
		
		vm.accessToken = $window.bearer_token;
		vm.accessTokenParam = "?access_token=" + vm.accessToken;

		educationInformationService.getListofQualification(vm.accessTokenParam)
		.success(function (data, status, headers, config) {
			vm.listofQualification = data;
		})
		.error(function (data, status, headers, config) {
			vm.listofQualification = {};
        });
	};
	
}());