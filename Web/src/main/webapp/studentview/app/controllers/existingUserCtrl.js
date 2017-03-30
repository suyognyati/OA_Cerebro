(function(){
	"use strict";
	angular
		.module("user")
		.controller("ExistingUserCtrl",
					["$http",
					 "$state",
					 "$location",
					 "$window",
					 "existingUserService",
					 ExistingUserCtrl]);
	
	function ExistingUserCtrl($http, $state, $location, $window, existingUserService) {
		var vm = this;
		
		vm.accessToken = $window.bearer_token;
		if(vm.accessToken != null && vm.accessToken != "") {
			vm.accessTokenParam = "?access_token=" + vm.accessToken;
			$state.go("personalDetail");
		}
		
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
				
				vm.setAndRedirectUser(vm.accessTokenParam);
				/*existingUserService.setUser(vm.accessTokenParam)
				.success(function (data, status, headers, config) {
					var currenturl = $location.$$absUrl;
					var baseurl = currenturl.split("#");
					var userpageurl = baseurl[0] + "studentview/";
					$window.location.href = userpageurl;
				})
				.error(function (data, status, headers, config) {
					
				})*/
				
            })
            .error(function (data, status, headers, config) {
            	vm.accessToken = "";
    			vm.accessTokenParam = "";
            });
			vm.username = "";
		};
		
		vm.setAndRedirectUser = function(accessTokenParam) {
			existingUserService.setUser(accessTokenParam)
			.success(function (data, status, headers, config) {
				var currenturl = $location.$$absUrl;
				var baseurl = currenturl.split("#");
				var userpageurl = baseurl[0] + "studentview/";
				$window.location.href = userpageurl;
			})
			.error(function (data, status, headers, config) {
				
			})
		}
	};
}());