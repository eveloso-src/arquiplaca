package com.muebles.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "movement")
public class Movement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "mov_id")
	private int id;

//	@Column(name = "date")
//	@DateTimeFormat(pattern = "dd.MM.yyyy")
//	@NotEmpty(message = "*Ingrese la fecha")
//	private java.sql.Date date;
	@Length(min = 10, message = "*Debe tener 10 caracteres")
	@Column(name = "date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotEmpty(message = "*Ingrese la fecha")
	private LocalDate date;

	@Column(name = "code")
	@Length(min = 5, message = "*Debe tener 5 caracteres")
	@NotEmpty(message = "*Ingrese codigo")
	private String code;
	

	@Column(name = "color")
//	@Length(min = 5, message = "*Debe tener 5 caracteres")
	@NotEmpty(message = "*Ingrese color")
	private String color;

	@Column(name = "amount")
//	@NotEmpty(message = "*Ingrese cantidad")
	private int amount;

	@Column(name = "m2")
//	@NotEmpty(message = "*Ingrese m2")
	private int m2;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public java.sql.Date getDate() {
//		return date;
//	}
//
//	public void setDate(java.sql.Date date) {
//		this.date = date;
//	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}


	public int getM2() {
		return m2;
	}

	public void setM2(int m2) {
		this.m2 = m2;
	}

}
