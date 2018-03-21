(function(){
	"use strict";
	angular
		.module("app")
		.controller("OccupationReservationCtrl",
					["$scope",
					 "$http",
					 "$state",
					 "$window",
					 "OccupationReservationService",
					 OccupationReservationCtrl]);

	function OccupationReservationCtrl($scope, $http, $state, $window, OccupationReservationService) {
		var vm = this;
		vm.occupationReservationTemp = {};

		vm.accessTokenParam = $scope.getAccessTokenParam();
		
		vm.multiSelectComboBoxSettings = {
			enableSearch: true,
			showSelectAll: true,
			showCheckAll: false,
			showUncheckAll: false,
			keyboardControls: true,
			//idProperty: 'key',
			//displayProp: 'value',
			selectedToTop: false,
			scrollable:true,
			styleActive: true,
			scrollableHeight: 250,
			//smartButtonMaxItems: 2,
			
			template: '{{option}}',
			smartButtonTextConverter: function(skip, option) { 
				return option; 
			},
			smartButtonTextProvider: function(selectionArray) { 
				return "Total selected categories : " + selectionArray.length; 
			}
		}
		vm.multiSelectComboBoxDefaultText = {
			buttonDefaultText: '-- Select Social Reservation Categories --'
		}

		vm.loadData = function () {
			OccupationReservationService.get(vm.accessTokenParam)
			.then(function (success) {
				vm.occupationandreservation = success.data;
				vm.initDefaults();
			}, function (error) {
				vm.occupationandreservation = {};
			})
			refreshSelectPickerWithDelay();
		}

		vm.submit = function() {
			OccupationReservationService.save(vm.occupationandreservation, vm.accessTokenParam)
			.then(function (success) {
				vm.successMessage = "Saved successfully";
				$state.go("student.profile.uploadPhotoSign");
			}, function (error) {
				vm.errorMessage = "Error while saving data";
			})

		}
		
		vm.initDefaults = function() {
			/*vm.occupationandreservation.socialReservations = [
     			{key:1, value:"Ex-Serviceman/Ward of Ex-Serviceman"},
     			{key:2, value:"Active Serviceman/Ward of Active Serviceman"},
     			{key:3, value:"Freedom Fighter/Ward of Freedom Fighter"},
     			{key:4, value:"Member of Project Affected Family"},
     			{key:5, value:"Member of Flood/Famine Affected Family"},
     			{key:6, value:"Resident of Disputed Boundary Area"},
     			{key:7, value:"Below Poverty Line Student"},
     			{key:8, value:"Ward of Transferred Central/State Government Employee"},
     			{key:9, value:"Ward of Primary Teacher"},
     			{key:10, value:"Ward of Secondary Teacher"},
     			{key:11, value:"Deserted/Divorced/Widowed Women"},
     			{key:12, value:"Member of Earthquake Affected Family"},
     			{key:13, value:"Resident of Tribal Area"},
     			{key:14, value:"Kashmir Migrant"},
     			{key:15, value:"Teacher in 'Innovative School'"},
     			{key:16, value:"University Staff Quota"}
     		];*/
			vm.occupationandreservation.socialReservations = [
       			"Ex-Serviceman/Ward of Ex-Serviceman",
       			"Active Serviceman/Ward of Active Serviceman",
       			"Freedom Fighter/Ward of Freedom Fighter",
       			"Member of Project Affected Family",
       			"Member of Flood/Famine Affected Family",
       			"Resident of Disputed Boundary Area",
       			"Below Poverty Line Student",
       			"Ward of Transferred Central/State Government Employee",
       			"Ward of Primary Teacher",
       			"Ward of Secondary Teacher",
       			"Deserted/Divorced/Widowed Women",
       			"Member of Earthquake Affected Family",
       			"Resident of Tribal Area",
       			"Kashmir Migrant",
       			"Teacher in 'Innovative School'",
       			"University Staff Quota"
       		];
			
			vm.occupationandreservation.selectedSocialReservations = [];
			
			vm.occupationandreservation.selectedSocialReservationsArray = [];
			vm.occupationandreservation.selectedSocialReservationsToDisplay = "";
		}
		
		vm.selectedItem = function(item) {
			vm.occupationandreservation.selectedSocialReservationsToDisplay = 
				vm.occupationandreservation.selectedSocialReservations.toString();
		}
		
		vm.multiSelectEvents = {
				onInitDone: function(item) {
                	console.log(item);
                },
                onItemSelect: function(item) {
                	vm.selectedItem(item);
				},
                onItemDeselect: function(item) {
                	console.log(item);
				}
        };
		
		setTimeout(function() {
		    vm.loadData();
		}, $scope.getDataDelay);
	};
}());
