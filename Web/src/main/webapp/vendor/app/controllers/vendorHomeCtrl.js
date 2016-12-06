(function(){
	"use strict";
	angular
		.module("vendor")
		.controller("VendorHomeCtrl",
					["$http",
					 VendorHomeCtrl]);
	
	function VendorHomeCtrl($http) {
		var vm = this;
	};
}());