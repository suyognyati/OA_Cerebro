(function() {
	"use strict";
	angular
		.module("app")
		.factory("personalDetailService",
				["$http",
				 PersonalDetailService]);
	
	function PersonalDetailService($http) {
		return {
			get : function(accessTokenParam) {
				return $http({
					method: "GET",
					url: "/Web/personalDetail/get/" + accessTokenParam,
					async: false
				})
			},
			save: function (personalDetail, accessTokenParam) {
				return $http({
                    method: 'POST',
                    url: '/Web/personalDetail/save/' + accessTokenParam,
                    data: personalDetail
                });
            }
		}
	}
}());