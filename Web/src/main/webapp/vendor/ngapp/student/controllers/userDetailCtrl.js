(function(){
	"use strict";
	angular
		.module("user")
		.controller("UserDetailCtrl",
					["$http",
					 "userDetailService",
					 UserDetailCtrl]);
	
	function UserDetailCtrl($http, userDetailService) {
		var vm = this;
		
		userDetailService.get()
		.then(function(success) {
			vm.basicdetail = success.data;
		}, function(error) {
			
		})
		
		
		vm.submit = function() {
			userDetailService.save(vm.basicdetail)
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