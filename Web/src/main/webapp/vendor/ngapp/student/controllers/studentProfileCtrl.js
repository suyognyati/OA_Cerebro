(function(){
	"use strict";
	angular
		.module("app")
		.controller("StudentProfileCtrl",
					["$http",
					 "$scope",
					 "profileDetailService",
					 StudentProfileCtrl]);
	
	function StudentProfileCtrl($http, $scope, profileDetailService) {
		var vm = this;
		
		vm.accessTokenParam = $scope.getAccessTokenParam();
		
		profileDetailService.getStudentProfile(vm.accessTokenParam)
		.then(function(success) {
			vm.basicdetail = success.data;
		}, function(error) {
			
		})
		
		
		vm.submit = function() {
			profileDetailService.saveStudentProfile(vm.basicdetail, vm.accessTokenParam)
			.then(function(success) {
                vm.successMessage = "Detail saved successfully";
			}, function(error) {
                vm.errorMessage = "Error while saving detail";
			})
			
		}
		
		vm.open = function($event){
			$event.preventDefault();
			$event.stopPropagation();
			
			vm.opened = !vm.opened;
		};
	};
}());