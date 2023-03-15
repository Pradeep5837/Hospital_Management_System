package com.ty.hospital.dao;

import java.util.List;

import com.ty.hospital.dto.Encounter;

public interface EncounterDAO {
	
	Encounter saveEncounter(int b_id,Encounter encounter);
	Encounter getEncounterById(int e_id);
	boolean deletEncounterById(int e_id);
	Encounter updateEncounter(int e_id,Encounter encounter);
	List<Encounter> getAllEncounter();
	
	
	
}
