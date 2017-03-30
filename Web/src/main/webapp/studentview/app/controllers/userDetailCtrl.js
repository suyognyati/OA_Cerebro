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
		.success(function(data){
			vm.basicdetail = data;
		});
		
		vm.submit = function() {
			userDetailService.save(vm.basicdetail)
			.success(function (data, status, headers, config) {
                vm.successMessage = "Detail saved successfully";
            })
            .error(function (data, status, headers, config) {
                vm.errorMessage = "Error while saving detail";
            });
		}
		
		vm.open = function($event){
			$event.preventDefault();
			$event.stopPropagation();
			
			vm.opened = !vm.opened;
		};
	};
}());