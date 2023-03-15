package com.ty.hospital.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Observation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int o_id;
	private String dname;
	
	private  String orObservation;
	
	@JoinColumn
	@ManyToOne
	private Encounter encounter;
	
	public int getO_id() {
		return o_id;
	}
	public void setO_id(int o_id) {
		this.o_id = o_id;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getOrObservation() {
		return orObservation;
	}
	public void setOrObservation(String orObservation) {
		this.orObservation = orObservation;
	}
	public Encounter getEncounter() {
		return encounter;
	}
	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}
	@Override
	public String toString() {
		return "Observation [o_id=" + o_id + ", dname=" + dname + ", orObservation=" + orObservation + ", encounter="
				+ encounter + "]";
	}
	
	
	
}
