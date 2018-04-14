(function() {
	"use strict";
	angular
		.module("app")
		.factory("generateMeritListService",
				["$http",
				 GenerateMeritListService]);
	
	function GenerateMeritListService($http) {
		return {
			get : function() {
				return $http({
					method: "GET",
					url: "/Web/generateMeritList/programCategories/get/"
				})
			},
			getPrograms : function(programCategoryId) {
				return $http({
					method: "GET",
					url: "/Web/generateMeritList/getPrograms/" + programCategoryId
				})
			},
			getMeritList : function(programId) {
				return $http({
					method: "GET",
					url: "/Web/generateMeritList/getMeritList/" + programId
				})
			},
			
		}
	}
}());
