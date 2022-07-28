package com.example.product.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.Entity.Product;
import com.example.product.Service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService prodService;
	
	@GetMapping("/prodList")
	private List<Product> findAll(){
		return prodService.findAll();
	}
    
	@GetMapping("/productid/{id}")
	public Product findById(@PathVariable int id) {
		return prodService.findById(id);
	}
	
	@PostMapping("/save")
	public void saveProduct(@RequestBody Product product) {
		prodService.saveProduct(product);
	}
	
	@PutMapping("/updateProduct")
	public Product updateProduct(@RequestBody Product product) {
		prodService.saveProduct(product);
		return product;
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable int id) {
		Product p = prodService.findById(id);
		if(p == null)
			throw new  RuntimeException("Product id :" + id+" details not found");
		prodService.deleteById(id);
		return "Product :"+id +"deleted";
	}
	
}

 
