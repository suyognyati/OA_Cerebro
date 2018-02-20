(function() {
	"use strict";
	angular
		.module("app")
		.factory("applyOnlineService",
				["$http",
				 ApplyOnlineService]);
	
	function ApplyOnlineService($http) {
		return {
			get : function(accessTokenParam) {
				return $http({
					method: "GET",
					url: "/Web/rest/applyOnline/programCategories/get/" + accessTokenParam
				})
			}
		}
	}
}());
