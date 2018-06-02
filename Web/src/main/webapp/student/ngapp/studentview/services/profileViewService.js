(function() {
	"use strict";
	angular
		.module("app")
		.factory("profileViewService",
				["$http",
				 profileViewService]);
	
	function profileViewService($http) {
		return {
			setApplicant : function(userId) {
				return $http({
					method: "GET",
					url: "/Web/applicants/setStudentUser/" + userId
				})
			},
            getApplicantDetail : function() {
				return $http({
					method: "GET",
					url: "/Web/applicants/getDetail/"
				})
			},
			getListofQualification : function() {
				return $http({
					method: "GET",
					url: "/Web/educationalInformation/getListofQualification/"
				})
			},
			deleteQualification : function(qualificationId, accessTokenParam) {
				return $http({
					method: "POST",
					url: "/Web/educationalInformation/deleteQualificationDetail/",
					data: qualificationId
				})
			},
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