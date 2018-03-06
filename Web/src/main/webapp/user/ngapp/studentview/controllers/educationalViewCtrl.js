(function(){
	"use strict";
	angular
		.module("app")
		.controller("EducationalViewCtrl",
					["$http",
					 "$window",
					 "$state",
					 "educationalViewService",
					 EducationalViewCtrl]);

	function EducationalViewCtrl($http, $window, $state, educationalViewService) {

		var userId = 1;
		var vm = this;
		vm.qualificationList = [];
		if($state.params.success != null)
			vm.success = $state.params.success;

		vm.accessToken = $window.bearer_token;
		vm.accessTokenParam = "?access_token=" + vm.accessToken;

		educationalViewService.setApplicant(userId)
		.then(function(success) {
			educationalViewService.getListofQualification(vm.accessTokenParam)
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
				view = "ssc";
			else if(qualificationMainLevel == 2)
				view = "11th";
			else if(qualificationMainLevel == 3)
				view = "hsc";
			else if(qualificationMainLevel == 4)
				view = "diploma";

			return view;
		}
	};

}());
