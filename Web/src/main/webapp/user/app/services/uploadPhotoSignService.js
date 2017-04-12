(function() {
	"use strict";
	angular
		.module("user")
		.factory("uploadPhotoSignService",
				["$http",
				 UploadPhotoSignService]);
	
	function UploadPhotoSignService($http) {
		return {
			uploadPhotoSign : function(photoBase64, accessTokenParam) {
				return $http({
					method: "POST",
					url: "/Web/rest/uploadPhotoSign/uploadPhoto/" + accessTokenParam,
					data: photoBase64
				})
			}
		}
	}
}());
