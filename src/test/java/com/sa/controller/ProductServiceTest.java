package com.sa.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;

import com.sa.dao.ProductDao;
import com.sa.model.Product;
import com.sa.service.ProductService;
import com.sa.service.ProductValidationSerivce;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("test-servlet-context.xml")
public class ProductServiceTest {

	ProductDao productDao;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	private ProductValidationSerivce productValidationSerivce;
	
	Product product;
	
	//Extend the stub class
	 class ProductValidationServiceStub extends ProductValidationSerivce {
	        @Override
	        public boolean isValid(Product product) {
	            return true;
	        }
	  }
	
	@Before
    public void before() {
		product = new Product();
		//Mock DAO class
		productDao = Mockito.mock(ProductDao.class);
		//Mock DAO into Service
        ReflectionTestUtils.setField(productService, "pruductDao", productDao);
    }
	
	
	
	@Test
	  public void createUser_save_user() {
	    //Call method from Class Under Test 
		productService.save(product);
	    
	    //Verify expectation
		Mockito.verify(productDao).save(product);
	  }
	
	//Stub
	@Test
	public void valid_product_when_valiate_is_passed(){
		
		//DI Stub class to parent class
		productValidationSerivce = new ProductValidationServiceStub();
		productService = new ProductService(productValidationSerivce);
		
		productService.validate(product);

		assertTrue(product.isStatus());
	}
}
