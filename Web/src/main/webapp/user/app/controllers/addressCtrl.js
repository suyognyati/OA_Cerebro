(function(){
	"use strict";
	angular
		.module("user")
		.controller("AddressCtrl",
					["$http",
					 "$window",
					 "addressService",
					 AddressCtrl]);
	
	function AddressCtrl($http, $window, addressService) {
		var vm = this;		
		
		vm.accessToken = $window.bearer_token;
		vm.accessTokenParam = "?access_token=" + vm.accessToken;

		addressService.get(vm.accessTokenParam)
		.success(function (data, status, headers, config) {
			vm.address = data;
		})
		.error(function (data, status, headers, config) {
			vm.address = {};
        });
		
		vm.submit = function() {
			addressService.save(vm.address, vm.accessTokenParam)
			.success(function (data, status, headers, config) {
                vm.successMessage = "Detail saved successfully";
            })
            .error(function (data, status, headers, config) {
                vm.errorMessage = "Error while saving detail";
            });
		}		
	};
	
}());