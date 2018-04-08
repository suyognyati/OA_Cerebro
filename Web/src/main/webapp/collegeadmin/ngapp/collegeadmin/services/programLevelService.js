(function() {
	"use strict";
	angular
		.module("app")
		.factory("programLevelService",
				["$http",
				 ProgramLevelService]);
	
	function ProgramLevelService($http) {
		return {
			get : function() {
				return $http({
					method: "GET",
					url: "/Web/generateMeritList/programCategories/get/"
				})
			}
		}
	}
}());
