(function() {
	"use strict";
	angular
		.module("app")
		.factory("fileUploadService",
				["$http",
				 FileUploadService]);
	
	function FileUploadService($http) {
		return {
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