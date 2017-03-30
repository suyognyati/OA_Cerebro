(function() {
	"use strict";
	angular
		.module("user")
		.factory("existingUserService",
				["$http",
				 ExistingUserService]);
	
	function ExistingUserService($http) {
		return {
			getToken : function(headers, credentials) {
				var oauthlink = "/Web/oauth/token";
				var grantTypeandCredentials = "?grant_type=password&username=" + credentials.username 
											+ "&password=" + credentials.password;
				
				return $http({
		            method: 'POST',
		            url: oauthlink + grantTypeandCredentials,
		            headers:headers
		        })
			},
			setUser : function(accessTokenParam) {
				return $http({
		            method: 'GET',
		            url: "/Web/rest/init/setuser/" + accessTokenParam
		        })
			}
		}
	}
}());