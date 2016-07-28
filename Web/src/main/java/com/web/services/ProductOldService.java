package com.web.services;

import java.util.ArrayList;
import java.util.List;

import com.data.entities.Product;

public class ProductOldService {

	public List<Product> getProducts() {
		List<Product> products = new ArrayList<>();
		
		Product p1 = new Product();
		p1.setProductId(1);
		p1.setProductName("pencil");
		p1.setProductCode("P-12381");
		p1.setReleaseDate("12-July-2015");
		p1.setDescription("School stationary");
		p1.setCost(10);
		p1.setPrice(16);
		p1.setCategory("Stationary");
		p1.setTags("Stationary");
		p1.setImageUrl("http://pix.iemoji.com/images/emoji/apple/ios-9/256/lower-left-pencil.png");
		products.add(p1);
		
		Product p2 = new Product();
		p2.setProductId(2);
		p2.setProductName("rubber");
		p2.setProductCode("R-24131");
		p2.setReleaseDate("2-July-2015");
		p2.setDescription("School stationary");
		p2.setCost(10);
		p2.setPrice(16);
		p2.setCategory("Stationary");
		p2.setTags("Stationary");
		p2.setImageUrl("https://ctrlq.org/google/images/img/loading.svg");
		products.add(p2);
		
		Product p3 = new Product();
		p3.setProductId(3);
		p3.setProductName("compass");
		p3.setProductCode("P-31911");
		p3.setReleaseDate("1-Sep-2015");
		p3.setDescription("School stationary");
		p3.setCost(10);
		p3.setPrice(16);
		p3.setCategory("Stationary");
		p3.setTags("Stationary");
		p3.setImageUrl("http://findicons.com/files/icons/2767/travel_and_vacation/128/compass.png");
		products.add(p3);
		
		return products;
	}
}
