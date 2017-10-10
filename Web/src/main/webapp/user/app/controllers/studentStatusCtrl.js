(function(){
	"use strict";
	angular
		.module("user")
		.controller("StudentStatusCtrl",
					["$state",
					 "$http",
					 "$scope",
					 "$window",
					 StudentStatusCtrl]);
	
	function StudentStatusCtrl($state, $http, $scope, $window) {
		var vm = this;
		vm.redirect = function() {
			//$state.go("studentStatus.personalDetail");
		}
		vm.redirect();
	}
	
}());