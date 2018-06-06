(function(){
	"use strict";
	angular
		.module("app")
		.controller("GenerateMeritListCtrl",
					["$http",
					 "$state",
					 "$scope",
					 "generateMeritListService",
					 GenerateMeritListCtrl]);
	
	function GenerateMeritListCtrl($http, $state, $scope, generateMeritListService) {
		var vm = this;
		
		vm.search = {};
		
		vm.programId = $state.params.programId;
		vm.programCategoryId = $state.params.programLevelId;
		
		vm.itemPerPage = 10;		
		vm.labelForAllCategory = "All";
		
		
		vm.getMeritList = function() {
			generateMeritListService.getMeritList(vm.programId)
			.then(function(success){
				vm.data = success.data;
				vm.init(vm.data);
			},function(error){
				vm.data = {};
			})
		}
		
		vm.init = function(data) {
			var allCategory = {};
			allCategory.key = 0;
			allCategory.value = vm.labelForAllCategory;
			data.reservationList.splice(0, 0, allCategory);
			vm.categoryId = 0;
			
			angular.forEach(data.appliedStudentList, function(appliedStudent) {
				appliedStudent.fullName = appliedStudent.firstName + " " + appliedStudent.middleName + " " + appliedStudent.lastName;
				appliedStudent.categoryValue = vm.getCategoryValue(appliedStudent.category);
			});
		}
		
		vm.getCategoryValue = function(key) {
			var categoryValue = "";
			angular.forEach(vm.data.reservationList, function(reservation) {
				if(reservation.key == key) {
					categoryValue = reservation.value;
				}
			});
			return categoryValue;
		}
		
		vm.showByCategory = function() {
			if(vm.categoryId == 0)
				vm.search.category = "";
			else
				vm.search.category = vm.categoryId;
		}
		
		vm.backToPrograms = function() {
			$state.go("collegeadmin.selectProgram");
		}
		
		vm.studentModal = function(studentId) {
			$state.go("collegeadmin.meritList.profile",{studentId:studentId});
			vm.showButton = false;
		}
		
		vm.studentModalEducationInformation = function(studentId){
			$state.go("collegeadmin.meritList.educationalDetail",{studentId:studentId});
			vm.showButton = true;
		}
		
		setTimeout(function() {
			vm.getMeritList();
		}, $scope.getDataDelay);
	};
}());