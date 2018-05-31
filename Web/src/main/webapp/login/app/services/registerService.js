(function() {
	"use strict";
	angular
		.module("login")
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
			createuser : function(studentModel) {
				return $http({
					method: "POST",
					url: "/Web/login/createuser",
					data: studentModel
				})
			}
		}
	}
}());