(function(){
	"use strict";
	var app = angular
		.module("login", ["globalapp",
		                  "ui.router",
		                  "oc.lazyLoad",
		                  "ui.bootstrap"]);
	
	app.constant('loginConstants', {
	    loginLocation : 'login/'
	});
}());