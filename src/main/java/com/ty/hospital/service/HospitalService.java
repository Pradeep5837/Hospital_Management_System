package com.ty.hospital.service;

import com.ty.hospital.daoIml.HospitalDAOImpl;
import com.ty.hospital.dto.Hospital;

public class HospitalService {

	HospitalDAOImpl himpl = new HospitalDAOImpl();

	public void saveHospital(Hospital hospital) {

		Hospital h = himpl.saveHospital(hospital);
		{
			if (h != null) {
				System.out.println("Data saved");
			} else {
				System.out.println("Data not saved");
			}
		}

	}

	public Hospital getHospitalById(int id) {

		Hospital h = himpl.getHospitalById(id);
		if (h != null) {
			return h;
		}
		return null;
	}

	public void deletHospitalById(int id) {

		if (himpl.deletHospitalById(id)) {

			System.out.println("Hospital Deleted");
		} else {
			System.err.println("Hospital Not deleted");
		}
	}

	public void updateHospitalById(int id, Hospital hospital) {

		Hospital h = himpl.updateHospitalById(id, hospital);
		if (h != null) {
			System.out.println("Hospital data updated");
		} else {
			System.err.println("Hospital data not Updated");
		}

	}

}
