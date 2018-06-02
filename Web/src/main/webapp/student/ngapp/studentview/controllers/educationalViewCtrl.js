(function(){
	"use strict";
	angular
		.module("app")
		.controller("EducationalViewCtrl",
					["$http",
					 "$window",
					 "$state",
					 "profileViewService",
					 EducationalViewCtrl]);

	function EducationalViewCtrl($http, $window, $state, profileViewService) {

		var vm = this;
		vm.studentId = null
		vm.qualificationList = [];
		if($state.params.success != null)
			vm.success = $state.params.success;
		
		if($state.params.studentId != null)
			vm.studentId = $state.params.studentId;

		//This function will set user first and then will call to get details.
		//When external module will call this controller then this function will be useful.
		vm.setApplicantAndGetQualifications = function(studentId) {
			profileViewService.setApplicant(studentId)
			.then(function(success) {
				vm.getQualifications();
			}, function(error) {
				vm.qualificationList = {};
			})
		}
		
		vm.getQualifications = function() {
			profileViewService.getListofQualification()
			.then(function(success) {
				vm.qualificationList = success.data;
			}, function(error) {
				vm.qualificationList = error.data;
			})
		}
		
		vm.qualificationDetail = function(qualificationGroup, qualificationId) {
			var view = mapView(qualificationGroup);

			$state.go($state.params.baseState + ".qualificationDetail", {qualification:view ,qualificationGroup:qualificationGroup, qualificationId:qualificationId});
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
			else if(qualificationGroup == 6)
				view = "pg";

			return view;
		}
		
	
		vm.initEducationView = function() {
			if(vm.studentId == null) {
				vm.getQualifications();
			} else {
				vm.setApplicantAndGetQualifications(vm.studentId);
			}
		}
		
		vm.initEducationView();
	};

}());
