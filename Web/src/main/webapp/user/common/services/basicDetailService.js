(function(){
	"use strict";
	angular
		.module("common.services")
		.factory("basicDetailService",
				["$http",
				 basicDetailService]);
	
	function basicDetailService($http){
		return {
			get : function() {
				return $http({
					method: 'GET',
					url: '/Web/basicDetail/get/'
				})
			},
			save: function (basicDetail) {
				return $http({
                    method: 'POST',
                    url: '/Web/basicDetail/save/',
                    data: basicDetail/*,
                    headers : { 'Content-Type': 'application/x-www-form-urlencoded' }*/
                });
            },
		}
	}
}());