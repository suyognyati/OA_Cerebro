(function() {
	"use strict";
	angular
		.module("app")
		.factory("profileViewService",
				["$http",
				 profileViewService]);
	
	function profileViewService($http) {
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