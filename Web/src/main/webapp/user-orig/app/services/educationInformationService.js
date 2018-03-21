(function() {
	"use strict";
	angular
		.module("user")
		.factory("educationInformationService",
				["$http",
				 EducationInformationService]);
	
	function EducationInformationService($http) {
		return {
			getListofQualification : function(accessTokenParam) {
				return $http({
					method: "GET",
					url: "/Web/rest/educationalInformation/getListofQualification/" + accessTokenParam
				})
			},
			deleteQualification : function(qualificationId, accessTokenParam) {
				return $http({
					method: "POST",
					url: "/Web/rest/educationalInformation/deleteQualificationDetail/" + accessTokenParam,
					data: qualificationId
				})
			}
		}
	}
}());