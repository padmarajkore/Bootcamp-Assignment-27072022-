package com.example.product.repository;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.product.Entity.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
	
	@Autowired
	EntityManager entitymanager;
	
	@Override
	public List<Product> findAll() {
		
		Session currentSession = entitymanager.unwrap(Session.class);
		Query<Product> query = currentSession.createQuery("select e from Product e", Product.class);
		
		List<Product> emplist = query.getResultList();
		return emplist;
		
	}
	
	public Product findById(int id) {
		Session currentSession = entitymanager.unwrap(Session.class);
		return currentSession.get(Product.class, id);
	}

	@Override
	public void saveProduct(Product Product) {
      Session currentSession = entitymanager.unwrap(Session.class);
      currentSession.saveOrUpdate(Product);
	}

	@Transactional
	public void deleteById(int Id) {
		Session currentSession = entitymanager.unwrap(Session.class);
		Query<Product> query = currentSession.createQuery("delete from Product where Id = :prodid");
		query.setParameter("prodid", Id);
		query.executeUpdate();
	}
}
	