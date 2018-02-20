(function(){
	"use strict";
	angular
		.module("vendor")
		.controller("SearchCtrl",
					["$http",
					 SearchCtrl]);
	
	function SearchCtrl($http) {
		var vm = this;
	};
}());