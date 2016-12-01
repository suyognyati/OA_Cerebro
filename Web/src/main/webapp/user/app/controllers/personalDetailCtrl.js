(function(){
	"use strict";
	angular
		.module("user")
		.controller("PersonalDetailCtrl",
					["$http",
					 "$httpParamSerializer",
					 "personalDetailService",
					 "$scope",
					 PersonalDetailCtrl]);
	
	function PersonalDetailCtrl($http, $httpParamSerializer, personalDetailService, $scope) {
		var vm = this;		
		
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

		var oauthlink = "/Web/oauth/token?grant_type=password&username=" + vm.credentials.username + "&password=" + vm.credentials.password;
		
		$http({
            method: 'POST',
            url: oauthlink,
            headers:headers
        })		
		.success(function(data, status, headers, config) {
			vm.accessToken = data.access_token;
			vm.accessTokenParam = "?access_token=" + vm.accessToken;

			personalDetailService.get(vm.accessTokenParam)
			.success(function(data) {
				vm.personaldetail = data;
			});
		})
		.error(function(data, status, headers, config) {
			vm.accessToken = "";
			vm.accessTokenParam = "";
		});
		
		vm.submit = function() {
			personalDetailService.save(vm.personaldetail, vm.accessTokenParam)
			.success(function (data, status, headers, config) {
                vm.successMessage = "Detail saved successfully";
            })
            .error(function (data, status, headers, config) {
                vm.errorMessage = "Error while saving detail";
            });
		}		
	};
	
}());