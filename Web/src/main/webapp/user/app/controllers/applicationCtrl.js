(function(){
	"use strict";
	angular
		.module("user")
		.controller("ApplicationCtrl",
					["$state",
					 "$http",
					 "$scope",
					 "$window",
					 ApplicationCtrl]);
	
	function ApplicationCtrl($state, $http, $scope, $window) {
		var vm = this;
		vm.redirect = function() {
			$state.go("application.applyOnline");
		}
		vm.redirect();
	}
	
}());