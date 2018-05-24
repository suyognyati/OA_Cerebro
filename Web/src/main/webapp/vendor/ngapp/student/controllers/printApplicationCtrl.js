(function(){
	"use strict";
	angular
		.module("app")
		.controller("PrintApplicationCtrl",
					["$scope",
					 "$http",
					 "$window",
					 "$state",
					 "applicationConfirmationService",
					 PrintApplicationCtrl]);

	function PrintApplicationCtrl($scope, $http, $window, $state, applicationConfirmationService) {
		var vm = this;

		vm.getPrintDetail = function() {
			applicationConfirmationService.getPrintApplicationDetail()
			.then(function(success) {
				vm.printDetail = success.data;
			}, function(error) {
				vm.printDetail = {};
			})
		}
		
		
		setTimeout(function() {
		    vm.getPrintDetail();
		}, $scope.getDataDelay);
	};
}());
