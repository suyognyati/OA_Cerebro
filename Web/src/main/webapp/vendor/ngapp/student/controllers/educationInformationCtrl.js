(function(){
	"use strict";
	angular
		.module("app")
		.controller("EducationInformationCtrl",
					["$scope",
					 "$http",
					 "$window",
					 "$state",
					 "profileDetailService",
					 EducationInformationCtrl]);

	function EducationInformationCtrl($scope, $http, $window, $state, profileDetailService) {

		var vm = this;
		vm.qualificationList = [];
		if($state.params.success != null)
			vm.success = $state.params.success;

		vm.accessTokenParam = $scope.getAccessTokenParam();

		vm.loadData = function() {
			profileDetailService.getListofQualification(vm.accessTokenParam)
			.then(function (success) {
				vm.qualificationList = success.data;
				/*vm.listofQualification = data;
				angular.forEach(vm.listofQualification, function(value, key) {
					if(value.subQualificationList == null) {
						vm.qualificationList.push(value);
					}
					else {
						angular.forEach(value.subQualificationList, function(childvalue, key) {
							childvalue.qualificationGroup = value.qualificationGroup;
							vm.qualificationList.push(childvalue);
						});
					}
				});
				vm.listofQualification = null;*/
			}, function (error) {
				vm.qualificationList = error.data;
				/*vm.listofQualification = {};*/
			});
		}

		vm.qualificationDetail = function(qualificationGroup, qualificationId) {
			var view = mapView(qualificationGroup);

			$state.go("student.profile.qualificationDetail", {qualification:view ,qualificationGroup:qualificationGroup, qualificationId:qualificationId});
		}

		vm.createNewQualification = function(qualificationGroup, qualificationGroupLevel) {
			var view = mapView(qualificationGroup);
			$state.go("student.profile.qualificationDetail", {qualification:view ,qualificationGroup:qualificationGroup, qualificationGroupLevel:qualificationGroupLevel, newQualification:true});
		}

		vm.deleteQualification = function(qualificationId, qualificationName) {
			var qualificationNameTemp;
			if(qualificationName != null && qualificationName != "") {
				qualificationNameTemp = "details of " + qualificationName;
			}
			var confirmation = confirm("Are you sure to delete " + qualificationNameTemp);
			if(confirmation == true) {
				profileDetailService.deleteQualification(qualificationId, vm.accessTokenParam)
				.then(function (success) {
					vm.returnstatus = success.data;
					if(vm.returnstatus != null && vm.returnstatus.success == true) {
						$state.reload("student.profile.educationInformation", {success: false});
					} else {
						$window.scrollTo(0, 0);
					}
				}, function (error) {

				});
			}
		}

		var mapView = function(qualificationGroup) {
			var view = "";
			if(qualificationGroup == 1)
				view = "elementry";
			else if(qualificationGroup == 2)
				view = "secondary";
			else if(qualificationGroup == 3)
				view = "highersecondary";
			else if(qualificationGroup == 4)
				view = "diploma";
			else if(qualificationGroup == 5)
				view = "degree";

			return view;
		}

		vm.submit = function() {
			$state.go("student.profile.occupationReservation");
		}

		setTimeout(function() {
		    vm.loadData();
		}, $scope.getDataDelay);
	};

}());
