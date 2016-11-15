(function(){
	"use strict";
	angular
		.module("login")
		.controller("LoginCtrl",
					["$http",
					 "$state",
					 "$rootScope",
					 "$window",
					 LoginCtrl]);
	
	function LoginCtrl($http, $state, $rootScope, $window) {
		var vm = this;
		vm.username = "";
		vm.password = "";
		vm.error = false;
		
		vm.isInvalidUser = $window.isInvalidUser;
		vm.isLoggedOutUser = $window.isLoggedOutUser;
		
		vm.login = function() {
			vm.memId = $window.memId;
			vm.credentials = {username : vm.username, password : vm.password};
			vm.error = true;
						
			$http({
                method: 'POST',
                url: '/login',
                data: vm.credentials
			})
			.success(function(data){
				vm.loginsuccessdata = data;
			})
			.error(function(data){
				vm.loginsuccessdata = data;
			});
		};
		
		vm.register = function() {
			$window.isInvalidUser = false;
			$window.isLoggedOutUser = false;
			$state.go("register");
		}
	};
}());