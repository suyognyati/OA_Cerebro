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
			},
			
			deleteApplication : function(applicationId, accessTokenParam) {
				return $http({
					method: "POST",
					url: "/Web/rest/application/deleteAppliedCourse" + accessTokenParam,
					data: applicationId
				})
			}
		}
	}
}());
