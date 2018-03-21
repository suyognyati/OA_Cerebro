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
			username : "",
			password : ""
		};

		vm.credentials = {
		        username: "", 
		        password: ""
		};
			
		vm.isInvalidUser = false;
		
		vm.login = function() {
			vm.basicAuth.username = vm.credentials.username;
			vm.basicAuth.password = vm.credentials.password;
			var headers = vm.basicAuth ? {
				authorization : "Basic "
						+ btoa(vm.basicAuth.username + ":"
								+ vm.basicAuth.password)
			} : {};
			
			studentLoginService.getToken(headers, vm.credentials)
			.then(function (success){
				
				$scope.setAccessTokenParam(success.data.access_token);
				vm.accessTokenParam = $scope.getAccessTokenParam();
				$scope.getDataDelay = 0;
				
				studentLoginService.setUser(vm.accessTokenParam)
				.then(function (success){
					/*var currenturl = $location.$$absUrl;
					var baseurl = currenturl.split("#");
					var userpageurl = baseurl[0] + "user/";
					$window.location.href = userpageurl;*/
					$state.go("student.dashboard");
				},function (error){
					
				});
			},function (error){
				vm.accessToken = "";
    			vm.accessTokenParam = "";
			});
			
			vm.username = "";
		};
		
		vm.registerStudent = function() {
			$window.isInvalidUser = false;
			$window.isLoggedOutUser = false;
			$state.go("studentSimple.register");
		}
		
		vm.setCookie = function(cname, cvalue, exdays) {
			var d = new Date();
		    d.setTime(d.getTime() + (exdays*24*60*60*1000));
		    var expires = "expires="+ d.toUTCString();
		    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
		}
		
		vm.getCookie = function(cname) {
		    var name = cname + "=";
		    var decodedCookie = decodeURIComponent(document.cookie);
		    var ca = decodedCookie.split(';');
		    for(var i = 0; i < ca.length; i++) {
		        var c = ca[i];
		        while (c.charAt(0) == ' ') {
		            c = c.substring(1);
		        }
		        if (c.indexOf(name) == 0) {
		            return c.substring(name.length, c.length);
		        }
		    }
		    return "";
		}
	};
}());