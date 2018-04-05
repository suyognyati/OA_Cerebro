(function(){
	"use strict";
	angular
		.module("app")
		.controller("RegisterCtrl",
					["$http",
					 "$state",
					 "$rootScope",
					 "registerService",
					 RegisterCtrl]);
	
	function RegisterCtrl($http, $state, $rootScope, registerService) {
		var vm = this;
		vm.storedUserName = "";
		vm.isUserCreated = false;
		vm.user = new Object();
		vm.user.firstName = "";
		vm.user.lastName = "";
		vm.user.userName = "";
		vm.user.password = "";
		vm.user.mobileNo = "";
		vm.user.email = "";
		vm.user.birthDate = "";
		
		/*registerService.checkuseravailability("manali")
		.success(function (data, status, headers, config) {
            vm.isAvailable = data.available;
        })
        .error(function (data, status, headers, config) {
            vm.isAvailable = false;
        });*/
		
		vm.validate = function() {
			if((vm.user.userName == undefined || vm.user.userName == "") == false) {
				if(vm.storedUserName != vm.user.userName) {
					vm.storedUserName = vm.user.userName;
					registerService.checkuseravailability(vm.user.userName)
					.then(function(success) {
						vm.isTaken = !success.data.available;
			            vm.isTakenError = false;
					}, function(error) {
						vm.isTaken = false;
			            vm.isTakenError = true;
					})
				}
			}
			else {
				vm.isTaken = false;
			}
		};
		
		vm.register = function() {
			if(vm.storedUserName != vm.user.userName) {
				registerService.checkuseravailability(vm.user.userName)
				.then(function(success) {
					vm.isTaken = !success.data.available;
		            vm.isTakenError = false;
				}, function(error) {
					vm.isTakenError = true;
				})
			}
			
			if(vm.isTakenError == false && vm.isTaken == false) {
				registerService.createuser(vm.user)
				.then(function(success) {
					vm.isUserCreated = success.data.isUserCreated;
				}, function(error) {
					
				})
				
			}
		}
		
		vm.cancel = function() {
			$state.go("studentsimple.login");
		}
	};
}());