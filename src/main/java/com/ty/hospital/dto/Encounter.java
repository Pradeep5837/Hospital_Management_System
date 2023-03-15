package com.ty.hospital.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Encounter {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int e_id;
	private String dateOfJoin;
	private String dateOfDischarge;
	
	@OneToMany(mappedBy = "encounter",cascade = CascadeType.ALL)
	List<Observation> observation;
	
	@ManyToOne
	@JoinColumn
	Person persons;
	
	@ManyToOne
	@JoinColumn
	Branch branchs;
	
	@OneToMany(mappedBy = "encounters")
	List<MedOrder> medOrder;
	
	public int getE_id() {
		return e_id;
	}
	public void setE_id(int e_id) {
		this.e_id = e_id;
	}
	public String getDateOfJoin() {
		return dateOfJoin;
	}
	public void setDateOfJoin(String dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}
	public String getDateOfDischarge() {
		return dateOfDischarge;
	}
	public void setDateOfDischarge(String dateOfDischarge) {
		this.dateOfDischarge = dateOfDischarge;
	}
	public List<Observation> getObservation() {
		return observation;
	}
	public void setObservation(List<Observation> observation) {
		this.observation = observation;
	}
	public Person getPersons() {
		return persons;
	}
	public void setPersons(Person persons) {
		this.persons = persons;
	}
	public Branch getBranchs() {
		return branchs;
	}
	public void setBranchs(Branch branchs) {
		this.branchs = branchs;
	}
	public List<MedOrder> getMedOrder() {
		return medOrder;
	}
	public void setMedOrder(List<MedOrder> medOrder) {
		this.medOrder = medOrder;
	}
	@Override
	public String toString() {
		return "Encounter [e_id=" + e_id + ", dateOfJoin=" + dateOfJoin + ", dateOfDischarge=" + dateOfDischarge + "]";
	}
	
	
}
