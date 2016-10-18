(function(){
	"use strict";
	angular
		.module("admission")
		.controller("OtherInformationCtrl",
					["$http",
					 "otherInformationResource",
					 OtherInformationCtrl]);
	
	function OtherInformationCtrl($http, otherInformationResource) {
		var vm = this;
		
		$http({
			method: 'GET',
			url: '/Web/otherInformation/getOtherInformation/'
		})
		.success(function(data){
			vm.otherinformation = data;
		});
		
		otherInformationResource.query(function(data){
			vm.otherinformation = data;
		});
		
	};
	
}());