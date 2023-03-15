package com.ty.hospital.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int a_id;
	private String a_street;
	private String state;
	private String cantry;
	private int pin;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "address")
	Branch branches;

	public int getA_id() {
		return a_id;
	}

	public void setA_id(int a_id) {
		this.a_id = a_id;
	}

	public String getA_street() {
		return a_street;
	}

	public void setA_street(String a_street) {
		this.a_street = a_street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCantry() {
		return cantry;
	}

	public void setCantry(String cantry) {
		this.cantry = cantry;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public Branch getBranches() {
		return branches;
	}

	public void setBranches(Branch branches) {
		this.branches = branches;
	}

	@Override
	public String toString() {
		return "Address [a_id=" + a_id + ", a_street=" + a_street + ", state=" + state + ", cantry=" + cantry + ", pin="
				+ pin + ", branches=" + branches + "]";
	}
	

}
