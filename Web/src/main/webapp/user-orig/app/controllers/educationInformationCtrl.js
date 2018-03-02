(function(){
	"use strict";
	angular
		.module("user")
		.controller("EducationInformationCtrl",
					["$http",
					 "$window",
					 "$state",
					 "educationInformationService",
					 EducationInformationCtrl]);
	
	function EducationInformationCtrl($http, $window, $state, educationInformationService) {
		
		var vm = this;	
		vm.qualificationList = [];
		if($state.params.success != null)
			vm.success = $state.params.success;
		
		vm.accessToken = $window.bearer_token;
		vm.accessTokenParam = "?access_token=" + vm.accessToken;

		educationInformationService.getListofQualification(vm.accessTokenParam)
		.success(function (data, status, headers, config) {
			vm.qualificationList = data;
			/*vm.listofQualification = data;
			angular.forEach(vm.listofQualification, function(value, key) {
				if(value.subQualificationList == null) {
					vm.qualificationList.push(value);
				}
				else {
					angular.forEach(value.subQualificationList, function(childvalue, key) {
						childvalue.qualificationMainLevel = value.qualificationMainLevel;
						vm.qualificationList.push(childvalue);
					});
				}
			});
			vm.listofQualification = null;*/
		})
		.error(function (data, status, headers, config) {
			vm.qualificationList = data;
			/*vm.listofQualification = {};*/
        });
		
		vm.qualificationDetail = function(qualificationMainLevel, qualificationId) {
			var view = mapView(qualificationMainLevel);
						
			$state.go("studentStatus.qualificationDetail", {qualification:view ,qualificationMainLevel:qualificationMainLevel, qualificationId:qualificationId});
		}
		
		vm.createNewQualification = function(qualificationMainLevel, qualificationSubLevel) {
			var view = mapView(qualificationMainLevel);						
			$state.go("studentStatus.qualificationDetail", {qualification:view ,qualificationMainLevel:qualificationMainLevel, qualificationSubLevel:qualificationSubLevel, newQualification:true});
		}
		
		vm.deleteQualification = function(qualificationId, qualificationName) {
			var qualificationNameTemp; 
			if(qualificationName != null && qualificationName != "") {
				qualificationNameTemp = "details of " + qualificationName;
			}
			var confirmation = confirm("Are you sure to delete " + qualificationNameTemp);
			if(confirmation == true) {
				educationInformationService.deleteQualification(qualificationId, vm.accessTokenParam)
				.success(function (data, status, headers, config) {
					vm.returnstatus = data;
					if(vm.returnstatus != null && vm.returnstatus.success == true) {
						$state.reload("studentStatus.educationInformation", {success: false});
					} else {
						$window.scrollTo(0, 0);
					}
				})
				.error(function (data, status, headers, config) {
					
		        });
			}
		}
		
		var mapView = function(qualificationMainLevel) {
			var view = "";
			if(qualificationMainLevel == 1)
				view = "ssc";
			else if(qualificationMainLevel == 2)
				view = "11th";
			else if(qualificationMainLevel == 3)
				view = "hsc";
			else if(qualificationMainLevel == 4)
				view = "diploma";
			
			return view;
		} 
	};
	
}());