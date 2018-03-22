(function(){
	"use strict";
	angular
		.module("collegeadmin")
		.controller("DashboardCtrl",
					["$http",
					 DashboardCtrl]);
	
	function DashboardCtrl($http) {
		var vm = this;
	};
}());