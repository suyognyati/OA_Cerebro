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
							childvalue.qualificationMainLevel = value.qualificationMainLevel;
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

		vm.qualificationDetail = function(qualificationMainLevel, qualificationId) {
			var view = mapView(qualificationMainLevel);

			$state.go("student.profile.qualificationDetail", {qualification:view ,qualificationMainLevel:qualificationMainLevel, qualificationId:qualificationId});
		}

		vm.createNewQualification = function(qualificationMainLevel, qualificationSubLevel) {
			var view = mapView(qualificationMainLevel);
			$state.go("student.profile.qualificationDetail", {qualification:view ,qualificationMainLevel:qualificationMainLevel, qualificationSubLevel:qualificationSubLevel, newQualification:true});
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
						$state.reload("studentStatus.educationInformation", {success: false});
					} else {
						$window.scrollTo(0, 0);
					}
				}, function (error) {

				});
			}
		}

		var mapView = function(qualificationMainLevel) {
			var view = "";
			if(qualificationMainLevel == 1)
				view = "elementry";
			else if(qualificationMainLevel == 2)
				view = "secondary";
			else if(qualificationMainLevel == 3)
				view = "highersecondary";
			else if(qualificationMainLevel == 4)
				view = "diploma";
			else if(qualificationMainLevel == 5)
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
