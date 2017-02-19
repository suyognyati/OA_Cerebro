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
		var qualificationMainLevel = $state.params.qualificationMainLevel;
		var qualificationSubLevel = $state.params.qualificationSubLevel;
		
		vm.accessToken = $window.bearer_token;
		vm.accessTokenParam = "?access_token=" + vm.accessToken;

		qualificationDetailService.getQualificationDetail(qualificationMainLevel, qualificationSubLevel, vm.accessTokenParam)
		.success(function (data, status, headers, config) {
			vm.qualificationDetail = data;
			//Doing initial assignments for qualification detail
			vm.initModel(vm.qualificationDetail);
			//Refreshing select picker with 100ms delay
			refreshSelectPickerWithDelay(100);
		})
		.error(function (data, status, headers, config) {
			vm.qualificationDetail = {};
        });
		
		vm.initModel = function(qualificationDetail) {
			if(qualificationDetail == null)
				return;
			
			if(qualificationDetail.percentage != null) {
				qualificationDetail.percentage = qualificationDetail.percentage.toFixed(2)
			}
			if(qualificationDetail.country != null) {
				qualificationDetail.countryId = qualificationDetail.country.countryId;
			}
			if(qualificationDetail.state != null) {
				qualificationDetail.stateId = qualificationDetail.state.stateId;
			}
			if(qualificationDetail.board != null) {
				qualificationDetail.boardId = qualificationDetail.board.boardId;
			}
			if(qualificationDetail.isLocalBody == null) {
				qualificationDetail.isLocalBody = true;
			}
			if(qualificationDetail.evaluationType == null) {
				qualificationDetail.evaluationType = 1;
			}
			if(qualificationDetail.certifyingBody == null) {
				qualificationDetail.certifyingBody = 3;
			}
			if(qualificationDetail.resultStatus == null) {
				qualificationDetail.resultStatus = 1;
			}
			if(qualificationDetail.qualificationMainLevel == null) {
				qualificationDetail.qualificationMainLevel = qualificationMainLevel;
			}
			if(qualificationDetail.qualificationSubLevel == null) {
				qualificationDetail.qualificationSubLevel = qualificationSubLevel;
			}
			for(var i = 0; i < qualificationDetail.stateList.length; i++) {
				for(var j = 0; j < qualificationDetail.allIndiaBoardList.length; j++) {
					qualificationDetail.stateList[i].boardList.push(qualificationDetail.allIndiaBoardList[j]);
				}
			}
			if(qualificationDetail.state != null) {
				for(var j = 0; j < qualificationDetail.allIndiaBoardList.length; j++) {
					qualificationDetail.state.boardList.push(qualificationDetail.allIndiaBoardList[j]);
				}
			}
		}
				
		vm.submit = function() {
			if(vm.qualificationDetail.qualificationMainLevel == null || vm.qualificationDetail.qualificationSubLevel == null) {
				vm.returnstatus = {};
				vm.returnstatus.success = false;
				vm.returnstatus.errorMessage = "Invalid input params";
				$window.scrollTo(0, 0);
				return;
			}
			qualificationDetailService.saveQualificationDetail(vm.qualificationDetail, vm.accessTokenParam)
			.success(function (data, status, headers, config) {
				vm.returnstatus = data;
				if(vm.returnstatus != null && vm.returnstatus.success == true) {
					$state.go("educationInformation", {success: vm.returnstatus});
				} else {
					$window.scrollTo(0, 0);
				}
			})
			.error(function (data, status, headers, config) {
				
	        });
		}
		
		vm.cancel = function() {
			$state.go("educationInformation");
		}
		
		vm.setSelectedCountry = function() {
			if(vm.qualificationDetail != null && vm.qualificationDetail.countryList != null) {
				for(var i = 0; i < vm.qualificationDetail.countryList.length; i++) {
					if(vm.qualificationDetail.countryId == vm.qualificationDetail.countryList[i].countryId) {
						vm.qualificationDetail.country = vm.qualificationDetail.countryList[i];
					}
				}
				refreshSelectPickerWithDelay();
			}			
		}
		
		vm.setSelectedState = function() {
			if(vm.qualificationDetail != null && vm.qualificationDetail.stateList != null) {
				for(var i = 0; i < vm.qualificationDetail.stateList.length; i++) {
					if(vm.qualificationDetail.stateId == vm.qualificationDetail.stateList[i].stateId) {
						vm.qualificationDetail.state = vm.qualificationDetail.stateList[i];
					}
				}
				refreshSelectPickerWithDelay();
			}
		}
		
		vm.setSelectedBoard = function() {
			for(var i = 0; i < vm.qualificationDetail.state.boardList.length; i++) {
				if(vm.qualificationDetail.boardId == vm.qualificationDetail.state.boardList[i].boardId) {
					vm.qualificationDetail.board = vm.qualificationDetail.state.boardList[i];
				}
			}
			refreshSelectPickerWithDelay(100);
		}
		
		vm.calculatePercentage = function() {
			if((vm.qualificationDetail.marksObtain != null && vm.qualificationDetail.marksObtain != "")
					&& (vm.qualificationDetail.totalMarks != null && vm.qualificationDetail.totalMarks != "")) {
				vm.qualificationDetail.percentage = ((vm.qualificationDetail.marksObtain / vm.qualificationDetail.totalMarks) * 100).toFixed(2);
			}
		}
	};
	
}());