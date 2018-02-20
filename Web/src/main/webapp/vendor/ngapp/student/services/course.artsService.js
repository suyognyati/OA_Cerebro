(function() {
	"use strict";
	angular
		.module("app")
		.factory("subjectService",
				["$http",
				 SubjectService]);

	function SubjectService($http) {
		return {
			getSubjects: function (collegeProgramId, accessTokenParam) {
				return $http({
                    method: "POST",
                    url: "/Web/rest/subject/get/" + collegeProgramId + accessTokenParam
                });
            },

            applyForCourse: function (collegeProgramId, selectedSubjectList, accessTokenParam) {
            	var appliedCourseModel = {};
            	appliedCourseModel.collegeProgramId = collegeProgramId;
            	appliedCourseModel.selectedSubjectList = selectedSubjectList;
				return $http({
                    method: "POST",
                    url: "/Web/rest/subject/applyForCourse" + accessTokenParam,
                    data:appliedCourseModel
                });
            }
		}
	}
}());
