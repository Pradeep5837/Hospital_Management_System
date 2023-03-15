package com.ty.hospital.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class MedOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int m_id;
	private String dName;
	private String orderDate;
	private int total;

	@OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
	List<Item> items;
	
	@JoinColumn
	@ManyToOne
	Encounter encounters;

	public int getM_id() {
		return m_id;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Encounter getEncounters() {
		return encounters;
	}

	public void setEncounters(Encounter encounters) {
		this.encounters = encounters;
	}

	@Override
	public String toString() {
		return "MedOrder [m_id=" + m_id + ", dName=" + dName + ", orderDate=" + orderDate + ", total=" + total + "]";
	}

	
}
