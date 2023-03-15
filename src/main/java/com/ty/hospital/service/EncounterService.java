package com.ty.hospital.service;

import java.util.List;

import com.ty.hospital.dao.EncounterDAO;
import com.ty.hospital.daoIml.EncounterDAPOImpl;
import com.ty.hospital.dto.Encounter;

public class EncounterService {
	
	EncounterDAO eimpl=new EncounterDAPOImpl();
	
	public void saveEncounter(int b_id,Encounter encounter) {
		
		Encounter a=eimpl.saveEncounter(b_id, encounter);
		if(a!=null) {
			System.out.println("Encounter data saved");
		}else {
			System.err.println("Encounter not saved");
		}
	}
	
	public Encounter getEncounterById(int id) {
		
		Encounter a=eimpl.getEncounterById(id);
		if(a!=null) {
			return a;
		}
		return null;
	}
	
	public void deletEncounterById(int id) {
		
		if(eimpl.deletEncounterById(id)) {
			System.out.println("Encounter deleted");
		}else
		{
			System.err.println("Encounter not deleted");
		}
	}
	
	public List<Encounter> getAllEncounter(){
		
		List<Encounter> l=eimpl.getAllEncounter();
		return l;
	}
}
