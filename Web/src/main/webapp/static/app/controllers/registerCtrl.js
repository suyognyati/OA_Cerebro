(function(){
	"use strict";
	angular
		.module("hello")
		.controller("RegisterCtrl",
					["$http",
					 "$state",
					 "$rootScope",
					 RegisterCtrl]);
	
	function RegisterCtrl($http, $state, $rootScope) {
		var vm = this;
		
		
	};
}());