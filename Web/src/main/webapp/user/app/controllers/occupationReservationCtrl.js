(function(){
	"use strict";
	angular
		.module("user")
		.controller("OccupationReservationCtrl",
					["$http",
					 UserDetailCtrl]);
	
	function UserDetailCtrl($http) {
		var vm = this;
	};
}());