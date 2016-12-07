(function(){
	"use strict";
	angular
		.module("vendor")
		.controller("NewUserCtrl",
					["$http",
					 "$state",
					 "$rootScope",
					 "registerService",
					 NewUserCtrl]);
	
	function NewUserCtrl($http, $state, $rootScope, registerService) {
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
					.success(function (data, status, headers, config) {
			            vm.isTaken = !data.available;
			            vm.isTakenError = false;
			        })
			        .error(function (data, status, headers, config) {
			            vm.isTaken = false;
			            vm.isTakenError = true;
			        });
				}
			}
			else {
				vm.isTaken = false;
			}
		};
		
		vm.register = function() {
			if(vm.storedUserName != vm.user.userName) {
				registerService.checkuseravailability(vm.user.userName)
				.success(function (data, status, headers, config) {
		            vm.isTaken = !data.available;
		            vm.isTakenError = false;
		        })
		        .error(function (data, status, headers, config) {
		            vm.isTakenError = true;
		        });
			}
			
			if(vm.isTakenError == false && vm.isTaken == false) {
				registerService.createuser(vm.user)
				.success(function (data, status, headers, config) {
					vm.isUserCreated = data.isUserCreated;
				})
				.error(function (data, status, headers, config) {
					
				})
			}
		}
	};
}());