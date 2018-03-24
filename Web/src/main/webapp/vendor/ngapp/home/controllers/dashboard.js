(function(){
	"use strict";
	angular
		.module("app")
		.controller("dashboardCtrl",
					["$state",
					 dashboardCtrl]);

	function dashboardCtrl($state) {
		var vm = this;
		
		vm.click = function() {
			$state.go("student.profile.personalDetail");
		}
		
		refreshSelectPickerWithDelay(100);
	};
}());
