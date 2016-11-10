(function() {
	"use strict";
	angular
		.module("common.services")
		.factory("personalDetailService",
				["$http",
				 PersonalDetailService]);
	
	function PersonalDetailService($http) {
		return {
			get : function() {
				return $http({
					method: "GET",
					url: "/Web/personalDetail/get/"
				})
			},
			save: function (personalDetail) {
				return $http({
                    method: 'POST',
                    url: '/Web/personalDetail/save/',
                    data: personalDetail
                });
            }
		}
	}
}());