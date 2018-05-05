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
					url: "/Web/educationalInformation/getQualificationDetail/" + qualificationId + accessTokenParam
				})
			},
			getNewQualification : function(qualificationGroup, accessTokenParam) {
				return $http({
					method: "GET",
					url: "/Web/educationalInformation/getNewQualification/" + qualificationGroup + accessTokenParam
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
					url: "/Web/educationalInformation/saveQualificationDetail/" + accessTokenParam,
					data: educationalModel
				})
			}
		}
	}
}());