package com.ty.hospital.service;

import java.util.List;

import com.ty.hospital.dao.AddressDAO;
import com.ty.hospital.daoIml.AddressDAOImpl;
import com.ty.hospital.dto.Address;

public class AddressService {

	AddressDAO aimpl=new AddressDAOImpl();
	
	public void saveAddress(int b_id,Address address) {
		
		Address a=aimpl.saveAddress(b_id, address);
		if(a!=null) {
			System.out.println("address data saved");
		}else {
			System.err.println("Address not saved");
		}
	}
	
	public Address getAddressById(int id) {
		
		Address a=aimpl.getAddressById(id);
		if(a!=null) {
			return a;
		}
		return null;
	}
	
	public void deletAddressById(int id) {
		
		if(aimpl.deletAddressById(id)) {
			System.out.println("Address deleted");
		}else
		{
			System.err.println("Address not deleted");
		}
	}
	
	public List<Address> getAllAddress(){
		
		List<Address> l=aimpl.getAllAddress();
		return l;
	}
}
