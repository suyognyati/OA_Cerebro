(function() {
	"use strict";
	angular
		.module("app")
		.factory("applyOnlineService",
				["$http",
				 ApplyOnlineService]);
	
	function ApplyOnlineService($http) {
		return {
			getApplyOnline : function(accessTokenParam) {
				return $http({
					method: "GET",
					url: "/Web/rest/applyOnline/programCategories/getApplyOnline/" + accessTokenParam
				})
			},
			getPrograms : function(programCategoryId, accessTokenParam) {
				return $http({
					method: "GET",
					url: "/Web/rest/program/getPrograms/" + programCategoryId + accessTokenParam
				})
			},
			getAllowedQualifications : function(collegeProgramId, accessTokenParam) {
				return $http({
					method: "GET",
					url: "/Web/rest/educationalInformation/getAllowedQualifications/" + collegeProgramId + accessTokenParam
				})
			},
			getSubjects: function (collegeProgramId, accessTokenParam) {
				return $http({
                    method: "POST",
                    url: "/Web/rest/subject/getSubjects/" + collegeProgramId + accessTokenParam
                });
            },

            applyForCourse: function (collegeProgramId, selectedSubjectList, selectedAllowedQualification, accessTokenParam) {
            	var appliedCourseModel = {};
            	appliedCourseModel.collegeProgramId = collegeProgramId;
            	appliedCourseModel.selectedSubjectList = selectedSubjectList;
            	appliedCourseModel.selectedAllowedQualification = selectedAllowedQualification;
				return $http({
                    method: "POST",
                    url: "/Web/rest/subject/applyForCourse" + accessTokenParam,
                    data:appliedCourseModel
                });
            },
            getAppliedCourses : function(accessTokenParam) {
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
			},
		}
	}
}());
