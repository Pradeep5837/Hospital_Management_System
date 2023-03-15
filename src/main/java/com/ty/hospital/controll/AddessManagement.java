package com.ty.hospital.controll;

import java.util.List;

import com.ty.hospital.dto.Address;
import com.ty.hospital.dto.Branch;
import com.ty.hospital.service.AddressService;
import com.ty.hospital.service.BranchService;

public class AddessManagement {

	static AddressService as = new AddressService();

	public static void saveData(String street, String cantry, int pin, String state) {

		Address a = new Address();
		a.setA_street(street);
		a.setCantry(cantry);
		a.setPin(pin);
		a.setState(state);

		as.saveAddress(1, a);

	}

	public static void getAllData() {

		List<Address> la = as.getAllAddress();
		for (Address i : la) {

			System.out.println(i);

		}

	}

	public static void delet(int id) {

		as.deletAddressById(id);
	}

	static void getDataById(int id) {

		System.out.print(as.getAddressById(id));
	}

	public static void main(String[] args) {

		getAllData();

	}

}
