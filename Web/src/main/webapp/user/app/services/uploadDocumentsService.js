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
			}
			/*save: function (address, accessTokenParam) {
				return $http({
                    method: 'POST',
                    url: '/Web/rest/address/save/' + accessTokenParam,
                    data: address
                });
            }*/
		}
	}
}());
