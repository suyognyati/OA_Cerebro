(function(){
	"use strict";
	angular
		.module("vendor")
		.controller("DashboardCtrl",
					["$http",
					 DashboardCtrl]);
	
	function DashboardCtrl($http) {
		var vm = this;
	};
}());