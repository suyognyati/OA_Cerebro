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
		
		/*$http({
			method: 'GET',
			url: '/Web/basicDetail/getBasicDetail/'
		})
		.success(function(data){
			vm.basicdetail = data;
		});*/
		
		/*basicDetailResource.query(function(data){
			vm.basicdetail = data;
		});*/
		
		basicDetailService.getBasicDetail()
		.success(function(data){
			vm.basicdetail = data;
		});
		
		vm.submit = function() {
			basicDetailService.save(vm.basicdetail)
			.success(function (data, status, headers, config) {
                vm.successMessage = "Subjects created successfully";
              //  alert('subject created successfully');

            })
            .error(function (data, status, headers, config) {
                vm.errorMessage = "Error in subject creation";
               // alert('Error in subject creation');

            });
		}
		
		vm.open = function($event){
			$event.preventDefault();
			$event.stopPropagation();
			
			vm.opened = !vm.opened;
		};
	};
}());