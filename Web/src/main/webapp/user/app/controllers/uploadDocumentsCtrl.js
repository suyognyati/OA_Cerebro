(function(){
	"use strict";
	angular
		.module("user")
		.controller("UploadDocumentsCtrl",
					["$http",
					 "$state",
					 "$window",
					 "$scope", 
					 "$rootScope",
					 "uploadDocumentsService",
					 UploadPhotoSignCtrl]);
	
	function UploadPhotoSignCtrl($http, $state, $window, $scope, $rootScope, uploadDocumentsService) {
		var vm = this;		
		
		vm.accessToken = $window.bearer_token;
		vm.accessTokenParam = "?access_token=" + vm.accessToken;

		vm.proval=0;
		vm.promax=0;
		
		vm.files = [];
        
		// GET THE FILE INFORMATION.
        $scope.getFileDetails = function (e) {

            $scope.$apply(function () {

                // STORE THE FILE OBJECT IN AN ARRAY.
                for (var i = 0; i < e.files.length; i++) {
                    vm.files.push(e.files[i])
                }

            });
        };
		
        vm.uploadMultipleFiles = function() {

			var file = vm.myFile;
			var fd = new FormData();
			fd.append('path', "\\\\DESKTOP-BIL8JRA\\UploadFiles\\");
			for (var i in vm.files) {
				fd.append('file', vm.files[i]);
            }
			
			// ADD LISTENERS.
			var objXhr = new XMLHttpRequest();
            objXhr.addEventListener("progress", updateProgressEventHandler, false);
            objXhr.addEventListener("load", transferCompleteEventHandler, false);
			
            objXhr.open("POST", "/Web/saveMultipleFile");
            objXhr.send(fd);
		}
        

		// UPDATE PROGRESS BAR MANUALLY.
		function updateProgressManually(processed, total) {
			vm.proval = processed;
			vm.promax = total;
		}

		// CONFIRMATION.
		function transferCompleteEventHandler(e) {
			alert("Files uploaded successfully.");
		}
        
		vm.uploadFilesOneByOne = function() {
			vm.proval=0;
			vm.promax=0;
			var totalLength = vm.files.length;
			var uploadedFiles = 0;
			for (var i in vm.files) {
				var fd = new FormData();
				fd.append('path', "\\\\DESKTOP-BIL8JRA\\UploadFiles\\");
				fd.append('file', vm.files[i]);
            
				uploadDocumentsService.uploadSingleFile(fd)
				.success(function() {
					uploadedFiles ++;
					updateProgressManually(uploadedFiles, totalLength);
				}).error(function() {
				});
			}
		}
		
		/*
		 * vm.uploadFiles = function(isValid) {
		 * 
		 * var file = vm.myFile; var fd = new FormData(); fd.append('path',
		 * "\\\\DESKTOP-BIL8JRA\\UploadFiles\\"); fd.append('file', file);
		 * uploadPhotoSignService.uploadFile(fd) .success(function() {
		 * console.log('success'); }).error(function() { console.log('error');
		 * }); }
		 */
	};
	
}());