package com.muebles.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="products_id_seq")
//    @SequenceGenerator(name="products_id_seq", sequenceName="products_id_seq", allocationSize=1, initialValue=1000)
	@Column(name = "prod_id")
	private int id;


	@Column(name = "code")
	@Length(min = 3, message = "*Debe tener 3 caracteres")
	@NotEmpty(message = "*Ingrese codigo")
	private String code;
	

	@Column(name = "color")
//	@Length(min = 1, message = "*Debe tener 1 caracteres")
//	@NotEmpty(message = "*Ingrese color")
	private String color;

	@Column(name = "description")
	@Length(min = 1, message = "*Debe tener 3 caracteres")
	@NotEmpty(message = "*Ingrese descripcion")
	private String description;

	@Column(name = "stock")
//	@NotEmpty(message = "*Ingrese cantidad")
//	@Length(min = 1, message = "*Debe tener 3 caracteres")
	private int stock;

	@Column(name = "m2")
//	@NotEmpty(message = "*Ingrese cantidad")
//	@Length(min = 1, message = "*Debe tener 3 caracteres")
	private float m2;
	
	public float getM2() {
		return m2;
	}

	public void setM2(float m2) {
		this.m2 = m2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
