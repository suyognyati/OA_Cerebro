(function() {
	"use strict";
	angular
		.module("app")
		.factory("applicantDetailService",
				["$http",
				 ApplicantDetailService]);
	
	function ApplicantDetailService($http) {
		return {
			setApplicant : function(userId) {
				return $http({
					method: "GET",
					url: "/Web/applicants/setApplicant/" + userId
				})
			},
            getApplicant : function() {
				return $http({
					method: "GET",
					url: "/Web/applicants/getDetail/"
				})
			}
		}
	}
}());