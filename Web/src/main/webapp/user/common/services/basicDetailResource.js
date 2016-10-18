(function(){
	"use strict";
	
	angular
		.module("common.services")
		.factory("basicDetailResource",
					["$resource",
					 basicDetailResource]);
		
		function basicDetailResource($resource){
			return $resource("/Web/basicDetail/getBasicDetail/")
		}
}());