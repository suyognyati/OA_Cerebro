(function() {
	"use strict";
	angular
		.module("user")
		.factory("qualificationDetailService",
				["$http",
				 QualificationDetailService]);
	
	function QualificationDetailService($http) {
		return {
			getQualificationDetail : function(qualificationId, accessTokenParam) {
				return $http({
					method: "GET",
					url: "/Web/rest/educationalInformation/getQualificationDetail/" + qualificationId + accessTokenParam
				})
			},
			getNewQualification : function(qualificationMainLevel, accessTokenParam) {
				return $http({
					method: "GET",
					url: "/Web/rest/educationalInformation/getNewQualification/" + qualificationMainLevel + accessTokenParam
				})
			},
			saveQualificationDetail : function(qualificationDetail, accessTokenParam) {
				var educationalModel = {};
				delete qualificationDetail.resultStatusList;
				delete qualificationDetail.certifyingBodyList;
				delete qualificationDetail.monthList;
				delete qualificationDetail.yearList;
				delete qualificationDetail.countryList;
				delete qualificationDetail.stateList;				
				educationalModel.qualificationDetail = qualificationDetail;
				return $http({
					method: "POST",
					url: "/Web/rest/educationalInformation/saveQualificationDetail/" + accessTokenParam,
					data: educationalModel
				})
			}
		}
	}
}());