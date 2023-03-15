package com.ty.hospital.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Branch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int b_id;
	private String b_name;
	private long b_phno;
	private String email;
	
	@JoinColumn
	@ManyToOne
	Hospital hospitals;
	
	//casacde
	@JoinColumn
	@OneToOne
	Address address;
	
	@OneToMany(mappedBy = "branchs")
	List<Encounter> encounters;
	
	
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public long getB_phno() {
		return b_phno;
	}
	public void setB_phno(long b_phno) {
		this.b_phno = b_phno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Hospital getHospitals() {
		return hospitals;
	}
	public void setHospitals(Hospital hospitals) {
		this.hospitals = hospitals;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Encounter> getEncounters() {
		return encounters;
	}
	public void setEncounters(List<Encounter> encounters) {
		this.encounters = encounters;
	}
	@Override
	public String toString() {
		return "Branch [b_id=" + b_id + ", b_name=" + b_name + ", b_phno=" + b_phno + ", email=" + email + "]";
	}
	
	
}
