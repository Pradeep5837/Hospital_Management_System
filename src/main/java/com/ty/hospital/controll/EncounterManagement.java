package com.ty.hospital.controll;

import java.util.List;

import com.ty.hospital.dto.Address;
import com.ty.hospital.dto.Branch;
import com.ty.hospital.dto.Encounter;
import com.ty.hospital.service.AddressService;
import com.ty.hospital.service.BranchService;
import com.ty.hospital.service.EncounterService;
import com.ty.hospital.service.PersonService;

public class EncounterManagement {
	
	static EncounterService as=new EncounterService();
	
	public static void saveData(String dod, String doj) {
		
		Encounter encounter = new Encounter();
		encounter.setDateOfDischarge(dod);
		encounter.setDateOfJoin(doj);
		
		PersonService ps=new PersonService();
		
		encounter.setPersons(ps.getPersonById(1));
		
		EncounterService es=new EncounterService();
		es.saveEncounter(1, encounter);

	}

	public static void getAllData() {

		List<Encounter> la = as.getAllEncounter();
		for (Encounter i : la) {

			System.out.println(i);

		}

	}

	public static void delet(int id) {

		as.deletEncounterById(id);
	}

	static void getDataById(int id) {

		System.out.print(as.getEncounterById(id));
	}
	
	public static void main(String[] args) {
		
		getAllData();
	}

}
