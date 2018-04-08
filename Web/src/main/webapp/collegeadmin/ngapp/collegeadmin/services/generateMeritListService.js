(function() {
	"use strict";
	angular
		.module("app")
		.factory("generateMeritListService",
				["$http",
				 GenerateMeritListService]);
	
	function GenerateMeritListService($http) {
		return {
			getMeritList : function(programId) {
				return $http({
					method: "GET",
					url: "/Web/generateMeritList/getMeritList/" + programId
				})
			},
			
		}
	}
}());
