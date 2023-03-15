package com.ty.hospital.dao;

import java.util.List;

import com.ty.hospital.dto.Address;

public interface AddressDAO {

	Address saveAddress(int B_id,Address address);
	Address getAddressById(int a_id);
	boolean deletAddressById(int a_id);
	Address updateAddressById(int a_id,Address address);
	public  List<Address> getAllAddress();
}
