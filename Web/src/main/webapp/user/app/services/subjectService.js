(function() {
	"use strict";
	angular
		.module("user")
		.factory("subjectService",
				["$http",
				 SubjectService]);
	
	function SubjectService($http) {
		return {
			getSubjects: function (programId, accessTokenParam) {
				return $http({
                    method: "POST",
                    url: "/Web/rest/subject/get/" + programId + accessTokenParam
                });
            }
		}
	}
}());