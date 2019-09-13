package com.muebles.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "movement")
public class Movement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "mov_id")
	private int id;

	@Column(name = "date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;

//	@Column(name = "code")
//	@Length(min = 3, message = "*Debe tener 3 caracteres")
//	@NotEmpty(message = "*Ingrese codigo")
//	private String code;
	
	@ManyToOne
	@JoinColumn(name="prod_id")
	private Product product;
	

	@Column(name = "color")
	private String color;

	@Column(name = "amount")
//	@NotEmpty(message = "*Ingrese cantidad")
//	@Length(min = 1, message = "*Debe tener 1 caracteres")
	private int amount;

	@Column(name = "m2")
//	@NotEmpty(message = "*Ingrese m2")
//	@Length(min = 1, message = "*Debe tener 1 caracteres")
	private int m2;

	@Column(name = "carpentry")
	private String carpentry;

	@Column(name = "state")
	private String state;

	@Column(name = "branch")
	private String branch;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

//	public String getCode() {
//		return code;
//	}
//
//	public void setCode(String code) {
//		this.code = code;
//	}

	public int getAmount() {
		return amount;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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

	public String getCarpentry() {
		return carpentry;
	}

	public void setCarpentry(String carpentry) {
		this.carpentry = carpentry;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

}
