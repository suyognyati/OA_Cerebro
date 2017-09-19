(function(){
	"use strict";
	angular
		.module("user")
		.controller("UploadPhotoSignCtrl-pm_editor",
					["$http",
					 "$state",
					 "$window",
					 "$scope", 
					 "$rootScope",
					 "uploadPhotoSignService",
					 UploadPhotoSignCtrl]);
	
	function UploadPhotoSignCtrl($http, $state, $window, $scope, $rootScope, uploadPhotoSignService) {
		var vm = this;		
		
		vm.accessToken = $window.bearer_token;
		vm.accessTokenParam = "?access_token=" + vm.accessToken;

		var widths = {
			'small': 300,
			'medium': 500,
			'big': 800
		};
		
		$scope.size = 'small';
        $scope.width = widths[$scope.size];
        $scope.image = '/Web/static/images/image.JPG';
        $scope.selectionWidth = 100;
        $scope.selectionHeight = 70;
        $scope.myCroppedImage = "";
        $scope.state = {};
        
        $scope.$watch('size', function(value) {
			if (value) {
				$scope.width = widths[value]
			}
		});
        
        $scope.butclick = function() {
        	var mycroppedimage = $scope.myCroppedImage;
        	var myimage = $scope.image;
        }
	};
	
}());