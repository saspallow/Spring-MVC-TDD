package com.sa.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class ProductSearch {
	
	final Logger logger = LoggerFactory.getLogger(ProductSearch.class);

	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public String productSearch(@PathVariable Long id, Model model) throws IOException {
		
		
		model.addAttribute("productData", "Jack");
        return "productPage";
		
	
	}
}
