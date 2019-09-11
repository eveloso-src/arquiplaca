package com.muebles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muebles.model.Movement;

@Repository("movementRepository")
public interface MovementRepository extends JpaRepository<Movement, Integer>{

}
