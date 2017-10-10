(function(){
	"use strict";
	angular
		.module("user")
		.controller("ApplyOnlineCtrl",
					["$state",
					 "$http",
					 ApplyOnlineCtrl]);
	
	function ApplyOnlineCtrl($state, $http) {
		var vm = this;
		
		vm.applyForGraduation = function() {
			$state.go("application.bachelorCourses");
		}
	};
	
}());