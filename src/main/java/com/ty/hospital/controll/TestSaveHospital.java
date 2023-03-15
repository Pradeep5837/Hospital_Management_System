package com.ty.hospital.controll;

import java.util.List;

import com.google.protobuf.Service;
import com.ty.hospital.dto.Branch;
import com.ty.hospital.dto.Hospital;
import com.ty.hospital.dto.Person;
import com.ty.hospital.service.BranchService;
import com.ty.hospital.service.HospitalService;
import com.ty.hospital.service.PersonService;

public class TestSaveHospital {

	static HospitalService as = new HospitalService();

	public static void saveData(String name, String web) {

		Hospital h = new Hospital();
		h.setName(name);
		h.setWeb(web);
		HospitalService s = new HospitalService();
		s.saveHospital(h);

//		Branch b=new Branch();
//		
////		b.setB_name("Basavanagudi_2");
////		b.setB_phno(1234567891l);
////		b.setEmail("apollobasavanagudi_2@gmail.com");
////		b.setHospitals(h);
//		BranchService s1=new BranchService();
////		
////		s1.saveBranch(1, b);
////		
//		Branch b=new Branch();
//		b.setHospitals(s.getHospitalById(1));
//		s1.updateBrabchById(3, b);
//		

	}

	public static void delet(int id) {

		as.deletHospitalById(id);
	}

	static void getDataById(int id) {

		System.out.print(as.getHospitalById(id));
	}

	public static void main(String[] args) {

		getDataById(1);

	}

}
