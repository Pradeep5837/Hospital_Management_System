package com.ty.hospital.service;

import java.util.List;

import com.ty.hospital.dao.ItemDAO;
import com.ty.hospital.daoIml.ItemDAOimpl;
import com.ty.hospital.dto.Item;

public class ItemService {

	ItemDAO iimpl = new ItemDAOimpl();

	public void saveItem(int m_id, Item item) {

		Item a = iimpl.saveItem(m_id, item);
		if (a != null) {
			System.out.println("Item data saved");
		} else {
			System.err.println("Item not saved");
		}
	}

	public Item getItemById(int id) {

		Item a = iimpl.getItemById(id);
		if (a != null) {
			return a;
		}
		return null;
	}

	public void deletItemById(int id) {

		if (iimpl.deletItemById(id)) {
			System.out.println("Item deleted");
		} else {
			System.err.println("Item not deleted");
		}
	}

	public List<Item> getAllItem() {

		List<Item> l = iimpl.getAllItems();
		return l;
	}

}
