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
			}
		}
	}
}());