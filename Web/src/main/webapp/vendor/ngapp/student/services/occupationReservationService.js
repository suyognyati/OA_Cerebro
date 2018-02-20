(function(){
	"use strict";
	angular
		.module("app")
		.factory("OccupationReservationService",
					["$http",
					 OccupationReservationService]);

	function OccupationReservationService($http) {
		return {
			get : function(accessTokenParam) {
				return $http({
					method: "GET",
					url: "/Web/rest/occupationreservation/get/" + accessTokenParam
				})
			},
			save: function (occupationReservation, accessTokenParam) {
				return $http({
                    method: 'POST',
                    url: '/Web/rest/occupationreservation/save/' + accessTokenParam,
                    data: occupationReservation
                });
            }
		}
	};
}());
