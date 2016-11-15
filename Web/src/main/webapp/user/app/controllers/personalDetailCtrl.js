(function(){
	"use strict";
	angular
		.module("user")
		.controller("PersonalDetailCtrl",
					["$http",
					 "personalDetailService",
					 PersonalDetailCtrl]);
	
	function PersonalDetailCtrl($http, personalDetailService) {
		var vm = this;
		
		personalDetailService.get()
		.success(function(data){
			vm.personaldetail = data;
		});
		
		vm.submit = function() {
			personalDetailService.save(vm.personaldetail)
			.success(function (data, status, headers, config) {
                vm.successMessage = "Detail saved successfully";
            })
            .error(function (data, status, headers, config) {
                vm.errorMessage = "Error while saving detail";
            });
		}		
	};
	
}());