(function(){
	"use strict";
	var app = angular
		.module("vendor", ["globalapp",
		                 "ui.router",
		                 "oc.lazyLoad",
		                 "ui.bootstrap"]);	
	
	app.constant('vendorConstants', {
	    vendorLocation : 'vendor/'
	});
		
}());