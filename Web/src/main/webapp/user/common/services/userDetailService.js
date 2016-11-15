(function(){
	"use strict";
	angular
		.module("common.services")
		.factory("userDetailService",
				["$http",
				 userDetailService]);
	
	function userDetailService($http){
		return {
			get : function() {
				return $http({
					method: 'GET',
					url: '/Web/userDetail/get/'
				})
			},
			save: function (userDetail) {
				return $http({
                    method: 'POST',
                    url: '/Web/userDetail/save/',
                    data: userDetail/*,
                    headers : { 'Content-Type': 'application/x-www-form-urlencoded' }*/
                });
            },
		}
	}
}());