(function(){
	"use strict";
	angular
		.module("admission")
		.controller("FamilyInformationCtrl",
					["$http",
					 "familyInformationResource",
					 FamilyInformationCtrl]);
	
	function FamilyInformationCtrl($http, familyInformationResource) {
		var vm = this;
		
		$http({
			method: 'GET',
			url: '/Web/familyInformation/getFamilyInformation/'
		})
		.success(function(data){
			vm.familyinformation = data;
		});
		
		fmailyInformationResource.query(function(data){
			vm.familyinformation = data;
		});
		
	};
	
}());