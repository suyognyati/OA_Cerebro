(function() {
	"use strict";
	angular
		.module("app")
		.factory("applicationStatusService",
				["$http",
				 ApplicationStatusService]);

	function ApplicationStatusService($http) {
		return {
			get : function(accessTokenParam) {
				return $http({
					method: "GET",
					url: "/Web/rest/subject/getAppliedCourses" + accessTokenParam
				})
			}
		}
	}
}());
