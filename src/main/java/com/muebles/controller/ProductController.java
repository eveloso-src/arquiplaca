package com.muebles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.muebles.model.Movement;
import com.muebles.model.Product;
import com.muebles.repository.ProductRepository;

@Controller
public class ProductController {

	@Autowired
	ProductRepository productRepo;

	@GetMapping("/searchProduct")
	@ResponseBody
	public String getFoos(@RequestParam String color, Movement mov, BindingResult bindingResult) {

//	@RequestMapping(value = "/searchProduct/{code}", method = RequestMethod.GET)
//	public ModelAndView search(@RequestParam String code, BindingResult result) 
//	{
		Product prod = productRepo.findByColor(color);
		if (prod != null) {
			return prod.getDescription();
		} else {
			return "";
		}
	}

}
