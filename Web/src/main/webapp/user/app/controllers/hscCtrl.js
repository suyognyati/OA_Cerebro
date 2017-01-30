(function(){
	"use strict";
	angular
		.module("user")
		.controller("HSCCtrl",
					["$http",
					 "$window",
					 HSCCtrl]);
	
	function HSCCtrl($http, $window) {
		
		var vm = this;		
		
		vm.accessToken = $window.bearer_token;
		vm.accessTokenParam = "?access_token=" + vm.accessToken;

		
	};
	
}());