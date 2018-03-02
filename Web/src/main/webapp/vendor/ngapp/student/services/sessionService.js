(function(){
	"use strict";
	angular
		.module("app")
		.run(["$state", "globalConstants", "$rootScope", rootScope]);
		
		function rootScope($state, globalConstants, $rootScope) {    	
	    	$rootScope.cookieName = "accessToken";
	    	$rootScope.getDataDelay = 0;
	    	
	    	$rootScope.getAccessTokenParam = function() {
	    		if(globalConstants.accessToken == null || globalConstants.accessToken == "") {
	    			globalConstants.accessToken = $rootScope.getCookie($rootScope.cookieName);
	    			$rootScope.getDataDelay = 1000;
	    			if(globalConstants.accessToken == null || globalConstants.accessToken == "") {
	    				$state.go("studentsimple.login");
	    			}
	    		} else {
	    			$rootScope.getDataDelay = 0;
	    		}
				var accessTokenParam = "?access_token=" + globalConstants.accessToken;
				return accessTokenParam;
			}
	    	
	    	$rootScope.setAccessTokenParam = function(accessToken) {
	    		var cname = $rootScope.cookieName;
	    		var cvalue = accessToken;
	    		var exdays = 1;
				var d = new Date();
			    d.setTime(d.getTime() + (exdays*24*60*60*1000));
			    var expires = "expires="+ d.toUTCString();
			    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
			}	    	
	    	
	    	$rootScope.setCookie = function(cname, cvalue, exdays) {
				var d = new Date();
			    d.setTime(d.getTime() + (exdays*24*60*60*1000));
			    var expires = "expires="+ d.toUTCString();
			    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
			}
			
	    	$rootScope.getCookie = function(cname) {
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
		}
		/*.service("SessionService",
					["$scope",
					 "$http",
					 "$state",
					 "globalConstants",
					 SessionService]);

	function SessionService($scope, $http, $state, globalConstants) {
		var vm = this;
		
		getAccessTokenParam = function() {
			vm.accessTokenParam = "?access_token=" + globalConstants.accessTokenParam;
			return vm.accessTokenParam;
		}
	};*/
		
	

}());
