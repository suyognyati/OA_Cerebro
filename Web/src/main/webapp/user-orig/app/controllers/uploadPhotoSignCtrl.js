(function(){
	"use strict";
	angular
		.module("user")
		.controller("UploadPhotoSignCtrl",
					["$http",
					 "$state",
					 "$window",
					 "$scope", 
					 "$rootScope",
					 "uploadPhotoSignService",
					 UploadPhotoSignCtrl]);
	
	function UploadPhotoSignCtrl($http, $state, $window, $scope, $rootScope, uploadPhotoSignService) {
		var vm = this;
		vm.personalDetailTemp = {};
		
		vm.accessToken = $window.bearer_token;
		vm.accessTokenParam = "?access_token=" + vm.accessToken;
		
		$scope.size = 'small';
		$scope.type = 'square';
		$scope.imageDataURI = '';
		$scope.resImageDataURI = '';
		$scope.resImgFormat = 'image/jpeg';
		$scope.resImgQuality = 1;
		$scope.selMinSize = 100;
		$scope.resImgSize = 200;
		$scope.enableCrop=true;
		$scope.showResult=false;
		//$scope.aspectRatio=1.2;
		$scope.onChange = function($dataURI) {
			console.log('onChange fired');
		};
		$scope.onLoadBegin = function() {
			console.log('onLoadBegin fired');
		};
		$scope.onLoadDone = function() {
			console.log('onLoadDone fired');
		};
		$scope.onLoadError = function() {
			console.log('onLoadError fired');
		};
		var handleFileSelect = function(evt) {
			var file = evt.currentTarget.files[0];
			var reader = new FileReader();
			reader.onload = function(evt) {
				$scope.$apply(function($scope) {
					$scope.imageDataURI = evt.target.result;
				});
			};
			reader.readAsDataURL(file);
		};
		angular.element(document.querySelector('#fileInput')).on('change',
				handleFileSelect);
		$scope.$watch('resImageDataURI', function() {
			//console.log('Res image', $scope.resImageDataURI);
		});
		
		$scope.submit = function() {
			var resultImage = $scope.resImageDataURI;
			uploadPhotoSignService.uploadPhotoSign(resultImage, vm.accessTokenParam)
			.success(function (data, status, headers, config) {
				vm.successMessage = "Detail saved successfully";
			})
			.error(function (data, status, headers, config) {
				vm.errorMessage = "Error while saving detail";
			});
		}
		
		$scope.crop = function(showRes) {
			//$scope.imageDataURI = $scope.resImageDataURI;
			$scope.showResult = showRes;
		}
	};
	
}());