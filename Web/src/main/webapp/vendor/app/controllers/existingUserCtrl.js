(function(){
	"use strict";
	angular
		.module("vendor")
		.controller("ExistingUserCtrl",
					["$http",
					 "$state",
					 "existingUserService",
					 ExistingUserCtrl]);
	
	function ExistingUserCtrl($http, $state, existingUserService) {
		var vm = this;
		vm.username = "";
		vm.password = "";
		vm.error = false;
		
		vm.accessToken = "";
		vm.accessTokenParam = "";

		vm.basicAuth = {
			username : "manalinyati",
			password : "manalinyati"
		};

		vm.credentials = {
		        username: "manalinyati", 
		        password: "manalinyati"
		};
			
		var headers = vm.basicAuth ? {
			authorization : "Basic "
					+ btoa(vm.basicAuth.username + ":"
							+ vm.basicAuth.password)
		} : {};
		
		
		vm.isInvalidUser = false;
		
		vm.login = function() {
			existingUserService.getToken(headers, vm.credentials)
			.success(function (data, status, headers, config) {
                vm.successMessage = "Detail saved successfully";
            })
            .error(function (data, status, headers, config) {
                vm.errorMessage = "Error while saving detail";
            });
			vm.username = "";
		};
	};
}());