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
					url: "/Web/course/bachelorCourse/get/" + accessTokenParam
				})
			},
			save: function (bachelorCourses, accessTokenParam) {
				return $http({
                    method: 'POST',
                    url: '/Web/course/bachelorCourse/save/' + accessTokenParam,
                    data: bachelorCourses
                });
            }
		}
	}
}());