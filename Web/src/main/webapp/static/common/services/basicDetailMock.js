(function(){
	"use Strict";
	
	var app = angular
				.module("basicDetailMock",
						["ngMockE2E"]);
	
	app.run(function($httpBackend){
		var basicdetail = [
		    {
		    	"lastName": "Nyati",
		    	"firstName": "Manali",
		    	"middleName": "Suyog",
		    	"mothersName": "Kiran",
		    	"birthDate": "08Jun1989",
		    	"email": "er.manalirathi@gmail.com",
		    	"mobileNo": "7588436460",
		    	"otherContactNo": "9028912426"
		    }
		 ];
		
		var basicDetailUrl = "/Admission/basicDetail/getBasicDetail/"
		
		$httpBackend.whenGET(basicDetailUrl).respond(basicdetail);
	})
}());