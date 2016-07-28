package com.web.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.data.entities.Product;
import com.data.repository.ProductJpaRepository;

@RestController
public class productListController {

	/*@Autowired
	private ProductService productService;*/
	
	@Autowired
	private ProductJpaRepository productJpaRepository;
	
	@RequestMapping(value="/productlist", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getProducts(Model model) {
		List<Product> products = new ArrayList<>();
		
		//products = productService.findAllProducts();
		
		products = productJpaRepository.findAll();
		
		System.out.println("Returning products - \n");
		for (Product product : products) {
			System.out.println(product.getProductName() + "\n");
		}
		
		/*ProductOldService productService = new ProductOldService();
		products = productService.getProducts();
		
		System.out.println("Returning products - \n");
		for (Product product : products) {
			System.out.println(product.getProductName() + "\n");
		}*/
		
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
}
