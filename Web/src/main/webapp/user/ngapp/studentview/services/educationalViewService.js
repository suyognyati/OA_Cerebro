(function() {
	"use strict";
	angular
		.module("app")
		.factory("educationalViewService",
				["$http",
				 educationalViewService]);

	function educationalViewService($http) {
		return {
			getListofQualification : function(accessTokenParam) {
				return $http({
					method: "GET",
					url: "/Web/educationalInformation/getListofQualification/"
				})
			},
			deleteQualification : function(qualificationId, accessTokenParam) {
				return $http({
					method: "POST",
					url: "/Web/educationalInformation/deleteQualificationDetail/",
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
