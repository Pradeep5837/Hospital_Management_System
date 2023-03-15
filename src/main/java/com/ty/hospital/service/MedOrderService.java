package com.ty.hospital.service;

import java.util.List;

import com.ty.hospital.dao.MedOrderDAO;
import com.ty.hospital.daoIml.MedorderDAOImpl;
import com.ty.hospital.dto.MedOrder;

public class MedOrderService {
	
	MedOrderDAO mimpl=new MedorderDAOImpl();
	
	public void saveMedOrder(int b_id, MedOrder medOrder) {

		MedOrder a =mimpl.saveMedOrder(b_id, medOrder) ;
		if (a != null) {
			System.out.println("MedOrder data saved");
		} else {
			System.err.println("MedOrder not saved");
		}
	}

	public MedOrder getMedOrderById(int id) {

		MedOrder a = mimpl.getMEdOrgerById(id);
		if (a != null) {
			return a;
		}
		return null;
	}

	public void deletMedOrderById(int id) {

		if (mimpl.deletMedOrderById(id)) {
			System.out.println("MedOrder deleted");
		} else {
			System.err.println("MedOrder not deleted");
		}
	}
	
	public void updateMedOrderById(int id ,MedOrder medOrder) {
		
		MedOrder m=mimpl.updateMedOrderById(id, medOrder);
		if(m!=null) {
			System.out.println("Medorder is updated");
		}else {
			System.err.println("MedOrder is not updated");
		}
	}

	public List<MedOrder> getAllMedOrder() {

		List<MedOrder> l = mimpl.getAllMedorder();
		return l;
	}

	public List<MedOrder> getAllMedOrderByDoctorNmae(String name) {

		List<MedOrder> l = mimpl.getMedorderByDoctorName(name);
		return l;
	}
	
	public List<MedOrder> getAllMedOrderByDate(String date) {

		List<MedOrder> l = mimpl.getMedOrderByDate(date);
		return l;
	}
}
