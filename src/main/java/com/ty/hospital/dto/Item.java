package com.ty.hospital.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int i_id;
	private String i_name;
	private int cost;
	private int quantity;
	@ManyToOne
	@JoinColumn
	private MedOrder orders;

	public int getI_id() {
		return i_id;
	}

	public void setI_id(int i_id) {
		this.i_id = i_id;
	}

	public String getI_name() {
		return i_name;
	}

	public void setI_name(String i_name) {
		this.i_name = i_name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public MedOrder getOrders() {
		return orders;
	}

	public void setOrders(MedOrder orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Item [i_id=" + i_id + ", i_name=" + i_name + ", cost=" + cost + ", quantity=" + quantity + ", orders="
				+ orders + "]";
	}

}
