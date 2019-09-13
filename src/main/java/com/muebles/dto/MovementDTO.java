package com.muebles.dto;

import java.time.LocalDate;

public class MovementDTO {
	private LocalDate date;
	private String code;
	private String color;
	private int amount;
	private int m2;
	private String carpentry;
	private String state;
	private String branch;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
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
