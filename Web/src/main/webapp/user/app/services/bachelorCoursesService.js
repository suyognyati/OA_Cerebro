(function() {
	"use strict";
	angular
		.module("user")
		.factory("bachelorCoursesService",
				["$http",
				 BachelorCoursesService]);
	
	function BachelorCoursesService($http) {
		return {
			get : function(accessTokenParam) {
				return $http({
					method: "GET",
					url: "/Web/bachelorCourses/get/" + accessTokenParam
				})
			},
			save: function (bachelorCourses, accessTokenParam) {
				return $http({
                    method: 'POST',
                    url: '/Web/bachelorCourses/save/' + accessTokenParam,
                    data: bachelorCourses
                });
            }
		}
	}
}());