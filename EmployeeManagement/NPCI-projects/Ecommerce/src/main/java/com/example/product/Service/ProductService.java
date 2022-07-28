package com.example.product.Service;

import java.util.List;

import com.example.product.Entity.Product;
public interface ProductService {
	
	public List<Product> findAll();
	public Product findById(int id);
	public void saveProduct(Product product);
	public void deleteById(int Id);

}
  