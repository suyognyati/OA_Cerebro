var app = angular.module('app');

	app.directive('a', preventClickDirective);
	/*.directive('a', bootstrapCollapseDirective)*/
	/*.directive('a', navigationDirective)*/
	/*.directive('button', layoutToggleDirective)*/
	/*.directive('a', layoutToggleDirective)
	.directive('button', collapseMenuTogglerDirective)*/
	/*.directive('div', bootstrapCarouselDirective)
	.directive('toggle', bootstrapTooltipsPopoversDirective)
	.directive('tab', bootstrapTabsDirective)
	.directive('button', cardCollapseDirective)*/

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
	
	app.directive('loading',   ['$http' ,function ($http)  
		 {  
	     return {  
	         restrict: 'A',  
	         //template: '<div class="loader-overlay"></div><div class="loader"></div>',
	         //template: '<div class="loader-overlay"></div><div class="lds-ring"><div></div><div></div><div></div><div></div></div>',
	         template: '<div class="loader-overlay"></div><div class="lds-spinner"><div></div><div></div><div></div><div></div><div></div><div></div><div></div><div></div><div></div><div></div><div></div><div></div></div>',
	         //template: '<div class="loader-overlay"></div><div class="lds-ellipsis"><div></div><div></div><div></div><div></div></div>',
	         link: function (scope, elm, attrs)  
	         {  
	             scope.isLoading = function () {  
	                 return $http.pendingRequests.length > 0;  
	             };  
	  
	             scope.$watch(scope.isLoading, function (v)  
	             {  
	                 if(v){  
	                     elm.show();  
	                 }else{  
	                     elm.hide();  
	                 }  
	             });  
	         }  
	     };  
	 }]);
	
	app.directive('loaded',   ['$http' ,function ($http)  
		 {  
	     return {  
	         restrict: 'A',  
	         //template: '<div class="loading-spiner"><img src="http://www.nasa.gov/multimedia/videogallery/ajax-loader.gif" /> </div>',  
	         link: function (scope, elm, attrs)  
	         {  
	             scope.isLoading = function () {  
	                 return $http.pendingRequests.length > 0;  
	             };  
	  
	             scope.$watch(scope.isLoading, function (v)  
	             {  
	                 if(v){  
	                	 elm.hide();  
	                 }else{  
	                     elm.show();  
	                 }  
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
	
//Prevent click if href="#"
function preventClickDirective() {
	var directive = {
		restrict : 'E',
		link : link
	}
	return directive;

	function link(scope, element, attrs) {
		if (attrs.href === '#') {
			element.on('click', function(event) {
				event.preventDefault();
			});
		}
	}
}