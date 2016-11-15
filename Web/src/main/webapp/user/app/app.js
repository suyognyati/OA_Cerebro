(function(){
	"use strict";
	var app = angular
		.module("user", ["globalapp",
		                 "common.services",
		                 "ui.router",
		                 "oc.lazyLoad",
		                 "ui.bootstrap"]);	
	
	app.constant('userConstants', {
	    userLocation : 'user/'
	});
		
}());