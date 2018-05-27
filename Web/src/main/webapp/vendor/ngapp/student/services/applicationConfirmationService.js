(function() {
	"use strict";
	angular
		.module("app")
		.factory("applicationConfirmationService",
				["$http", 
				ApplicationConfirmationService]);
	
	function ApplicationConfirmationService($http) {
		return{
			getPrintApplicationDetail : function(){
				return $http({
					method: "GET",
					url: "/Web/printApplication/getPrintDetail/"
				})
			},
			
			getFeeDetail : function(collegeProgramMapId, accessTokenParam) {
				return $http({
					method: "GET",
					url: "/Web/application/paymentdetail/" + collegeProgramMapId
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
					url: "/Web/educationalInformation/getListofQualification/"
				})
			},
		}
	}
}());
