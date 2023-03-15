package com.ty.hospital.controll;

import java.util.List;

import com.ty.hospital.dto.Encounter;
import com.ty.hospital.dto.Item;
import com.ty.hospital.service.EncounterService;
import com.ty.hospital.service.ItemService;
import com.ty.hospital.service.PersonService;

public class ItemManagement {

	static ItemService as = new ItemService();

	public static void saveData(String name, int qun, int cost) {

		Item item = new Item();

		item.setI_name(name);
		item.setQuantity(qun);
		item.setCost(cost);

		ItemService is = new ItemService();
		is.saveItem(1, item);

	}

	public static void getAllData() {

		List<Item> la = as.getAllItem();
		for (Item i : la) {

			System.out.println(i);

		}

	}

	public static void delet(int id) {

		as.deletItemById(id);
	}

	static void getDataById(int id) {

		System.out.print(as.getItemById(id));
	}

	public static void main(String[] args) {

		getAllData();

	}

}
