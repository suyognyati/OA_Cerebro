(function(){
	"use strict";
	angular
		.module("vendor")
		.controller("ExistingUserCtrl",
					["$http",
					 "$state",
					 "$location",
					 "$window",
					 "existingUserService",
					 ExistingUserCtrl]);
	
	function ExistingUserCtrl($http, $state, $location, $window, existingUserService) {
		var vm = this;
		vm.username = "";
		vm.password = "";
		vm.error = false;
		
		vm.accessToken = "";
		vm.accessTokenParam = "";

		vm.basicAuth = {
			username : "",
			password : ""
		};

		vm.credentials = {
		        username: "", 
		        password: ""
		};
			
		vm.isInvalidUser = false;
		
		vm.login = function() {
			vm.basicAuth.username = vm.credentials.username;
			vm.basicAuth.password = vm.credentials.password;
			var headers = vm.basicAuth ? {
				authorization : "Basic "
						+ btoa(vm.basicAuth.username + ":"
								+ vm.basicAuth.password)
			} : {};
			
			existingUserService.getToken(headers, vm.credentials)
			.success(function (data, status, headers, config) {
				vm.accessToken = data.access_token;
				vm.accessTokenParam = "?access_token=" + vm.accessToken;
				
				existingUserService.setUser(vm.accessTokenParam)
				.success(function (data, status, headers, config) {
					var currenturl = $location.$$absUrl;
					var baseurl = currenturl.split("#");
					var userpageurl = baseurl[0] + "user/";
					$window.location.href = userpageurl;
				})
				.error(function (data, status, headers, config) {
					
				})
				
            })
            .error(function (data, status, headers, config) {
            	vm.accessToken = "";
    			vm.accessTokenParam = "";
            });
			vm.username = "";
		};
		
		vm.newUser = function() {
			$window.isInvalidUser = false;
			$window.isLoggedOutUser = false;
			$state.go("newUser");
		}
	};
}());