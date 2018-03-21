(function(){
	"use strict";
	angular
		.module("user")
		.controller("DiplomaCtrl",
					["$http",
					 "$window",
					 DiplomaCtrl]);
	
	function DiplomaCtrl($http, $window) {
		
		var vm = this;		
		
		vm.accessToken = $window.bearer_token;
		vm.accessTokenParam = "?access_token=" + vm.accessToken;

		
	};
	
}());