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

		var userId = 1;
		var vm = this;
		vm.qualificationList = [];
		if($state.params.success != null)
			vm.success = $state.params.success;

		vm.accessToken = $window.bearer_token;
		vm.accessTokenParam = "?access_token=" + vm.accessToken;

		profileViewService.setApplicant(userId)
		.then(function(success) {
			profileViewService.getListofQualification(vm.accessTokenParam)
			.then(function(success) {
				vm.qualificationList = success.data;
			}, function(error) {
				vm.qualificationList = error.data;
			})
		}, function(error) {
			vm.qualificationList = {};
		})


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

			return view;
		}
	};

}());
