(function(){
	"use strict";
	angular
		.module("admission")
		.controller("EducationInformationCtrl",
					["$http",
					 "educationInformationResource",
					 EducationInformationCtrl]);
	
	function EducationInformationCtrl($http, educationInformationResource) {
		var vm = this;
		
		$http({
			method: 'GET',
			url: '/Web/educationInformation/getEducationInformation/'
		})
		.success(function(data){
			vm.educationinformation = data;
		});
		
		educationInformationResource.query(function(data){
			vm.educationinformation = data;
		});
		
	};
	
}());