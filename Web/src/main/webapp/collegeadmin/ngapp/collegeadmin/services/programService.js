(function() {
	"use strict";
	angular
		.module("app")
		.factory("programService",
				["$http",
				 ProgramService]);
	
	function ProgramService($http) {
		return {
			/*get : function() {
				return $http({
					method: "GET",
					url: "/Web/generateMeritList/programCategories/get/"
				})
			},
			getAllPrograms : function() {
				return $http({
					method: "GET",
					url: "/Web/generateMeritList/getAllPrograms/"
				})
			},
			getPrograms : function(programCategoryId) {
				return $http({
					method: "GET",
					url: "/Web/generateMeritList/getPrograms/" + programCategoryId
				})
			},*/
			
			getCategoryWeightage : function(programId) {
				return $http({
					method: "GET",
					url: "/Web/program/getCategoryWeightage/" + programId
				})
			},
			
		}
	}
}());
