(function(){
	"use strict";
	angular
		.module("collegeadmin")
		.controller("SearchCtrl",
					["$http",
					 SearchCtrl]);
	
	function SearchCtrl($http) {
		var vm = this;
	};
}());