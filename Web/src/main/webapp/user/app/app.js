(function(){
	"use strict";
	var app = angular
		.module("user", ["globalapp",
		                 "ui.router",
		                 "oc.lazyLoad",
		                 "ui.bootstrap",
		                 "720kb.datepicker",
		                 /*"pmImageEditor",*/
		                 "ngImgCrop"]);	
	
	app.constant('userConstants', {
	    userLocation : 'user/'
	});
	
	app.directive('fileModel', ['$parse', function ($parse) {
	    return {
	        restrict: 'A',
	        link: function(scope, element, attrs) {
	            var model = $parse(attrs.fileModel);
	            var modelSetter = model.assign;
	            
	            element.bind('change', function(){
	                scope.$apply(function(){
	                    modelSetter(scope, element[0].files[0]);
	                });
	            });
	        }
	    };
	}]);
		
}());