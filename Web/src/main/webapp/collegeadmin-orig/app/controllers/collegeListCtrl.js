(function(){
	"use strict";
	angular
		.module("collegeadmin")
		.controller("CollegeListCtrl",
					["$http",
					 "$state",
					 CollegeListCtrl]);
	
	function CollegeListCtrl($http,$state) {
		var vm = this;
		
		vm.appliedStudents = function(){
			$state.go("vendorHome.appliedStudentList");
		};
	};
}());