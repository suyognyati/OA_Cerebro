(function() {
	"use strict";
	angular
		.module("app")
		.factory("profileDetailService",
				["$http",
				 ProfileDetailService]);
	
	function ProfileDetailService($http) {
		return {
			getUserDetail : function() {
				return $http({
					method: 'GET',
					url: '/Web/rest/userDetail/getUserDetail/'
				})
			},
			saveUserDetail: function (userDetail) {
				return $http({
                    method: 'POST',
                    url: '/Web/rest/userDetail/saveUserDetail/',
                    data: userDetail/*,
                    headers : { 'Content-Type': 'application/x-www-form-urlencoded' }*/
                });
            },
			getPersonalDetail : function(accessTokenParam) {
				return $http({
					method: "GET",
					url: "/Web/rest/personalDetail/getPersonalDetail/" + accessTokenParam,
					async: false
				})
			},
			savePersonalDetail : function (personalDetail, accessTokenParam) {
				return $http({
                    method: 'POST',
                    url: '/Web/rest/personalDetail/savePersonalDetail/' + accessTokenParam,
                    data: personalDetail
                });
            },
			getAddressDetail : function(accessTokenParam) {
				return $http({
					method: "GET",
					url: "/Web/rest/address/getAddressDetail/" + accessTokenParam
				})
			},
			saveAddressDetail : function (address, accessTokenParam) {
				return $http({
                    method: 'POST',
                    url: '/Web/rest/address/saveAddressDetail/' + accessTokenParam,
                    data: address
                });
            },
            getListofQualification : function(accessTokenParam) {
				return $http({
					method: "GET",
					url: "/Web/rest/educationalInformation/getListofQualification/" + accessTokenParam
				})
			},
			deleteQualification : function(qualificationId, accessTokenParam) {
				return $http({
					method: "POST",
					url: "/Web/rest/educationalInformation/deleteQualificationDetail/" + accessTokenParam,
					data: qualificationId
				})
			},
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
			},
			getOccupationReservation : function(accessTokenParam) {
				return $http({
					method: "GET",
					url: "/Web/rest/occupationreservation/getOccupationReservation/" + accessTokenParam
				})
			},
			saveOccupationReservation : function (occupationReservation, accessTokenParam) {
				return $http({
                    method: 'POST',
                    url: '/Web/rest/occupationreservation/saveOccupationReservation/' + accessTokenParam,
                    data: occupationReservation
                });
            },
            uploadSingleFile : function(file) {
				return $http({
					method: "POST",
					url: "/Web/rest/saveSingleFile",
					data:file,
					headers : {
						'Content-Type' : undefined
					}
				})
			},
			uploadMultipleFile : function(file) {
				return $http({
					method: "POST",
					url: "/Web/rest/saveMultipleFile",
					data:file,
					headers : {
						'Content-Type' : undefined
					}
				})
			},
			getUserDocumentList: function (accessTokenParam) {
				return $http({
                    method: 'GET',
                    url: '/Web/rest/getDocumentList' + accessTokenParam
                });
            },
			getDocument: function (userDocumentId, userDocumentPath) {
				return $http({
                    method: 'GET',
                    url: '/Web/rest/getDocument/' + userDocumentId
                });
            },
            uploadPhotoSign : function(photoBase64, accessTokenParam) {
				return $http({
					method: "POST",
					url: "/Web/rest/uploadPhotoSign/uploadPhoto/" + accessTokenParam,
					data: photoBase64
				})
			},
			
			
		}
	}
}());