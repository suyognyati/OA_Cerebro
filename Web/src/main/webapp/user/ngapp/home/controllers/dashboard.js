(function(){
	"use strict";
	angular
		.module("app")
		.controller("dashboardCtrl",
					["$state",
					 dashboardCtrl]);

	function dashboardCtrl($state) {
		var vm = this;
		vm.bloodGroupList = [
			{key:1, value:"O+ve"},
			{key:2, value:"O-ve"},
			{key:3, value:"A+ve"},
			{key:4, value:"A-ve"},
			{key:5, value:"B+ve"},
			{key:6, value:"B-ve"},
			{key:7, value:"AB+ve"},
			{key:8, value:"AB-ve"}
		];
		refreshSelectPickerWithDelay(100);
	};
}());
