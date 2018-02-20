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
	
	app.directive('validPasswordC', function() {
		return {
			require: 'ngModel',
			scope: {
			      reference: '=validPasswordC'
			},
			link: function(scope, elm, attrs, ctrl) {
				ctrl.$parsers.unshift(function(viewValue, $scope) {
					var noMatch = viewValue != scope.reference
					ctrl.$setValidity('noMatch', !noMatch);
					return (noMatch)?noMatch:!noMatch;
				});
				scope.$watch("reference", function(value) {;
					ctrl.$setValidity('noMatch', value === ctrl.$viewValue);
				});
			}
		}
	});
		
}());