(function() {
	"use strict";
	angular
		.module("app")
		.factory("programSelectService",
				["$http",
				 ProgramSelectService]);
	
	function ProgramSelectService($http) {
		return {
			get : function(programCategoryId) {
				return $http({
					method: "GET",
					url: "/Web/generateMeritList/getPrograms/" + programCategoryId
				})
			}
		}
	}
}());
