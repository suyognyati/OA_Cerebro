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
		$scope.Math = Math;
		
		vm.search = {};
		
		vm.programId = $state.params.programId;
		vm.showWeightageTable = false;
		
		vm.itemPerPage = 10;		
		
		
		vm.getWeightage = function() {
			programService.getCategoryWeightage(vm.programId)
			.then(function(success){
				if(success.data != null) {
					vm.categoryWeightageList = success.data.categoryWeightageList;
					vm.programCategoryWeightageCount = success.data.programCategoryWeightageCount;
					vm.init(vm.categoryWeightageList);
				}
				else
					vm.categoryWeightageList = {};
				
			},function(error){
				vm.categoryWeightageList = {};
			})
		}
		
		vm.init = function() {
			
			vm.totalIntake = vm.programCategoryWeightageCount.weightage;
			/*angular.forEach(categoryWeightageList, function(categoryWeightage) {
				if(categoryWeightage.programCategoryWeightage.categoryName == 0) {
					vm.totalIntake = categoryWeightage.programCategoryWeightage.weightage;
				}
			});*/
			
			/*for(var categoryWeightage in categoryWeightageList) {
				if(categoryWeightage.programCategoryWeightage.categoryName == 0) {
					vm.totalIntake = categoryWeightage.programCategoryWeightage.weightage;
				}
			}*/
			
			
			
			/*var allCategory = {};
			allCategory.key = 0;
			allCategory.value = vm.labelForAllCategory;
			data.reservationList.splice(0, 0, allCategory);
			vm.categoryId = 0;
			
			angular.forEach(data.appliedStudentList, function(appliedStudent) {
				appliedStudent.fullName = appliedStudent.firstName + " " + appliedStudent.middleName + " " + appliedStudent.lastName;
				appliedStudent.categoryValue = vm.getCategoryValue(appliedStudent.category);
			});*/
		}
		
		vm.setCategoryWiseWeightage = function() {
			vm.showWeightageTable = true;
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
			var totalWeightage = 0;
			angular.forEach(vm.categoryWeightageList, function(categoryWeightage) {
				totalWeightage += categoryWeightage.programCategoryWeightage.weightage;
			});
			
			return totalWeightage;
		}
		
		vm.totalWeightagePercentage = function() {
			var totalWeightagePercentage = 0;
			angular.forEach(vm.categoryWeightageList, function(categoryWeightage) {
				totalWeightagePercentage += categoryWeightage.programCategoryWeightage.weightagePercentage;
			});
			
			return Math.round(totalWeightagePercentage);
		}
		
		setTimeout(function() {
			vm.getWeightage();
		}, $scope.getDataDelay);
	};
}());