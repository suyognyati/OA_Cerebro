(function(){
	"use strict";
	var app = angular
		.module("user", ["globalapp",
		                 "ui.router",
		                 "oc.lazyLoad",
		                 "ui.bootstrap",
		                 "720kb.datepicker",
		                 "angularUtils.directives.dirPagination",
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
	

	app.filter('orderObjectBy', function() {
		return function(input, attribute) {
			if (!angular.isObject(input))
				return input;

			var array = [];
			for ( var objectKey in input) {
				array.push(input[objectKey]);
			}

			array.sort(function(a, b) {
				a = parseInt(a[attribute]);
				b = parseInt(b[attribute]);
				return a - b;
			});
			return array;
		}
	});
		
}());