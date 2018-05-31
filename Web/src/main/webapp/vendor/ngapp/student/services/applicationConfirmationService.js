(function() {
	"use strict";
	angular
		.module("app")
		.factory("applicationConfirmationService",
				["$http", 
				ApplicationConfirmationService]);
	
	function ApplicationConfirmationService($http) {
		return{
			getPrintApplicationDetail : function(collegeProgramMapId, applicationId, accessTokenParam){
				return $http({
					method: "GET",
					url: "/Web/rest/application/getPrintDetail/" + collegeProgramMapId + "/" + applicationId + accessTokenParam
				})
			},
			
			getFeeDetail : function(collegeProgramMapId, applicationId, accessTokenParam) {
				return $http({
					method: "GET",
					url: "/Web/rest/application/paymentdetail/" + collegeProgramMapId + "/" + applicationId + accessTokenParam
				})
			},
			
			payAndSubmit : function(collegeProgramMapId, applicationId, accessTokenParam) {
				return $http({
					method: "GET",
					url: "/Web/rest/application/payAndSubmit/" + collegeProgramMapId + "/" + applicationId + accessTokenParam
				})
			},
			
			setApplicant : function(userId) {
				return $http({
					method: "GET",
					url: "/Web/applicants/setApplicant/" + userId
				})
			},
			
			getListofQualification : function(accessTokenParam) {
				return $http({
					method: "GET",
					url: "/Web/rest/educationalInformation/getListofQualification/" + accessTokenParam
				})
			},
		}
	}
}());
