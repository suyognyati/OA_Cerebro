(function(){
	"use strict";
	angular
		.module("common.services")
		.factory("basicDetailService",
				["$http",
				 basicDetailService]);
	
	function basicDetailService($http){
		return {
			getBasicDetail : function() {
				return $http({
					method: 'GET',
					url: '/Web/basicDetail/getBasicDetail/'
				})
			},
			save: function (basicDetail) {
                return $http({
                    method: 'POST',
                    url: '/Web/basicDetail/save/',
                    data: {'name':"Suyog"} 
                });
            },
		}
	}
}());