(function(){
	"use strict";
	var app = angular
		.module("user", ["globalapp",
		                 "ui.router",
		                 "oc.lazyLoad",
		                 "ui.bootstrap"]);	
	
	app.constant('userConstants', {
	    userLocation : 'studentview/'
	});
		
}());