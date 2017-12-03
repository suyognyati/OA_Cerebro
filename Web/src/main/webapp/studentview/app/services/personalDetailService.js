(function() {
	"use strict";
	angular
		.module("user")
		.factory("personalDetailService",
				["$http",
				 PersonalDetailService]);
	
	function PersonalDetailService($http) {
		return {
			get : function(accessTokenParam) {
				return $http({
					method: "GET",
					url: "/Web/personalDetail/get/" + accessTokenParam
				})
			},
			save: function (personalDetail, accessTokenParam) {
				return $http({
                    method: 'POST',
                    url: '/Web/personalDetail/save/' + accessTokenParam,
                    data: personalDetail
                });
            },
            setApplicant : function() {
				return $http({
					method: "GET",
					url: "/Web/applicants/setApplicant/1"
				})
			},
            getApplicant : function() {
				return $http({
					method: "GET",
					url: "/Web/applicants/getDetail/"
				})
			}
		}
	}
}());