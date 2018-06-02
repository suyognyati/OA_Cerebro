(function(){
	"use strict";
	angular
		.module("app")
		.controller("OccupationReservationCtrl",
					["$scope",
					 "$http",
					 "$state",
					 "$window",
					 "profileDetailService",
					 OccupationReservationCtrl]);

	function OccupationReservationCtrl($scope, $http, $state, $window, profileDetailService) {
		var vm = this;
		vm.occupationReservationTemp = {};

		vm.accessTokenParam = $scope.getAccessTokenParam();
		
		vm.multiSelectComboBoxSettings = {
			enableSearch: true,
			showSelectAll: true,
			showCheckAll: false,
			showUncheckAll: false,
			keyboardControls: true,
			idProperty: 'key',
			displayProp: 'value',
			selectedToTop: false,
			scrollable:true,
			styleActive: true,
			scrollableHeight: 250,
			//smartButtonMaxItems: 2,
			
			//template: '{{option.value}}',
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
			profileDetailService.getOccupationReservation(vm.accessTokenParam)
			.then(function (success) {
				vm.occupationandreservation = success.data;
				refreshSelectPickerWithDelay();
			}, function (error) {
				vm.occupationandreservation = {};
			})
			
		}

		vm.saveDraft = function() {
			profileDetailService.saveOccupationReservation(vm.occupationandreservation, vm.accessTokenParam)
			.then(function (success) {
				vm.successMessage = "Saved successfully";
			}, function (error) {
				vm.errorMessage = "Error while saving data";
			})

		}
		
		vm.submit = function() {
			profileDetailService.saveOccupationReservation(vm.occupationandreservation, vm.accessTokenParam)
			.then(function (success) {
				vm.successMessage = "Saved successfully";
				$state.go("student.profile.uploadPhotoSign");
			}, function (error) {
				vm.errorMessage = "Error while saving data";
			})

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
