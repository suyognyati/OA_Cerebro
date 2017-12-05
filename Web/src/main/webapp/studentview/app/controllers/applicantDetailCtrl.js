(function(){
	"use strict";
	angular
		.module("user")
		.controller("ApplicantDetailCtrl",
					["$state",
					 "$http",
					 "$httpParamSerializer",
					 "applicantDetailService",
					 "$scope",
					 "$window",
					 ApplicantDetailCtrl]);
	
	function ApplicantDetailCtrl($state, $http, $httpParamSerializer, applicantDetailService, $scope, $window) {
		var userId = 1;
		var vm = this;
		vm.personalDetailTemp = {};
		
		applicantDetailService.setApplicant(userId)
		.success(function (data, status, headers, config) {
			applicantDetailService.getApplicant()
			.success(function (data, status, headers, config) {
				vm.personaldetail = data;
			})
			.error(function (data, status, headers, config) {
				vm.personaldetail = {};
			});
		})
		.error(function (data, status, headers, config) {
			vm.personaldetail = {};
		});
	};
	
}());