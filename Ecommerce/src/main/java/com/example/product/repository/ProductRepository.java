package com.example.product.repository;

import java.util.List;

import com.example.product.Entity.Product;
public interface ProductRepository {
	
	public List<Product> findAll();
	public Product findById(int id);
    public void saveProduct(Product Product);
    public void deleteById(int Id);
}

