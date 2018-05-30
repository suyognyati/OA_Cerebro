(function(){
	"use strict";
	angular
		.module("app")
		.run(["$state", "globalConstants", "$rootScope", rootScope]);
		
		function rootScope($state, globalConstants, $rootScope) {    	
	    	$rootScope.cookieName = "accessToken";
	    	$rootScope.cStudentName = "loggedInStudent";
	    	$rootScope.getDataDelay = 0;
	    	
	    	//This function will return access token param to pass in http calls
	    	$rootScope.getAccessTokenParam = function() {
	    		var accessTokenParam = $rootScope.getAccessTokenParamByStudentName($rootScope.getStudentName());
	    		return accessTokenParam;
	    	}
	    	
	    	//This will return access token
	    	$rootScope.getAccessToken = function() {
	    		var accessToken = $rootScope.getCookie($rootScope.getStudentName());
	    		return accessToken;
	    	}
	    	
	    	//This function will return access token param to pass in http calls
	    	//Here input param is student name which is cookie name.
	    	$rootScope.getAccessTokenParamByStudentName = function(cookieName) {
	    		var accessToken = $rootScope.getCookie(cookieName);
	    		var accessTokenParam = "?access_token=" + accessToken;
    			if(accessToken == null || accessToken == "") {
    				$state.go("studentsimple.login");
    			}
	    		
				return accessTokenParam;
			}
	    	
	    	//This function will give student name saved in cookie
	    	$rootScope.getStudentName = function() {
	    		var studentName = $rootScope.getCookie($rootScope.cStudentName);
	    		return studentName;
	    	}
	    	
	    	//This function will save student name in cookie
	    	$rootScope.setStudentName = function(cvalue, validity) {
	    		$rootScope.setCookie($rootScope.cStudentName, cvalue, validity);
	    	}
	    	
	    	//Function to save in cookie
	    	$rootScope.setCookie = function(cname, cvalue, validity) {
				var d = new Date();
			    d.setTime(d.getTime() + (validity*1000));
			    var expires = "expires="+ d.toUTCString();
			    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
			}
			
	    	//Function to get in cookie
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

}());
