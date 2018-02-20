(function() {
	"use strict";
	angular
		.module("app")
		.factory("programService",
				["$http",
				 ProgramService]);

	function ProgramService($http) {
		return {
			get : function(programCategoryId, accessTokenParam) {
				return $http({
					method: "GET",
					url: "/Web/rest/program/get/" + programCategoryId + accessTokenParam
				})
			}
		}
	}
}());
