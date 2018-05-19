(function() {
	"use strict";
	angular
		.module("app")
		.factory("printApplicationService",
				["$http",
				PrintApplicationService]);
	
	function PrintApplicationService($http) {
		return{
			getPrintApplicationDetail : function(){
				return $http({
					method: "GET",
					url: "/Web/printApplication/getPrintDetail/"
				})
			}
		}
	}
}());
