(function() {
	"use strict";
	angular
		.module("common.services")
		.factory("personalDetailService",
				["$http",
				 PersonalDetailService]);
	
	function PersonalDetailService($http) {
		return {
			getPersonalDetail : function() {
				return $http({
					method: "GET",
					url: "/Web/personalDetail/getPersonalDetail/"
				})
			}
		}
	}
}());