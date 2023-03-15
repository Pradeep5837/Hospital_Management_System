package com.ty.hospital.dao;

import java.util.List;

import com.ty.hospital.dto.Observation;

public interface ObservationDAO {
	
	Observation saveObservation(int b_id,Observation obsaervation);
	Observation getObsarvationById(int o_id);
	boolean deletObservationById(int o_id);
	Observation updateObservationById(int o_id,Observation observatio);
	List<Observation> getObservation();
	List<Observation> getObservationByDoctorName(String name);

}
