(function(){
	"use strict";
	angular
		.module("app")
		.controller("QualificationDetailCtrl",
					["$scope",
					 "$http",
					 "$window",
					 "$state",
					 "$stateParams",
					 "profileDetailService",
					 QualificationDetailCtrl]);

	function QualificationDetailCtrl($scope, $http, $window, $state, $stateParams, profileDetailService) {

		var vm = this;
		var qualificationGroup = $state.params.qualificationGroup;
		var qualificationId = $state.params.qualificationId;
		var newQualification = $state.params.newQualification;

		//Creating temporary qualificationGroupLevelList
		vm.qualificationDetail = [];
		vm.qualificationDetail.qualificationGroupLevelListOfProgram = [];

		// vm.accessToken = $window.bearer_token;
		// vm.accessTokenParam = "?access_token=" + vm.accessToken;

		vm.accessTokenParam = $scope.getAccessTokenParam();

		vm.getQualificationDetail = function() {
			profileDetailService.getQualificationDetail(qualificationId, vm.accessTokenParam)
			.then(function (success) {
				vm.qualificationDetail = success.data;
				//Doing initial assignments for qualification detail
				if(vm.qualificationDetail != null) {
					vm.initModel(vm.qualificationDetail);
				}
				//Refreshing select picker with 100ms delay
				refreshSelectPickerWithDelay(100);
			}, function (error) {
				vm.qualificationDetail = {};
			});
		}

		vm.getNewQualification = function() {
			profileDetailService.getNewQualification (qualificationGroup, vm.accessTokenParam)
			.then(function (success) {
				vm.qualificationDetail = success.data;
				//Doing initial assignments for qualification detail
				if(vm.qualificationDetail != null) {
					vm.initModel(vm.qualificationDetail);
				}
				//Refreshing select picker with 100ms delay
				refreshSelectPickerWithDelay(100);
			}, function (error) {
				vm.qualificationDetail = {};
			});
		}

		vm.initModel = function(qualificationDetail) {
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
			if(qualificationDetail.university != null) {
				qualificationDetail.universityId = qualificationDetail.university.universityId;
			}
			if(qualificationDetail.isLocalBody == null) {
				qualificationDetail.isLocalBody = true;
			}
			if(qualificationDetail.evaluationType == null) {
				qualificationDetail.evaluationType = 1;
			}
			if(qualificationDetail.certifyingBody == null) {
				if(qualificationDetail.qualificationGroup <= 3)
					qualificationDetail.certifyingBody = 1;
				else if(qualificationDetail.qualificationGroup == 4)
					qualificationDetail.certifyingBody = 3;
			}
			if(qualificationDetail.resultStatus == null) {
				qualificationDetail.resultStatus = 1;
			}
			if(qualificationDetail.qualificationGroup == null) {
				qualificationDetail.qualificationGroup = parseInt(qualificationGroup, 10);
			}
			if(qualificationDetail.qualificationGroupLevel == null) {
				qualificationDetail.qualificationGroupLevel = parseInt(qualificationId, 10);
			}
			if(qualificationDetail.stateList != null && qualificationDetail.allIndiaBoardList != null) {
				for(var i = 0; i < qualificationDetail.stateList.length; i++) {
					for(var j = 0; j < qualificationDetail.allIndiaBoardList.length; j++) {
						qualificationDetail.stateList[i].sscBoardList.push(qualificationDetail.allIndiaBoardList[j]);
						qualificationDetail.stateList[i].hscBoardList.push(qualificationDetail.allIndiaBoardList[j]);
						qualificationDetail.stateList[i].diplomaBoardList.push(qualificationDetail.allIndiaBoardList[j]);
					}
				}
			}
			if(qualificationDetail.state != null && qualificationDetail.allIndiaBoardList != null) {
				for(var j = 0; j < qualificationDetail.allIndiaBoardList.length; j++) {
					qualificationDetail.state.sscBoardList.push(qualificationDetail.allIndiaBoardList[j]);
					qualificationDetail.state.hscBoardList.push(qualificationDetail.allIndiaBoardList[j]);
					qualificationDetail.state.diplomaBoardList.push(qualificationDetail.allIndiaBoardList[j]);
				}
			}
			if(qualificationDetail.qualificationProgram != null) {
				qualificationDetail.qualificationProgramId = qualificationDetail.qualificationProgram.qualificationProgramId;
			}
			if(qualificationDetail.qualificationLevel != null) {
				qualificationDetail.qualificationLevelId = qualificationDetail.qualificationLevel.qualificationLevelId;
			}
			vm.qualificationDetail.qualificationGroupLevelListOfProgram = [];
			if(qualificationDetail.qualificationProgram != null && qualificationDetail.qualificationProgram.duration != null) {
				vm.createQualificationGroupLevelListOfProgram(qualificationDetail.qualificationProgram.duration);
			}
		}

		vm.submit = function() {
			if(vm.qualificationDetail.qualificationGroup == null || vm.qualificationDetail.qualificationGroupLevel == null) {
				vm.returnstatus = {};
				vm.returnstatus.success = false;
				vm.returnstatus.errorMessage = "Invalid input params";
				$window.scrollTo(0, 0);
				return;
			}
			profileDetailService.saveQualificationDetail(vm.qualificationDetail, vm.accessTokenParam)
			.then(function (success) {
				vm.returnstatus = success.data;
				if(vm.returnstatus != null && vm.returnstatus.success == true) {
					$state.go("student.profile.educationInformation", {success: vm.returnstatus});
				} else {
					$window.scrollTo(0, 0);
				}
			}, function (error) {

			});
		}

		vm.cancel = function() {
			var ay = vm.qualificationDetail.qualificationProgram;
			$state.go("student.profile.educationInformation");
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
				refreshSelectPickerWithDelay(100);
			}
		}

		vm.setSelectedBoard = function() {
			var boardList = null;
			switch(vm.qualificationDetail.qualificationGroup) {
				case 1:
				case 2: boardList = vm.qualificationDetail.state.sscBoardList;
						break;
				case 3: boardList = vm.qualificationDetail.state.hscBoardList;
						break;
				case 4: boardList = vm.qualificationDetail.state.diplomaBoardList;
						break;
				default:boardList = {};
			}
			for(var i = 0; i < boardList.length; i++) {
				if(vm.qualificationDetail.boardId == boardList[i].boardId) {
					vm.qualificationDetail.board = boardList[i];
				}
			}
			refreshSelectPickerWithDelay(100);
		}

		vm.setSelectedUniversity = function() {
			if(vm.qualificationDetail != null && vm.qualificationDetail.state != null && vm.qualificationDetail.state.universityList != null) {
				for(var i = 0; i < vm.qualificationDetail.state.universityList.length; i++) {
					if(vm.qualificationDetail.universityId == vm.qualificationDetail.state.universityList[i].universityId) {
						vm.qualificationDetail.university = vm.qualificationDetail.state.universityList[i];
					}
				}
				refreshSelectPickerWithDelay(100);
			}
		}

		vm.setSelectedQualificationProgram = function () {
			if(vm.qualificationDetail != null && vm.qualificationDetail.qualificationProgramList != null) {
				for(var i = 0; i < vm.qualificationDetail.qualificationProgramList.length; i++) {
					if(vm.qualificationDetail.qualificationProgramId == vm.qualificationDetail.qualificationProgramList[i].qualificationProgramId) {
						vm.qualificationDetail.qualificationProgram = vm.qualificationDetail.qualificationProgramList[i];
						vm.createQualificationGroupLevelListOfProgram(vm.qualificationDetail.qualificationProgram.duration);
					}
				}
				refreshSelectPickerWithDelay(100);
			} else {
				vm.qualificationDetail.qualificationProgram = null;
				vm.createQualificationGroupLevelListOfProgram(0);
			}
		}

		vm.setSelectedQualificationLevel = function () {
			if(vm.qualificationDetail != null && vm.qualificationDetail.qualificationGroupLevelList != null) {
				for(var i = 0; i < vm.qualificationDetail.qualificationGroupLevelList.length; i++) {
					if(vm.qualificationDetail.qualificationLevelId == vm.qualificationDetail.qualificationGroupLevelList[i].qualificationLevelId) {
						vm.qualificationDetail.qualificationLevel = vm.qualificationDetail.qualificationGroupLevelList[i];
					}
				}
				refreshSelectPickerWithDelay(100);
			} else {
				vm.qualificationDetail.qualificationLevel = null;
			}
		}

		vm.createQualificationGroupLevelListOfProgram = function (duration) {
			var qualificationGroupLevelListOfProgram = [];
			var qualificationGroupLevelList = vm.qualificationDetail.qualificationGroupLevelList;
			qualificationGroupLevelListOfProgram = []
			for(var i = 0; i < duration; i++) {
				var qualificationGroupLevelObject = qualificationGroupLevelList[i];
				qualificationGroupLevelListOfProgram.push(qualificationGroupLevelObject);
			}
			vm.qualificationDetail.qualificationGroupLevelListOfProgram = qualificationGroupLevelListOfProgram;
		}

		vm.calculatePercentage = function() {
			if((vm.qualificationDetail.marksObtain != null && vm.qualificationDetail.marksObtain != "")
					&& (vm.qualificationDetail.totalMarks != null && vm.qualificationDetail.totalMarks != "")) {
				vm.qualificationDetail.percentage = ((vm.qualificationDetail.marksObtain / vm.qualificationDetail.totalMarks) * 100).toFixed(2);
			}
		}

		setTimeout(function() {
			if(newQualification) {
				vm.getNewQualification();
			} else {
				vm.getQualificationDetail();
			}
		}, $scope.getDataDelay);
	};

}());
