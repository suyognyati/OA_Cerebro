(function(){
	"use strict";
	angular
		.module("app")
		.controller("PrintApplicationCtrl",
					["$scope",
					 "$http",
					 "$window",
					 "$state",
					 "printApplicationService",
					 PrintApplicationCtrl]);

	function PrintApplicationCtrl($scope, $http, $window, $state, printApplicationService) {
		var vm = this;

		vm.getPrintDetail = function() {
			printApplicationService.getPrintApplicationDetail()
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
