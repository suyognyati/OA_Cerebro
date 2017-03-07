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
		
		vm.accessToken = $window.bearer_token;
		vm.accessTokenParam = "?access_token=" + vm.accessToken;

		addressService.get(vm.accessTokenParam)
		.success(function (data, status, headers, config) {
			vm.address = data;
			if(vm.address != null && vm.address.country != null) {
				vm.address.countryId = vm.address.country.countryId;
			}
			if(vm.address != null && vm.address.state != null) {
				vm.address.stateId = vm.address.state.stateId;
			}
			if(vm.address != null && vm.address.countryPermenent != null) {
				vm.address.countryPermenentId = vm.address.countryPermenent.countryId;
			}
			if(vm.address != null && vm.address.statePermenent != null) {
				vm.address.statePermenentId = vm.address.statePermenent.stateId;
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
                $state.go("educationInformation");
            })
            .error(function (data, status, headers, config) {
                vm.errorMessage = "Error while saving detail";
            });
		}	
		
		vm.saveDraft = function() {
			refreshSelectPickerWithDelay();
		}

		vm.setSelectedCountry = function() {
			if(vm.address != null && vm.address.countryList != null) {
				for(var i = 0; i < vm.address.countryList.length; i++) {
					if(vm.address.countryId == vm.address.countryList[i].countryId) {
						vm.address.country = vm.address.countryList[i];
					}
				}
				refreshSelectPickerWithDelay();
			}			
		}
		
		vm.setSelectedState = function() {
			if(vm.address != null && vm.address.country != null && vm.address.country.stateList != null) {
				for(var i = 0; i < vm.address.country.stateList.length; i++) {
					if(vm.address.stateId == vm.address.country.stateList[i].stateId) {
						vm.address.state = vm.address.country.stateList[i];
					}
				}
				refreshSelectPickerWithDelay();
			}
		}
		
	};
	
}());