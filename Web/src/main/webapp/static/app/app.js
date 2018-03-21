(function(){
	"use strict";
	var app = angular
		.module("globalapp", ['ui.router']);	
	
	app.constant('globalConstants', {
	    rootLocation : '/Web/',
	    accessToken : "",
		accessTokenParam : ""
	});
	
}());