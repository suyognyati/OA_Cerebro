(function(){
	"use strict";
	angular
		.module("user")
		.controller("AddressCtrl",
					["$http",
					 "$state",
					 "$window",
					 "addressService",
					 AddressCtrl]);
	
	function AddressCtrl($http, $state, $window, addressService) {
		var vm = this;
		
		vm.isCountryIndia = false;
		vm.isCountryPermanentIndia = false;
		
		vm.accessToken = $window.bearer_token;
		vm.accessTokenParam = "?access_token=" + vm.accessToken;

		addressService.get(vm.accessTokenParam)
		.success(function (data, status, headers, config) {
			vm.address = data;
			if(vm.address != null) {
				if(vm.address.country != null) {
					vm.address.countryId = vm.address.country.countryId;
					if(vm.address.country.countryName = "India") {
						vm.isCountryIndia = true;
					} else {
						vm.isCountryIndia = false;
					}
				} else {
					for(var i = 0; i < vm.address.countryList.length; i++) {
						if(vm.address.countryList[i].countryName == "India") {
							vm.address.countryId = vm.address.countryList[i].countryId;
							vm.address.country = vm.address.countryList[i];
							vm.isCountryIndia = true;
							break;
						}
					}
				}
				if(vm.address.countryPermanent != null) {
					vm.address.countryPermanentId = vm.address.countryPermanent.countryId;
					if(vm.address.countryPermanent.countryName = "India") {
						vm.isCountryPermanentIndia = true;
					} else {
						vm.isCountryPermanentIndia = false;
					}
				} else {
					for(var i = 0; i < vm.address.countryList.length; i++) {
						if(vm.address.countryList[i].countryName == "India") {
							vm.address.countryPermanentId = vm.address.countryList[i].countryId;
							vm.address.countryPermanent = vm.address.countryList[i];
							vm.isCountryPermanentIndia = true;
							break;
						}
					}
				}
				if(vm.address.state != null) {
					vm.address.stateId = vm.address.state.stateId;
				}
				if(vm.address.statePermanent != null) {
					vm.address.statePermanentId = vm.address.statePermanent.stateId;
				}
			}
			refreshSelectPickerWithDelay(100);
		})
		.error(function (data, status, headers, config) {
			vm.address = {};
        });
		
		vm.submit = function() {
			addressService.save(vm.address, vm.accessTokenParam)
			.success(function (data, status, headers, config) {
                vm.successMessage = "Detail saved successfully";
                $state.go("studentStatus.educationInformation");
            })
            .error(function (data, status, headers, config) {
                vm.errorMessage = "Error while saving detail";
            });
		}	
		
		vm.saveDraft = function() {
			refreshSelectPickerWithDelay();
		}

		vm.setSelectedCountry = function(isPermanent) {
			if(vm.address != null && vm.address.countryList != null) {
				for(var i = 0; i < vm.address.countryList.length; i++) {
					if(isPermanent) {
						if(vm.address.countryPermanentId == vm.address.countryList[i].countryId) {
							vm.address.countryPermanent = vm.address.countryList[i];
							if(vm.address.countryPermanent.countryName == "India") {
								vm.isCountryPermanentIndia = true;
							} else {
								vm.isCountryPermanentIndia = false;
							}
						}
					} else {
						if(vm.address.countryId == vm.address.countryList[i].countryId) {
							vm.address.country = vm.address.countryList[i];
							if(vm.address.country.countryName == "India") {
								vm.isCountryIndia = true;
							} else {
								vm.isCountryIndia = false;
							}
						}
					}
				}
				refreshSelectPickerWithDelay();
			}			
		}
		
		vm.setSelectedState = function(isPermanent) {
			if(vm.address != null && vm.address.stateList != null) {
				for(var i = 0; i < vm.address.stateList.length; i++) {
					if(isPermanent) {
						if(vm.address.statePermanentId == vm.address.stateList[i].stateId) {
							vm.address.statePermanent = vm.address.stateList[i];
						}
					} else {
						if(vm.address.stateId == vm.address.stateList[i].stateId) {
							vm.address.state = vm.address.stateList[i];
						}
					}
				}
				refreshSelectPickerWithDelay();
			}
		}
		
	};
	
}());