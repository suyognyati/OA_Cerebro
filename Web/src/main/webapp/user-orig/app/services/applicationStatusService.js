(function() {
	"use strict";
	angular
		.module("user")
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