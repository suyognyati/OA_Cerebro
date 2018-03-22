(function(){
	"use strict";
	angular
		.module("app")
		.controller("ProgramListCtrl",
					["$http",
					 "$state",
					 ProgramListCtrl]);
	
	function ProgramListCtrl($http,$state) {
		var vm = this;
		
		vm.appliedStudents = function(){
			$state.go("collegeadmin.appliedStudentList");
		};
	};
}());