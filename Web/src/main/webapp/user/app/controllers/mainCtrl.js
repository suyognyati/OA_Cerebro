(function(){
	"use strict";
	angular
		.module("user")
		.controller("mainController",
					["$rootScope",
					 "$scope",
					 "$state",
					 mainController]);
	
	function mainController($rootScope, $scope, $state) {
		var tab = this;
		
		$scope.tabs = [
		    { heading: "Basic Details", route:"basicDetail", active:false },
		   	{ heading: "Personal Details", route:"personalDetail", active:false },
		   	{ heading: "Education Details", route:"educationInformation", active:false },
		   	{ heading: "Family Information", route:"familyInformation", active:false },
		   	{ heading: "Other Information", route:"otherInformation", active:false },
		   	{ heading: "Upload Documents", route:"#", active:false },
		   	{ heading: "Apply Courses", route:"#", active:false },
		];
		   	 
		$scope.go = function(route){
		    $state.go(route);
		};
		   	 
		$scope.active = function(route){
		    return $state.is(route);
		};
		  	 
		$scope.$on("$stateChangeSuccess", function() {
		    $scope.tabs.forEach(function(tab) {
		    tab.active = $scope.active(tab.route);
		    })
		});
	};
}());