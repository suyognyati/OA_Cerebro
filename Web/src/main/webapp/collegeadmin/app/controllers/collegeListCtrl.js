(function(){
	"use strict";
	angular
		.module("collegeadmin")
		.controller("CollegeListCtrl",
					["$http",
					 CollegeListCtrl]);
	
	function CollegeListCtrl($http) {
		var vm = this;
	};
}());