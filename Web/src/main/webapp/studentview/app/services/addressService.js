(function() {
	"use strict";
	angular
		.module("user")
		.factory("addressService",
				["$http",
				 AddressService]);
	
	function AddressService($http) {
		return {
			getAddress : function(accessTokenParam) {
				return $http({
					method: "GET",
					url: "/Web/rest/address/get/" + accessTokenParam
				})
			},
			getUserDetail : function() {
				return $http({
					method: 'GET',
					url: '/Web/userDetail/get/'
				})
			}
		}
	}
}());