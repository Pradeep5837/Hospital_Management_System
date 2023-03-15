package com.ty.hospital.controll;

import java.util.List;

import com.ty.hospital.dto.Address;
import com.ty.hospital.dto.Branch;
import com.ty.hospital.service.AddressService;
import com.ty.hospital.service.BranchService;
import com.ty.hospital.service.HospitalService;

public class BranchManagement {
	
	static BranchService as=new BranchService();
	
	public static void saveData(String name, String email, long phno) {

		Branch b = new Branch();
		b.setB_name(name);
		b.setB_phno(phno);
		b.setEmail(email);

		AddressService as = new AddressService();
		Address a = as.getAddressById(7);
		b.setAddress(a);
		BranchService s = new BranchService();
		s.saveBranch(1, b);

	}

	public static void getAllData() {

		List<Branch> la = as.getAllBranch();
		for (Branch i : la) {

			System.out.println(i);

		}

	}

	public static void delet(int id) {

		as.deletBranchById(id);
	}

	static void getDataById(int id) {

		System.out.print(as.getBranchById(id));
	}

	public static void main(String[] args) {

		getAllData();
		
	}

}
