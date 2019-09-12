package com.muebles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muebles.model.Product;
import com.muebles.repository.ProductRepository;

@Service("producttService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public void save(Product prod) {
		productRepository.save(prod);
	}
}
