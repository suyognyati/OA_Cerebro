(function(){
	"use strict";
	angular
		.module("app")
		.controller("CategoryWeightageCtrl",
					["$http",
					 "$state",
					 "$scope",
					 "programService",
					 CategoryWeightageCtrl]);
	
	function CategoryWeightageCtrl($http, $state, $scope, programService) {
		var vm = this;
		vm.data = {};
		vm.localdata = {};
		vm.localdata.totalWeightage = 0;
		vm.localdata.totalWeightagePercentage = 0;
		$scope.Math = Math;
		
		vm.search = {};
		
		vm.programId = $state.params.programId;
		vm.showWeightageTable = true;
		
		vm.itemPerPage = 10;		
		
		
		vm.getWeightage = function() {
			programService.getCategoryWeightage(vm.programId)
			.then(function(success){
				if(success.data != null) {
					vm.data = success.data;
					vm.init();
				}
				else
					vm.categoryWeightageList = {};
				
			},function(error){
				vm.categoryWeightageList = {};
			})
		}
		
		vm.init = function() {
			vm.totalIntake = vm.data.programCategoryWeightageCount.weightage;
			if(vm.totalIntake == null) {
				vm.showWeightageTable = false;
			}
			vm.data.programCategoryWeightageList = [];	//Defining array list
		}
		
		vm.setCategoryWiseWeightage = function() {
			vm.showWeightageTable = true;
		}
		
		vm.resetIntake = function() {
			vm.getWeightage();
			vm.showWeightageTable = false;
		}
		
		vm.weightageChanged = function(categoryWeightage) {
			categoryWeightage.programCategoryWeightage.weightagePercentage = 
				((categoryWeightage.programCategoryWeightage.weightage * 100) / vm.totalIntake);
			
			categoryWeightage.programCategoryWeightage.weightagePercentage = 
				parseFloat(categoryWeightage.programCategoryWeightage.weightagePercentage.toFixed(2));
				
		}
		
		vm.weightagePercentageChanged = function(categoryWeightage) {
			categoryWeightage.programCategoryWeightage.weightage = 
				((categoryWeightage.programCategoryWeightage.weightagePercentage * vm.totalIntake) / 100);
			
			categoryWeightage.programCategoryWeightage.weightage = 
				Math.floor(categoryWeightage.programCategoryWeightage.weightage + 0.5);
		}
		
		vm.totalWeightage = function () {
			vm.localdata.totalWeightage = 0;
			angular.forEach(vm.data.categoryWeightageList, function(categoryWeightage) {
				vm.localdata.totalWeightage += categoryWeightage.programCategoryWeightage.weightage;
			});
			
			return vm.localdata.totalWeightage;
			//return totalWeightage;
		}
		
		vm.totalWeightagePercentage = function() {
			vm.localdata.totalWeightagePercentage = 0;
			angular.forEach(vm.data.categoryWeightageList, function(categoryWeightage) {
				vm.localdata.totalWeightagePercentage += categoryWeightage.programCategoryWeightage.weightagePercentage;
			});
			
			return Math.round(vm.localdata.totalWeightagePercentage);
			//return Math.round(totalWeightagePercentage);
		}
		
		vm.submit = function() {
			if(vm.totalIntake == vm.localdata.totalWeightage && vm.localdata.totalWeightagePercentage == 100) {
				
				vm.data.programCategoryWeightageCount.weightage = vm.totalIntake;
				vm.data.programCategoryWeightageCount.weightagePercentage = 100;
				vm.setProgramCategoryWeightageList(vm.data.categoryWeightageList);
				
				var data = {};
				data.collegeProgramMap = vm.data.collegeProgramMap;
				data.programCategoryWeightageCount = vm.data.programCategoryWeightageCount;
				data.programCategoryWeightageList = vm.data.programCategoryWeightageList;
				
				programService.setCategoryWeightage(data)
				.then(function(success){
					if(success.data == true) {
						
					} else {
						
					}
				},function(error){
					vm.categoryWeightageList = {};
				})
			} else {
				alert("Weightage is not completely filled. Please fill it first");
			}
		}
		
		vm.setProgramCategoryWeightageList = function(categoryWeightage) {
			angular.forEach(vm.data.categoryWeightageList, function(categoryWeightage) {
				vm.data.programCategoryWeightageList.push(categoryWeightage.programCategoryWeightage);
			});
			
		}
		
		setTimeout(function() {
			vm.getWeightage();
		}, $scope.getDataDelay);
	};
}());