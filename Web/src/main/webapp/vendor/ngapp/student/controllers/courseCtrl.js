(function(){
	"use strict";
	angular
		.module("app")
		.controller("SubjectCtrl",
					["$scope",
					 "$http",
					 "$state",
					 "$window",
					 "$filter",
					 "applyOnlineService",
					 SubjectCtrl]);

	function SubjectCtrl($scope, $http, $state, $window, $filter, applyOnlineService) {
		var vm = this;
		
		var cgLevel = {};
		cgLevel.subjectCountUnderLevelOne = 0;
		cgLevel.subjectCountUnderLevelTwo = 0;
		cgLevel.subjectCountUnderLevelThree = 0;
		cgLevel.subjectCountUnderLevelFour = 0;
		cgLevel.subjectCountUnderLevelFive = 0;
		
		vm.collegeProgramId = $state.params.collegeProgramId;
		vm.selectedAllowedQualification = $state.params.selectedAllowedQualification;
		vm.programName = $state.params.programName;
		vm.programCode = $state.params.programCode;

		vm.accessTokenParam = $scope.getAccessTokenParam();

		vm.minimumSubjects = 6;
		vm.maximumSubjects = 6;
		vm.selectedSubjects = 0;
		vm.selectedSubjectList = [];
		vm.canSelect = true;
		vm.incrementRequired = true;
		vm.selectionNotAllowedMessage = "";
		vm.isSubjectSelectionCompleted = false;

		vm.getCourseDetail = function () {
			applyOnlineService.getSubjects(vm.collegeProgramId, vm.accessTokenParam)
			.then(function(success) {
				vm.subjects = success.data;
				vm.initialise();
			}, function(error) {
				vm.subjects = {};
			})
		}


		vm.initialise = function() {
			var cgLevelOneList = vm.subjects.courseGroupLevelOneList;
			angular.forEach(cgLevelOneList, function(itemLevelOne) {
				cgLevel.subjectCountUnderLevelOne = 0;
				itemLevelOne.selectedCount = 0;
				itemLevelOne.isSelected = false;
				vm.calculateAvailableSubjectCount(itemLevelOne);

				angular.forEach(itemLevelOne.cgLevelTwoList, function(itemLevelTwo) {
					cgLevel.subjectCountUnderLevelTwo = 0;
					itemLevelTwo.selectedCount = 0;
					itemLevelTwo.isSelected = false;
					vm.calculateAvailableSubjectCount(itemLevelTwo);

					angular.forEach(itemLevelTwo.cgLevelThreeList, function(itemLevelThree) {
						cgLevel.subjectCountUnderLevelThree = 0;
						itemLevelThree.selectedCount = 0;
						itemLevelThree.isSelected = false;
						vm.calculateAvailableSubjectCount(itemLevelThree);

						angular.forEach(itemLevelThree.cgLevelFourList, function(itemLevelFour) {
							cgLevel.subjectCountUnderLevelFour = 0;
							itemLevelFour.selectedCount = 0;
							itemLevelFour.isSelected = false;
							vm.calculateAvailableSubjectCount(itemLevelFour);

							angular.forEach(itemLevelFour.cgLevelFiveList, function(itemLevelFive) {
								cgLevel.subjectCountUnderLevelFive = 0;
								itemLevelFive.selectedCount = 0;
								itemLevelFive.isSelected = false;
								vm.calculateAvailableSubjectCount(itemLevelFive);

								angular.forEach(itemLevelFive.subjectList, function(subjectLevelFive) {
									subjectLevelFive.subject.selectedCount = 0;
									subjectLevelFive.subject.isSelected = false;
								});								
								cgLevel.subjectCountUnderLevelFour += 
									vm.calculateAvailableSubjectCountUnderLevel(itemLevelFive, cgLevel.subjectCountUnderLevelFive);
							});

							angular.forEach(itemLevelFour.subjectList, function(subjectLevelFour) {
								subjectLevelFour.subject.selectedCount = 0;
								subjectLevelFour.subject.isSelected = false;
							});
							cgLevel.subjectCountUnderLevelThree += 
								vm.calculateAvailableSubjectCountUnderLevel(itemLevelFour, cgLevel.subjectCountUnderLevelFour);
						});

						angular.forEach(itemLevelThree.subjectList, function(subjectLevelThree) {
							subjectLevelThree.subject.selectedCount = 0;
							subjectLevelThree.subject.isSelected = false;
						});
						cgLevel.subjectCountUnderLevelTwo += 
							vm.calculateAvailableSubjectCountUnderLevel(itemLevelThree, cgLevel.subjectCountUnderLevelThree);
					});

					angular.forEach(itemLevelTwo.subjectList, function(subjectLevelTwo) {
						subjectLevelTwo.subject.selectedCount = 0;
						subjectLevelTwo.subject.isSelected = false;
					});
					cgLevel.subjectCountUnderLevelOne += 
						vm.calculateAvailableSubjectCountUnderLevel(itemLevelTwo, cgLevel.subjectCountUnderLevelTwo);
				});

				angular.forEach(itemLevelOne.subjectList, function(subjectLevelOne) {
					subjectLevelOne.subject.selectedCount = 0;
					subjectLevelOne.subject.isSelected = false;
				});
				vm.calculateAvailableSubjectCountUnderLevel(itemLevelOne, cgLevel.subjectCountUnderLevelOne);

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
				vm.removeSubject(subject, cgLevel1)
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
			} else {
				var isAdded = false;
				vm.selectedSubjectList.forEach(function (element) {
				    if (JSON.stringify(element) === JSON.stringify(subject)) {
				    	isAdded = true;
				    } else {
				    	isAdded = false;
				    }
				});

				if(!isAdded) {
					subject.sequenceNo = cgLevel.sequenceNo;
					vm.selectedSubjectList.push(subject);
				}
				vm.selectedSubjects ++;
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

		vm.removeSubject = function(subject, cgLevel) {
			vm.reduceCount(cgLevel);
			var index = vm.selectedSubjectList.indexOf(subject);
			vm.selectedSubjectList.splice(index, 1);
			delete subject.sequenceNo;
			vm.selectedSubjects --;
		}

		vm.reduceCount = function(cgLevel) {
			if(cgLevel == null)
				return;

			vm.reduceCount(cgLevel.cgLevel);

			if(cgLevel.selectedCount > 0)
				cgLevel.selectedCount --;
		}

		vm.deleteTemporaryData = function(cgLevel) {
			if(cgLevel == null)
				return;
			delete cgLevel.cgLevel;
		}

		vm.showSelectedSubjects = function(showSelectedSubjects) {
			if(showSelectedSubjects && vm.selectedSubjects < vm.minimumSubjects) {
				alert("You have selected only " + vm.selectedSubjects +
						" subjects. Please select minimum " + vm.minimumSubjects + " subjects");
				return;
			}
			vm.isSubjectSelectionCompleted = showSelectedSubjects;
		}
		
		vm.calculateAvailableSubjectCountUnderLevel = function (cgLevel, countUnderThisLevel) {
			cgLevel.availableSubjectCountUnderLevel = countUnderThisLevel + cgLevel.availableSubjectCountOfLevel;
			return cgLevel.availableSubjectCountUnderLevel;
		}
		
		vm.calculateAvailableSubjectCount = function(item) {
			item.availableSubjectCountOfLevel = item.subjectList.length;
			var len = item.subjectList.length;
			for(var i = 0; i < len; i++) {
				if(!vm.isSubjectAvailableInCollege(item.subjectList[i].subject)) {
					item.availableSubjectCountOfLevel --;
				}
			}
		}
		
		vm.isSubjectAvailableInCollege = function (subject) {
			var subjectList = vm.subjects.subjectListOfCollege;
			var currentSubjectId = subject.universitySubjectId;
			var tempSubject = $filter("filter")(subjectList, {universitySubjectId:currentSubjectId});
			if(tempSubject != null && tempSubject.length > 0)
				return true;
			else {
				return false;
			}
		}

		vm.applyForCourse = function() {
			applyOnlineService.applyForCourse(vm.collegeProgramId, vm.selectedSubjectList, vm.selectedAllowedQualification, vm.accessTokenParam)
			.then(function(success) {
				$state.go("student.application.applicationStatus")
			}, function(error) {
			})
			
		}
		
		setTimeout(function() {
			vm.getCourseDetail();
		}, $scope.getDataDelay);
	};
}());
