package com.sa.service;

import org.springframework.stereotype.Service;

import com.sa.model.Product;

@Service
public class ProductValidationSerivce {

	public boolean isValid(Product product) {
		if (product.getId() != null) {
			return true;
		}
		return false;
	}

}
