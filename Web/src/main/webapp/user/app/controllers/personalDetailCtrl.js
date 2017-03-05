(function(){
	"use strict";
	angular
		.module("user")
		.controller("PersonalDetailCtrl",
					["$http",
					 "$httpParamSerializer",
					 "personalDetailService",
					 "$scope",
					 "$window",
					 PersonalDetailCtrl]);
	
	function PersonalDetailCtrl($http, $httpParamSerializer, personalDetailService, $scope, $window) {
		var vm = this;
		vm.personalDetailTemp = {};
		
		vm.accessToken = $window.bearer_token;
		vm.accessTokenParam = "?access_token=" + vm.accessToken;

		personalDetailService.get(vm.accessTokenParam)
		.success(function (data, status, headers, config) {
			vm.personaldetail = data;
			if(vm.personaldetail != null) {
				vm.initModel(vm.personaldetail);
			}
			refreshSelectPickerWithDelay(100);
		})
		.error(function (data, status, headers, config) {
			vm.personaldetail = {};
		});
		
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
			.success(function (data, status, headers, config) {
				vm.successMessage = "Detail saved successfully";
			})
			.error(function (data, status, headers, config) {
				vm.errorMessage = "Error while saving detail";
			});
		}
		
		vm.saveDraft = function() {
			refreshSelectPickerWithDelay();
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
	};
	
}());