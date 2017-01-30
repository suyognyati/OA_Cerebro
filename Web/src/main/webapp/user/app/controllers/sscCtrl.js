(function(){
	"use strict";
	angular
		.module("user")
		.controller("SSCCtrl",
					["$http",
					 "$window",
					 SSCCtrl]);
	
	function SSCCtrl($http, $window) {
		
		var vm = this;		
		
		vm.accessToken = $window.bearer_token;
		vm.accessTokenParam = "?access_token=" + vm.accessToken;

		
	};
	
}());