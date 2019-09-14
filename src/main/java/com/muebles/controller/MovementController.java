package com.muebles.controller;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public @ResponseBody ResponseEntity<String> saveMovement(Movement mov, BindingResult bindingResult) {
//		ModelAndView modelAndView = new ModelAndView();
		Product p = this.prodRepo.findByColor(mov.getProduct().getColor());
		mov.setProduct(p);
		mov.setColor(p.getColor().replaceAll("[0-9]", ""));
		Date savedDate = mov.getDate();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, savedDate.getDate());
		cal.set(Calendar.MONTH, savedDate.getMonth());
		cal.set(Calendar.YEAR, savedDate.getYear()+1900);
		mov.setDate(cal.getTime());
		if (!bindingResult.hasErrors()) {
			movementService.save(mov);
		} else {
			System.out.println("error save movement");
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

//		modelAndView.setViewName("admin/home");
		return new ResponseEntity<String>("admin/home", HttpStatus.OK);
	}

	public static Movement getNewMovement() {
		Movement mov = new Movement();
		Product pr = new Product();
		mov.setProduct(pr);
		mov.setDate(new java.util.Date());
		return mov;
	}

}
