(function(){
	"use strict";
	angular
		.module("collegeadmin")
		.controller("VendorHomeCtrl",
					["$http",
					 VendorHomeCtrl]);
	
	function VendorHomeCtrl($http) {
		var vm = this;
	};
}());