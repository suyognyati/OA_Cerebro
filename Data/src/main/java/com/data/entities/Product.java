package com.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name="products")
@NamedQueries({
	@NamedQuery(name=Product.FIND_ALL_PRODUCTS, query="Select p from Product p")			
	
})
//@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product /*implements Serializable */{
	//private static final long serialVersionUID = 1L;

	public static final String FIND_ALL_PRODUCTS = "findAllProducts";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="productId")
	private int productId;

	@Column(name="category")
	private String category;

	@Column(name="cost")
	private float cost;

	@Column(name="description")
	private String description;

	@Column(name="imageUrl")
	private String imageUrl;

	@Column(name="price")
	private float price;

	@Column(name="productCode")
	private String productCode;

	@Column(name="productName")
	private String productName;

	@Column(name="releaseDate")
	private String releaseDate;

	@Column(name="tags")
	private String tags;

	public Product() {
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return this.cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getProductCode() {
		return this.productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getTags() {
		return this.tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

}