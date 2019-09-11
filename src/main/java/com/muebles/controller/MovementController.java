package com.muebles.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.muebles.model.Movement;
import com.muebles.service.MovementService;

@Controller
public class MovementController {

	@Autowired
	MovementService movementService;

	@RequestMapping(value = "/movement", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView saveMovement(@RequestParam (value = "date") String dateInput,
			@RequestParam (value = "code") String code,
			@RequestParam (value = "color") String color,
			@RequestParam (value = "amount") int amount,
			@RequestParam (value = "m2") int m2,
			@Valid Movement mov, 
			BindingResult bindingResult
			) {
		ModelAndView modelAndView = new ModelAndView();
//		System.out.println("test movement ok " );
//		System.out.println("code " + code);
//		System.out.println("color " + color);
//		System.out.println("amount " + amount);
//		System.out.println("m2 " + m2);
//		System.out.println("dateInput " + dateInput);
//		modelAndView.addObject(getNewMovement());
		Movement movEnt = new Movement();
		movEnt.setAmount(amount);
		movEnt.setCode(code);
		movEnt.setColor(color);
		movEnt.setM2(m2);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			movEnt.setDate(new Date(sdf.parse(dateInput).getTime()));
		} catch (ParseException e) {
			movEnt.setDate(new Date(System.currentTimeMillis()));
		}
		
		movementService.save(movEnt);
		
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}

	public static Movement getNewMovement() {
		Movement mov = new Movement();
		mov.setDate(new Date(System.currentTimeMillis()));
		return mov;
	}

}
