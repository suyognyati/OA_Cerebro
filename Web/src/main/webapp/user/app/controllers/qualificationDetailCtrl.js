(function(){
	"use strict";
	angular
		.module("user")
		.controller("QualificationDetailCtrl",
					["$http",
					 "$window",
					 "$stateParams",
					 "qualificationDetailService",
					 QualificationDetailCtrl]);
	
	function QualificationDetailCtrl($http, $window, $stateParams, qualificationDetailService) {
		
		var vm = this;	
		vm.qualificationMainLevel = $stateParams.qualificationMainLevel;
		vm.qualificationLevelId = $stateParams.qualificationLevelId;
		
		vm.accessToken = $window.bearer_token;
		vm.accessTokenParam = "?access_token=" + vm.accessToken;

		qualificationDetailService.getQualificationDetail(vm.qualificationLevelId, vm.accessTokenParam)
		.success(function (data, status, headers, config) {
			vm.qualificationDetail = data;
		})
		.error(function (data, status, headers, config) {
			vm.qualificationDetail = {};
        });
		
	};
	
}());