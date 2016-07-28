(function(){
	"use strict";
	angular
		.module("eenroll")
		.controller("BasicDetailCtrl",
					["$http",
					 BasicDetailCtrl]);
	
	function BasicDetailCtrl($http) {
		var vm = this;
		
		$http({
			method: 'GET',
			url: '/Web/basicDetail/getBasicDetail/'
		})
		.success(function(data){
			vm.basicdetail = data;
		});
		
		vm.open = function($event){
			$event.preventDefault();
			$event.stopPropagation();
			
			vm.opened = !vm.opened;
		};
	};
}());