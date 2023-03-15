package com.ty.hospital.dao;

import com.ty.hospital.dto.Hospital;

public interface HospitalDAO {
	Hospital saveHospital(Hospital hospital);
	Hospital getHospitalById(int id);
	boolean deletHospitalById(int id);
	Hospital updateHospitalById(int id,Hospital hospital);
	
}
