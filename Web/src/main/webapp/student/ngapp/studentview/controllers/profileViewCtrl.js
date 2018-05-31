(function(){
	"use strict";
	angular
		.module("app")
		.controller("ProfileViewCtrl",
					["$state",
					 "$http",
					 "$httpParamSerializer",
					 "profileViewService",
					 "$scope",
					 "$window",
					 ProfileViewCtrl]);

	function ProfileViewCtrl($state, $http, $httpParamSerializer, profileViewService, $scope, $window) {
		var vm = this;
		vm.studentId = null
		
		if($state.params.studentId != null)
			vm.studentId = $state.params.studentId;
		
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

		vm.setApplicantAndGetDetail = function(studentId) {
			profileViewService.setApplicant(studentId)
			.then(function(success) {
				vm.getApplicantDetail();
			}, function(error) {
				vm.applicantdetail = {};
			})
		}

		vm.getApplicantDetail = function() {
			profileViewService.getApplicantDetail()
			.then(function(success) {
				vm.applicantdetail = success.data;
				vm.initModel();
			}, function(error) {
				vm.applicantdetail = {};
			})
		}
		
		vm.initModel = function() {
			if(vm.applicantdetail.countryOfCitizenship.countryName == "India") {
				vm.indianCitizenship = true
			} else {
				vm.indianCitizenship = false;
			}
		}

		vm.showGroupBox = function(id) {

			vm.showGroup.personalDetail = false;
			vm.showGroup.contactDetail = false;
			vm.showGroup.nationalityDetail = false;
			vm.showGroup.occupationDetail = false;
			vm.showGroup.reservationDetail = false;

			switch(id) {
				case "personal" :
					vm.showGroup.personalDetail = true;
					break;
				case "contact" :
					vm.showGroup.contactDetail = true;
					break;
				case "nationality" :
					vm.showGroup.nationalityDetail = true;
					break;
				case "occupation" :
					vm.showGroup.occupationDetail = true;
					break;
				case "reservation" :
					vm.showGroup.reservationDetail = true;
					break;
			}
			
			setActiveOnSubMenu(id);
		}
		
		vm.loadApplicantDetail = function() {
			if(vm.studentId == null) {
				vm.getApplicantDetail();
			} else {
				vm.setApplicantAndGetDetail(vm.studentId);
			}
		}
		
		vm.loadApplicantDetail();
		
	};

}());
