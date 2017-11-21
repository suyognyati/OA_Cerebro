(function(){
	"use strict";
	angular
		.module("user")
		.controller("SubjectCtrl",
					["$http",
					 "$state",
					 "$window",
					 "subjectService",
					 SubjectCtrl]);
	
	function SubjectCtrl($http, $state, $window, subjectService) {
		var vm = this;
		
		vm.programId = $state.params.programId;
		vm.programName = $state.params.programName;
		vm.programCode = $state.params.programCode;
		
		vm.accessToken = $window.bearer_token;
		vm.accessTokenParam = "?access_token=" + vm.accessToken;
		
		vm.minimumSubjects = 6;
		vm.maximumSubjects = 6;
		vm.selectedSubjects = 0;
		vm.canSelect = true;
		vm.incrementRequired = true;
		vm.selectionNotAllowedMessage = "";
		
		subjectService.getSubjects(vm.programId, vm.accessTokenParam)
		.success(function(data, status, header, config) {
			vm.subjects = data;
			vm.initialise();
			
		})
		.error(function(data, status, header, config) {
			vm.subjects = {};
		});
		
		vm.initialise = function() {
			var cgLevelOneList = vm.subjects.courseGroupLevelOneList;
			angular.forEach(cgLevelOneList, function(itemLevelOne) {
				itemLevelOne.selectedCount = 0;
				itemLevelOne.isSelected = false;
				
				angular.forEach(itemLevelOne.cgLevelTwoList, function(itemLevelTwo) {
					itemLevelTwo.selectedCount = 0;
					itemLevelTwo.isSelected = false;
					
					angular.forEach(itemLevelTwo.cgLevelThreeList, function(itemLevelThree) {
						itemLevelThree.selectedCount = 0;
						itemLevelThree.isSelected = false;
						
						angular.forEach(itemLevelThree.cgLevelFourList, function(itemLevelFour) {
							itemLevelFour.selectedCount = 0;
							itemLevelFour.isSelected = false;
							
							angular.forEach(itemLevelFour.cgLevelFiveList, function(itemLevelFive) {
								itemLevelFive.selectedCount = 0;
								itemLevelFive.isSelected = false;
								
								angular.forEach(itemLevelFive.subjectList, function(subjectLevelFive) {
									subjectLevelFive.subject.selectedCount = 0;
									subjectLevelFive.subject.isSelected = false;
								});
							});
							
							angular.forEach(itemLevelFour.subjectList, function(subjectLevelFour) {
								subjectLevelFour.subject.selectedCount = 0;
								subjectLevelFour.subject.isSelected = false;
							});
						});
						
						angular.forEach(itemLevelThree.subjectList, function(subjectLevelThree) {
							subjectLevelThree.subject.selectedCount = 0;
							subjectLevelThree.subject.isSelected = false;
						});
					});
					
					angular.forEach(itemLevelTwo.subjectList, function(subjectLevelTwo) {
						subjectLevelTwo.subject.selectedCount = 0;
						subjectLevelTwo.subject.isSelected = false;
					});
				});
				
				angular.forEach(itemLevelOne.subjectList, function(subjectLevelOne) {
					subjectLevelOne.subject.selectedCount = 0;
					subjectLevelOne.subject.isSelected = false;
				});
				
			});
		}

		vm.checked = function(subject, cgLevel1, cgLevel2, cgLevel3, cgLevel4, cgLevel5) {
			
			if(cgLevel1 != null)
				cgLevel1.cgLevel = cgLevel2;
			if(cgLevel2 != null)
				cgLevel1.cgLevel.cgLevel = cgLevel3;
			if(cgLevel3 != null)
				cgLevel1.cgLevel.cgLevel.cgLevel = cgLevel4;
			if(cgLevel4 != null)
				cgLevel1.cgLevel.cgLevel.cgLevel.cgLevel = cgLevel5;
			if(cgLevel5 != null)
				cgLevel1.cgLevel.cgLevel.cgLevel.cgLevel.cgLevel = null;
			
			//Add or remove subject
			if(subject.isSelected) {
				vm.addSubject(subject, cgLevel1);
			} else {
				vm.removeSubject(cgLevel1)
			}
			
			//Remove temporary variables			
			vm.deleteTemporaryData(cgLevel1);
		}
		
		vm.addSubject = function(subject, cgLevel) {
			if(vm.selectedSubjects < vm.maximumSubjects) {
				vm.canSelect = true;
				vm.selectionNotAllowedMessage = "";
				vm.isAllowed(cgLevel);
			} else {
				vm.canSelect = false;
				vm.selectionNotAllowedMessage = "Maximum " + vm.maximumSubjects + " papers can be selected";
			}
			subject.isSelected = vm.canSelect;
			if(!vm.canSelect) {
				alert(vm.selectionNotAllowedMessage);
			}
		}
		
		vm.isAllowed = function(cgLevel) {
			/**
			 * Checking selection is allowed or not
			 */
			if(cgLevel != null) {
				if(cgLevel.selectedCount >= cgLevel.maxAllowedCourses) {				
					vm.canSelect = false;
					vm.selectionNotAllowedMessage = "You have already selected " + cgLevel.maxAllowedCourses + " paper for '" + cgLevel.name + "' which is the maximum limit";
				}
			}
			if(cgLevel == null || vm.canSelect == false)
				return;
			vm.isAllowed(cgLevel.cgLevel);
			/**
			 * Incrementing selected count of all corresponding 
			 * group if subject is allowed to select
			 */
			if(vm.canSelect)
				cgLevel.selectedCount ++;
			
			return;
		}
		
		vm.removeSubject = function(cgLevel) {
			if(cgLevel == null)
				return;
			
			vm.removeSubject(cgLevel.cgLevel);
			
			if(cgLevel.selectedCount > 0)
				cgLevel.selectedCount --;
		}
	
		vm.deleteTemporaryData = function(cgLevel) {
			if(cgLevel == null)
				return;
			delete cgLevel.cgLevel;
		}
	};
}());