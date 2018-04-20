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


		vm.qualificationDetail = function(qualificationMainLevel, qualificationId) {
			var view = mapView(qualificationMainLevel);

			$state.go($state.params.baseState + ".qualificationDetail", {qualification:view ,qualificationMainLevel:qualificationMainLevel, qualificationId:qualificationId});
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
	};

}());
