package com.muebles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muebles.model.Product;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	Product findByCode(String code);
	Product findByColor(String color);

}
