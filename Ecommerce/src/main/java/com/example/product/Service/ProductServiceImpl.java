package com.example.product.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.Entity.Product;
import com.example.product.repository.ProductRepositoryImpl;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepositoryImpl productrepo;
	
	
	public List<Product> findAll() {
		
		return productrepo.findAll();
	}


	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return productrepo.findById(id);
	}


	public void saveProduct(Product product) {
		productrepo.saveProduct(product);
    		
	}


	@Override
	public void deleteById(int Id) {
    productrepo.deleteById(Id);		
	}

	
}
