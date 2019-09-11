package com.muebles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muebles.model.Movement;
import com.muebles.repository.MovementRepository;

@Service("movementService")
public class MovementServiceImpl implements MovementService {

	@Autowired
	MovementRepository movementRepository;
	
	public void save(Movement mov) {
		movementRepository.save(mov);
	}
}
