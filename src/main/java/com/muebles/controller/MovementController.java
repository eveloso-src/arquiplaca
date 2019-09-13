package com.muebles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.muebles.model.Movement;
import com.muebles.model.Product;
import com.muebles.repository.ProductRepository;
import com.muebles.service.MovementService;

@Controller
public class MovementController {

//	private static final String DATE_PATTERN = "yyyy-MM-dd";
	@Autowired
	MovementService movementService;

	@Autowired
	ProductRepository prodRepo;
	
	@RequestMapping(value = "/movement", method = RequestMethod.POST)
	public @ResponseBody ModelAndView saveMovement(Movement mov, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		Product p = this.prodRepo.findByColor(mov.getProduct().getColor());
		mov.setProduct(p);
		mov.setColor(p.getColor().replaceAll("[0-9]", ""));
		if (!bindingResult.hasErrors()) {
			movementService.save(mov);
		} else {
			System.out.println("error save movement");
		}

		modelAndView.setViewName("admin/home");
		return modelAndView;
	}

	public static Movement getNewMovement() {
		Movement mov = new Movement();
		Product pr = new Product();
		mov.setProduct(pr);
		mov.setDate(new java.util.Date());
		return mov;
	}

}
