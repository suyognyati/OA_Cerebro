(function() {
	"use strict";
	angular
		.module("collegeadmin")
		.factory("newUserService",
				["$http",
				 NewUserService]);
	
	function NewUserService($http) {
		return {
			checkuseravailability : function(username) {
				return $http({
					method: "POST",
					url: "/Web/login/checkuseravailability",
					data: username
				})
			},
			createuser : function(userDetailModel) {
				return $http({
					method: "POST",
					url: "/Web/login/createuser",
					data: userDetailModel
				})
			}
		}
	}
}());