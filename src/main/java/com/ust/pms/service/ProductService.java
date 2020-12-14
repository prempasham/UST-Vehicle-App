package com.ust.pms.service;

import java.util.List;

import com.ust.pms.model.Product;


public interface ProductService {
	public String saveProduct(Product product);
	public String updateProduct(Product product);
	public String deleteProduct(int productId);
	public List<Product> getProducts();
	public Product getProduct(int productId);
	public boolean isProductExists(int productId);
	public List<Product> getProductNames(String productName);
	public List<Product> getPrice(int price);
	public List<Product> getPriceGreaterThan(int price);

}
