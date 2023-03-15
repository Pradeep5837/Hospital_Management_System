package com.ty.hospital.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int p_id;
	private String p_name;
	private String p_address;
	private long p_phno;
	private String p_email;
	private int p_age;
	private char p_gender;
	private String p_dob;
	
	@OneToMany(mappedBy = "persons",cascade = CascadeType.ALL)
	private List<Encounter> encounters;
	
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_address() {
		return p_address;
	}
	public void setP_address(String p_address) {
		this.p_address = p_address;
	}
	public long getP_phno() {
		return p_phno;
	}
	public void setP_phno(long p_phno) {
		this.p_phno = p_phno;
	}
	public String getP_email() {
		return p_email;
	}
	public void setP_email(String p_email) {
		this.p_email = p_email;
	}
	public int getP_age() {
		return p_age;
	}
	public void setP_age(int p_age) {
		this.p_age = p_age;
	}
	public char getP_gender() {
		return p_gender;
	}
	public void setP_gender(char p_gender) {
		this.p_gender = p_gender;
	}
	public String getP_dob() {
		return p_dob;
	}
	public void setP_dob(String p_dob) {
		this.p_dob = p_dob;
	}
	public List<Encounter> getEncounters() {
		return encounters;
	}
	public void setEncounters(List<Encounter> encounters) {
		this.encounters = encounters;
	}
	@Override
	public String toString() {
		return "Person [p_id=" + p_id + ", p_name=" + p_name + ", p_address=" + p_address + ", p_phno=" + p_phno
				+ ", p_email=" + p_email + ", p_age=" + p_age + ", p_gender=" + p_gender + ", p_dob=" + p_dob
				+ ", encounters=" + encounters + "]";
	}
	
	
	
	
	
}
