(function() {
	"use strict";
	angular
		.module("app")
		.factory("registerService",
				["$http",
				 RegisterService]);
	
	function RegisterService($http) {
		return {
			checkuseravailability : function(username) {
				return $http({
					method: "POST",
					url: "/Web/login/checkuseravailability",
					data: username
				})
			},
			createuser : function(studentProfileModel) {
				return $http({
					method: "POST",
					url: "/Web/login/createuser",
					data: studentProfileModel
				})
			}
		}
	}
}());