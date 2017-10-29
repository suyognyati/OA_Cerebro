(function() {
	"use strict";
	angular
		.module("user")
		.factory("subjectService",
				["$http",
				 SubjectService]);
	
	function SubjectService($http) {
		return {
			getBachelorCourse: function (courseId, accessTokenParam) {
				return $http({
                    method: "POST",
                    url: "/Web/rest/subject/bachelorCourse/get/" + accessTokenParam,
                    data: courseId
                });
            }
		}
	}
}());