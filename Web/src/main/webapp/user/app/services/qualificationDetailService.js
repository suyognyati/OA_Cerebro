(function() {
	"use strict";
	angular
		.module("user")
		.factory("qualificationDetailService",
				["$http",
				 QualificationDetailService]);
	
	function QualificationDetailService($http) {
		return {
			getQualificationDetail : function(qualificationLevelId, accessTokenParam) {
				return $http({
					method: "GET",
					url: "/Web/rest/educationalInformation/getQualificationDetail/" + qualificationLevelId + accessTokenParam
				})
			}
		}
	}
}());