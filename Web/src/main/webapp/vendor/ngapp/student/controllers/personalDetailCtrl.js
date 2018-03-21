(function(){
	"use strict";
	angular
		.module("app")
		.controller("PersonalDetailCtrl",
					["$state",
					 "$http",
					 "$httpParamSerializer",
					 "$timeout",
					 "$scope",
					 "$window",
					 "personalDetailService",
					 PersonalDetailCtrl]);

	function PersonalDetailCtrl($state, $http, $timeout, $httpParamSerializer, $scope, $window, personalDetailService) {
		$window.scrollTo(0, 0);
		
		var vm = this;
		vm.personaldetail = {};
		vm.personalDetailTemp = {};
		
		vm.accessTokenParam = $scope.getAccessTokenParam();
		
		vm.loadData = function() {
			personalDetailService.get(vm.accessTokenParam)
			.then(function (success) {
				vm.personaldetail = success.data;
				if(vm.personaldetail != null) {
					vm.initModel(vm.personaldetail);
				}
				refreshSelectPickerWithDelay(100);
			}, function (error) {
				vm.personaldetail = {};
			});
		}

		vm.initModel = function(personaldetail) {
			vm.indianCitizenship = false;
			if(personaldetail.countryOfCitizenship != null) {
				vm.personalDetailTemp.citizenshipCountryId = personaldetail.countryOfCitizenship.countryId;
			} else {
				if(personaldetail.countryList != null) {
					for(var i = 0; i < personaldetail.countryList.length; i++) {
						if(personaldetail.countryList[i].countryName == "India") {
							personaldetail.countryOfCitizenship = personaldetail.countryList[i];
							vm.personalDetailTemp.citizenshipCountryId = personaldetail.countryOfCitizenship.countryId;
						}
					}
				}
			}
			if(personaldetail.passportIssuingCountry != null) {
				vm.personalDetailTemp.passportIssuingCountryId = personaldetail.passportIssuingCountry.countryId;
			}
			if(personaldetail.domiciledIn != null) {
				vm.personalDetailTemp.domiciledInId = personaldetail.domiciledIn.stateId;
			}
			if(personaldetail.countryOfCitizenship != null && personaldetail.countryOfCitizenship.countryName == "India") {
				vm.indianCitizenship = true;
			}

		}

		vm.submit = function() {
			personalDetailService.save(vm.personaldetail, vm.accessTokenParam)
			.then(function (success) {
				vm.successMessage = "Detail saved successfully";
				$state.go("student.profile.address");
			}, function (error) {
				vm.errorMessage = "Error while saving detail";
			})
		}

		vm.saveDraft = function() {
			personalDetailService.save(vm.personaldetail, vm.accessTokenParam)
			.then(function (success) {
				vm.successMessage = "Detail saved successfully";
			}, function (error) {
				vm.errorMessage = "Error while saving detail";
			});
		}

		vm.setSelectedCitizenshipCountry = function() {
			if(vm.personaldetail != null && vm.personaldetail.countryList != null) {
				for(var i = 0; i < vm.personaldetail.countryList.length; i++) {
					if(vm.personalDetailTemp.citizenshipCountryId == vm.personaldetail.countryList[i].countryId) {
						vm.personaldetail.countryOfCitizenship = vm.personaldetail.countryList[i];
						if(vm.personaldetail.countryOfCitizenship.countryName == "India") {
							vm.indianCitizenship = true;
						} else {
							vm.indianCitizenship = false;
						}
					}
				}
				refreshSelectPickerWithDelay();
			}
		}

		vm.setSelectedPassportIssuingCountry = function() {
			if(vm.personaldetail != null && vm.personaldetail.countryList != null) {
				for(var i = 0; i < vm.personaldetail.countryList.length; i++) {
					if(vm.personalDetailTemp.passportIssuingCountryId == vm.personaldetail.countryList[i].countryId) {
						vm.personaldetail.passportIssuingCountry = vm.personaldetail.countryList[i];
					}
				}
				refreshSelectPickerWithDelay();
			}
		}

		vm.setSelectedState = function() {
			if(vm.personaldetail != null && vm.personaldetail.stateList != null) {
				for(var i = 0; i < vm.personaldetail.stateList.length; i++) {
					if(vm.personalDetailTemp.domiciledInId == vm.personaldetail.stateList[i].stateId) {
						vm.personaldetail.domiciledIn = vm.personaldetail.stateList[i];
					}
				}
				refreshSelectPickerWithDelay();
			}
		}
		
		setTimeout(function() {
		    vm.loadData();
		}, $scope.getDataDelay);
		
	};

}());
