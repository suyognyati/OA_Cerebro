(function(){
	"use strict";
	angular
		.module("vendor")
		.controller("CollegeListCtrl",
					["$http",
					 CollegeListCtrl]);
	
	function CollegeListCtrl($http) {
		var vm = this;
	};
}());