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
		vm.indianCitizenship = true;
		vm.applicantdetailTemp = {};
		
		applicantDetailService.setApplicant(userId)
		.success(function (data, status, headers, config) {
			applicantDetailService.getApplicant()
			.success(function (data, status, headers, config) {
				vm.applicantdetail = data;
				vm.initModel();
			})
			.error(function (data, status, headers, config) {
				vm.applicantdetail = {};
			});
		})
		.error(function (data, status, headers, config) {
			vm.applicantdetail = {};
		});
		
		vm.initModel = function() {
			if(vm.applicantdetail.countryOfCitizenship.countryName == "India") {
				vm.indianCitizenship = true
			} else {
				vm.indianCitizenship = false;
			}
		}
	};
	
}());