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
		
		vm.accessToken = $window.bearer_token;
		vm.accessTokenParam = "?access_token=" + vm.accessToken;

		personalDetailService.get(vm.accessTokenParam)
		.success(function (data, status, headers, config) {
			vm.personaldetail = data;
		})
		.error(function (data, status, headers, config) {
			vm.personaldetail = {};
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