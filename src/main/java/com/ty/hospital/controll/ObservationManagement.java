package com.ty.hospital.controll;

import java.util.List;

import com.ty.hospital.dto.MedOrder;
import com.ty.hospital.dto.Observation;
import com.ty.hospital.service.MedOrderService;
import com.ty.hospital.service.ObservationService;

public class ObservationManagement {
	
	static ObservationService as=new ObservationService();

	public static void saveData(String name, String Oro) {

		Observation o=new Observation();

		o.setDname(name);
		o.setOrObservation(Oro);
		ObservationService os=new ObservationService();

		os.saveObservation(1, o);


	}

	public static void getAllData() {

		List<Observation> la = as.getAllObservation();
		for (Observation i : la) {

			System.out.println(i);

		}

	}

	public static void delet(int id) {

		as.deletObservationById(id);
	}

	static void getDataById(int id) {

		System.out.print(as.getObservationById(id));
	}

	static void getDataByDoctorName(String name) {

		System.out.print(as.getAllObservationByDoctorNmae(name));
	}

	

	public static void main(String[] args) {

		getAllData();


}

}
