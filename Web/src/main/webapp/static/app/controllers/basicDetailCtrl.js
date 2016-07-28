(function(){
	"use strict";
	angular
		.module("admission")
		.controller("BasicDetailCtrl",
					["$http",
					 "basicDetailResource",
					 BasicDetailCtrl]);
	
	function BasicDetailCtrl($http, basicDetailResource) {
		var vm = this;
		
		$http({
			method: 'GET',
			url: '/Web/basicDetail/getBasicDetail/'
		})
		.success(function(data){
			vm.basicdetail = data;
		});
		
		/*basicDetailResource.query(function(data){
			vm.basicdetail = data;
		});*/
		
		vm.open = function($event){
			$event.preventDefault();
			$event.stopPropagation();
			
			vm.opened = !vm.opened;
		};
	};
}());