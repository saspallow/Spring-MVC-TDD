package com.sa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sa.dao.ProductDao;
import com.sa.model.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao pruductDao;

	
	private ProductValidationSerivce productValidationSerivce;
	
	@Autowired
	 public ProductService(ProductValidationSerivce productValidationSerivce) {
		    this.productValidationSerivce = productValidationSerivce;
		  }
	
	
	 public void validate(Product product) {
		    if(this.productValidationSerivce.isValid(product)) {
		    	product.setStatus(true);
		    } else {
		    	product.setStatus(false);
		    }
		  }
	
	public void save(Product product) {

		this.pruductDao.save(product);
	}
	
	 

	public boolean update() {

		return true;
	}
	public Product findById(Long id) {
		Product p = new Product(id, "Jack");
		return p;
	}

	public List<Product> findAll() {
		List<Product> pList = new ArrayList<Product>();

		Product p1 = new Product(1L, "Jack1");
		Product p2 = new Product(2L, "Jack2");
		Product p3 = new Product(3L, "Jack3");
		Product p4 = new Product(4L, "Jack4");

		pList.add(p1);
		pList.add(p2);
		pList.add(p3);
		pList.add(p4);
		
		return pList;

	}

}
