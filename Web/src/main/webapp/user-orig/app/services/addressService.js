(function() {
	"use strict";
	angular
		.module("user")
		.factory("addressService",
				["$http",
				 AddressService]);
	
	function AddressService($http) {
		return {
			get : function(accessTokenParam) {
				return $http({
					method: "GET",
					url: "/Web/rest/address/get/" + accessTokenParam
				})
			},
			save: function (address, accessTokenParam) {
				return $http({
                    method: 'POST',
                    url: '/Web/rest/address/save/' + accessTokenParam,
                    data: address
                });
            }
		}
	}
}());