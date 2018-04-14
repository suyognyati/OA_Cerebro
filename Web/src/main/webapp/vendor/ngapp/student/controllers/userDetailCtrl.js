(function(){
	"use strict";
	angular
		.module("app")
		.controller("UserDetailCtrl",
					["$http",
					 "profileDetailService",
					 UserDetailCtrl]);
	
	function UserDetailCtrl($http, profileDetailService) {
		var vm = this;
		
		profileDetailService.getUserDetail()
		.then(function(success) {
			vm.basicdetail = success.data;
		}, function(error) {
			
		})
		
		
		vm.submit = function() {
			profileDetailService.saveUserDetail(vm.basicdetail)
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