package com.muebles.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muebles.model.Movement;

@Repository("movementRepository")
public interface MovementRepository extends JpaRepository<Movement, Integer>{

	List<Movement>findByDateBetweenOrderByDateDesc(Date from, Date to);
}
