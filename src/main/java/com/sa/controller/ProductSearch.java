package com.sa.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sa.model.Product;
import com.sa.service.ProductService;

@Controller
public class ProductSearch {

	@Autowired
	ProductService productService;

	final Logger logger = LoggerFactory.getLogger(ProductSearch.class);

	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public String productSearch(@PathVariable Long id, Model model) throws IOException {
		
		Product product = new Product(id, "Jack");
			if(id > 0){
				model.addAttribute("productData", product);
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@");
				return "productPage";
			}else{
				model.addAttribute("msg", "Data Not found");
				System.out.println("#####################");
				return "productPage";
			}
		
		
		
		
	
	}
}
