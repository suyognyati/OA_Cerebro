(function(){
	"use strict";
	angular
		.module("admission")
		.controller("BasicDetailCtrl",
					["$http",
					 "basicDetailService",
					 BasicDetailCtrl]);
	
	function BasicDetailCtrl($http, basicDetailService) {
		var vm = this;
		
		basicDetailService.get()
		.success(function(data){
			vm.basicdetail = data;
		});
		
		vm.submit = function() {
			basicDetailService.save(vm.basicdetail)
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