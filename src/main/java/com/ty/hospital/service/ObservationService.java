package com.ty.hospital.service;

import java.util.List;

import com.ty.hospital.dao.ObservationDAO;
import com.ty.hospital.daoIml.ObservationDAOImpl;
import com.ty.hospital.dto.Observation;

public class ObservationService {
	
	ObservationDAO oimpl=new ObservationDAOImpl();
	
	public void saveObservation(int b_id, Observation observation) {

		Observation a =oimpl.saveObservation(b_id, observation);
		if (a != null) {
			System.out.println("Observation data saved");
		} else {
			System.err.println("Observation not saved");
		}
	}

	public Observation getObservationById(int id) {

		Observation a = oimpl.getObsarvationById(id);
		if (a != null) {
			return a;
		}
		return null;
	}

	public void deletObservationById(int id) {

		if (oimpl.deletObservationById(id)) {
			System.out.println("Observation deleted");
		} else {
			System.err.println("Observation not deleted");
		}
	}
	public void updateObservationById(int id ,Observation observation) {
		
		Observation m=oimpl.updateObservationById(id, observation);
		if(m!=null) {
			System.out.println("Observation is updated");
		}else {
			System.err.println("Observation is not updated");
		}
	}

	public List<Observation> getAllObservation() {

		List<Observation> l = oimpl.getObservation();
		return l;
	}

	public List<Observation> getAllObservationByDoctorNmae(String name) {

		List<Observation> l = oimpl.getObservationByDoctorName(name);
		return l;
	}
	
	

}
