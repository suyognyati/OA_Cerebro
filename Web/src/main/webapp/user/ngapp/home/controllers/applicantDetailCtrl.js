(function(){
	"use strict";
	angular
		.module("app")
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

		var personalDetail = true;
		var contactDetail = false;
		var nationalityDetail = false;
		var occupationDetail = false;
		var reservationDetail = false;

		vm.showGroup = {personalDetail : true,
					contactDetail : false,
					nationalityDetail : false,
					occupationDetail : false,
					reservationDetail : false};

		applicantDetailService.setApplicant(userId)
		.then(function(success) {
			applicantDetailService.getApplicant()
			.then(function(success) {
				vm.applicantdetail = success.data;
				vm.initModel();
			}, function(error) {
				vm.applicantdetail = {};
			})
		}, function(error) {
			vm.applicantdetail = {};
		})

		vm.initModel = function() {
			if(vm.applicantdetail.countryOfCitizenship.countryName == "India") {
				vm.indianCitizenship = true
			} else {
				vm.indianCitizenship = false;
			}
		}

		vm.showGroupBox = function(choice) {

			vm.showGroup.personalDetail = false;
			vm.showGroup.contactDetail = false;
			vm.showGroup.nationalityDetail = false;
			vm.showGroup.occupationDetail = false;
			vm.showGroup.reservationDetail = false;

			switch(choice) {
				case "personalDetail" :
					vm.showGroup.personalDetail = true;
					break;
				case "contactDetail" :
					vm.showGroup.contactDetail = true;
					break;
				case "nationalityDetail" :
					vm.showGroup.nationalityDetail = true;
					break;
				case "occupationDetail" :
					vm.showGroup.occupationDetail = true;
					break;
				case "reservationDetail" :
					vm.showGroup.reservationDetail = true;
					break;
			}
		}
	};

}());
