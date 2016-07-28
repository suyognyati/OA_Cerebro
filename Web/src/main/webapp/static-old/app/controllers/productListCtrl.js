(function () {
	"use strict"
	angular
		.module("productmanagement")
		.controller("ProductListCtrl", 
					["$http", "productResource", ProductListCtrl]);
	
	function ProductListCtrl($http, productResource) {
		var vm = this;
		/*$http({
			method: 'GET',
			url: '/WebAdmission/productlist/'
		})
		.success(function(data){
			vm.products = data;
		});*/
		/*$http.get('/WebAdmission/productlist/').
		success(function(data){
			vm.products = data;
		});*/
		
		productResource.query(function(data) {
			vm.products = data;
		});
		
		
		vm.showImages = false;
		vm.toggleImage = function() {
			vm.showImages = !vm.showImages;
		}
	}
})();