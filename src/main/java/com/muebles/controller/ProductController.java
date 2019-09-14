package com.muebles.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.muebles.model.Movement;
import com.muebles.model.Product;
import com.muebles.repository.ProductRepository;

@Controller
public class ProductController {

	@Autowired
	ProductRepository productRepo;

	@GetMapping("/product")
	@ResponseBody
	public ModelAndView getProductForm() {
		ModelAndView mav = new ModelAndView();
		Product prod = new Product();
		List<Product>listprod = productRepo.findAll();
		mav.addObject("product", prod);
		mav.addObject("listprod", listprod);
		mav.setViewName("admin/product");
		return mav;
	}
	
	@RequestMapping(value="/product", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> saveProduct(Product product, BindingResult bindingResult) {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("/admin/product");
		Product pDB = productRepo.findByColor(product.getCode());
		if (pDB == null) {
			String color = product.getCode().replaceAll("[0-9]", "");
			product.setColor(product.getCode() + color);
			Product prod = new Product();
//			mav.addObject("product", prod);
			productRepo.save(product);
			return new ResponseEntity<String>("product", HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<String>( HttpStatus.BAD_REQUEST);
			
		}
	}

	@GetMapping("/searchProduct")
	@ResponseBody
	public String getProduct(@RequestParam String color, Movement mov, BindingResult bindingResult) {
		Product prod = productRepo.findByColor(color);
		if (prod != null) {
			return prod.getDescription();
		} else {
			return "";
		}
	}

}
