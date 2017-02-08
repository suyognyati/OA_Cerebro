(function(){
	"use strict";
	angular
		.module("user")
		.controller("QualificationDetailCtrl",
					["$http",
					 "$window",
					 "$state",
					 "$stateParams",
					 "qualificationDetailService",
					 QualificationDetailCtrl]);
	
	function QualificationDetailCtrl($http, $window, $state, $stateParams, qualificationDetailService) {
		
		var vm = this;	
		vm.qualificationMainLevel = $state.params.qualificationMainLevel;
		vm.qualificationSubLevel = $state.params.qualificationSubLevel;
		
		vm.accessToken = $window.bearer_token;
		vm.accessTokenParam = "?access_token=" + vm.accessToken;

		qualificationDetailService.getQualificationDetail(vm.qualificationMainLevel, vm.qualificationSubLevel, vm.accessTokenParam)
		.success(function (data, status, headers, config) {
			vm.qualificationDetail = data;
			if(vm.qualificationDetail.isLocalBody == null) {
				vm.qualificationDetail.isLocalBody = true;
			}
			if(vm.qualificationDetail.evaluationType == null) {
				vm.qualificationDetail.evaluationType = 1;
			}
			if(vm.qualificationDetail.certifyingBody == null) {
				vm.qualificationDetail.certifyingBody = 3;
			}
			if(vm.qualificationDetail.qualificationMainLevel == null) {
				vm.qualificationDetail.qualificationMainLevel = vm.qualificationMainLevel;
			}
			if(vm.qualificationDetail.qualificationSubLevel == null) {
				vm.qualificationDetail.qualificationSubLevel = vm.qualificationSubLevel;
			}
		})
		.error(function (data, status, headers, config) {
			vm.qualificationDetail = {};
        });
		
		vm.submit = function() {
			qualificationDetailService.saveQualificationDetail(vm.qualificationDetail, vm.accessTokenParam)
			.success(function (data, status, headers, config) {
				vm.returnstatus = data;
				if(vm.returnstatus == true) {
					$state.go("educationInformation", {success: vm.returnstatus});
				}
			})
			.error(function (data, status, headers, config) {
				
	        });
		}
		
		vm.cancel = function() {
			$state.go("educationInformation");
		}
		
		vm.calculatePercentage = function() {
			if((vm.qualificationDetail.marksObtain != null && vm.qualificationDetail.marksObtain != "")
					&& (vm.qualificationDetail.totalMarks != null && vm.qualificationDetail.totalMarks != "")) {
				vm.qualificationDetail.percentage = ((vm.qualificationDetail.marksObtain / vm.qualificationDetail.totalMarks) * 100).toFixed(2);
			}
		}
	};
	
}());