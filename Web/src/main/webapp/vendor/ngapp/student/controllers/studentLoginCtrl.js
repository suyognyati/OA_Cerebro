(function(){
	"use strict";
	angular
		.module("app")
		.controller("StudentLoginCtrl",
					["$scope",
					 "$http",
					 "$state",
					 "$location",
					 "$window",
					 "studentLoginService",
					 "globalConstants",
					 ExistingUserCtrl]);
	
	function ExistingUserCtrl($scope, $http, $state, $location, $window, studentLoginService, globalConstants) {
		var vm = this;
		vm.username = "";
		vm.password = "";
		vm.error = false;
		
		vm.accessToken = "";
		vm.accessTokenParam = "";

		vm.basicAuth = {
			username : "", password : ""
		};

		vm.credentials = {
			username: "", password: ""
		};
			
		vm.isInvalidUser = false;
		
		vm.initialise = function() {
			vm.accessToken = $scope.getAccessToken();
			vm.accessTokenParam = $scope.getAccessTokenParam();
			vm.setUser();
		}
		
		vm.login = function() {
			vm.basicAuth.username = vm.credentials.username;
			vm.basicAuth.password = vm.credentials.password;
			var headers = vm.basicAuth ? {
				authorization : "Basic " + btoa(vm.basicAuth.username + ":" + vm.basicAuth.password)
			} : {};
			
			studentLoginService.getToken(headers, vm.credentials)
			.then(function (success){
				vm.accessToken = success.data.access_token;
				vm.accessTokenParam = "?access_token=" + vm.accessToken;				
				$scope.getDataDelay = 0;				
				vm.setUser();	//Setting loggedin user in backend and cookies 				
			},function (error){
				vm.accessToken = "";
    			vm.accessTokenParam = "";
			});
			
			vm.username = "";
		};
		
		vm.setUser = function() {
			studentLoginService.setUser(vm.accessTokenParam)
			.then(function (success){					
				vm.username = success.data.username;
				vm.tokenexpirein = success.data.tokenexpirein;
				$scope.setStudentName(vm.username, vm.tokenexpirein);
				$scope.setCookie($scope.getStudentName(), vm.accessToken, vm.tokenexpirein);					
				$state.go("student.dashboard");
			},function (error){
				
			});
		}
		
		vm.registerStudent = function() {
			$window.isInvalidUser = false;
			$window.isLoggedOutUser = false;
			$state.go("studentsimple.register");
		}
		
		//vm.initialise();
	};
}());