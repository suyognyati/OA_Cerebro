(function(){
	"use strict";
	angular
		.module("admission")
		.controller("PersonalDetailCtrl",
					["$http",
					 /*"personalDetailResource",*/
					 PersonalDetailCtrl]);
	
	function PersonalDetailCtrl($http/*, personalDetailResource*/) {
		var vm = this;
		
		$http({
			method: 'GET',
			url: '/Web/personalDetail/getPersonalDetail/'
		})
		.success(function(data){
			vm.personaldetail = data;
		});
		
		/*personalDetailResource.query(function(data){
			vm.personaldetail = data;
		});*/
		
	};
	
}());