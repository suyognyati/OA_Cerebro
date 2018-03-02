(function() {
	"use strict";
	angular
		.module("user")
		.factory("uploadDocumentsService",
				["$http",
				 UploadDocumentsService]);
	
	function UploadDocumentsService($http) {
		return {
			uploadSingleFile : function(file) {
				return $http({
					method: "POST",
					url: "/Web/saveSingleFile",
					data:file,
					headers : {
						'Content-Type' : undefined
					}
				})
			},
			uploadMultipleFile : function(file) {
				return $http({
					method: "POST",
					url: "/Web/saveMultipleFile",
					data:file,
					headers : {
						'Content-Type' : undefined
					}
				})
			},
			getUserDocumentList: function (accessTokenParam) {
				return $http({
                    method: 'GET',
                    url: '/Web/getDocumentList' + accessTokenParam
                });
            },
			getDocument: function (userDocumentId, userDocumentPath) {
				return $http({
                    method: 'GET',
                    url: '/Web/getDocument/' + userDocumentId
                });
            }
		}
	}
}());
