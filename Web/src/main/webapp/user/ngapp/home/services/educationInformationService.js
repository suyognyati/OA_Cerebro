(function() {
	"use strict";
	angular
		.module("app")
		.factory("educationInformationService",
				["$http",
				 EducationInformationService]);

	function EducationInformationService($http) {
		return {
			getListofQualification : function(accessTokenParam) {
				return $http({
					method: "GET",
					url: "/Web/educationalInformation/getListofQualification/" + accessTokenParam
				})
			},
			deleteQualification : function(qualificationId, accessTokenParam) {
				return $http({
					method: "POST",
					url: "/Web/educationalInformation/deleteQualificationDetail/" + accessTokenParam,
					data: qualificationId
				})
			},
			setApplicant : function(userId) {
				return $http({
					method: "GET",
					url: "/Web/applicants/setApplicant/" + userId
				})
			},
		}
	}
}());
