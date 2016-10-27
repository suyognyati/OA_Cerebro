(function(){
	"use strict";
	angular
		.module("admission")
		.controller("PersonalDetailCtrl",
					["$http",
					 "personalDetailService",
					 PersonalDetailCtrl]);
	
	function PersonalDetailCtrl($http, personalDetailService) {
		var vm = this;
		
		/*$http({
			method: 'GET',
			url: '/Web/personalDetail/getPersonalDetail/'
		})*/
		personalDetailService.getPersonalDetail()
		.success(function(data){
			vm.personaldetail = data;
		});
		
		/*personalDetailResource.query(function(data){
			vm.personaldetail = data;
		});*/
		
	};
	
}());