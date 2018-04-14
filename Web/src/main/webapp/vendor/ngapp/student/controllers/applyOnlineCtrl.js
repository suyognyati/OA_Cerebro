(function(){
	"use strict";
	angular
		.module("app")
		.controller("ApplyOnlineCtrl",
					["$scope",
					 "$state",
					 "$http",
					 "$window",
					 "applyOnlineService",
					 ApplyOnlineCtrl]);

	function ApplyOnlineCtrl($scope, $state, $http, $window, applyOnlineService) {
		var vm = this;

		vm.accessTokenParam = $scope.getAccessTokenParam();
		
		vm.getCategories = function() {
			applyOnlineService.getApplyOnline(vm.accessTokenParam)
			.then(function(success) {
				vm.categories = success.data;
			}, function(error) {
				vm.categories = {};
			})
		}

		vm.applyForGraduation = function(programCategoryId) {
			$state.go("student.application.program", {programCategoryId:programCategoryId});
		}

		setTimeout(function() {
			vm.getCategories();
		}, $scope.getDataDelay);
		
	};

}());
