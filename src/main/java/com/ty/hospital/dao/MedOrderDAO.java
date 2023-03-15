package com.ty.hospital.dao;

import java.util.List;

import com.ty.hospital.dto.MedOrder;

public interface MedOrderDAO {
	
	MedOrder saveMedOrder(int b_id,MedOrder medOrder);
	MedOrder getMEdOrgerById(int m_id);
	boolean deletMedOrderById(int m_id);
	MedOrder updateMedOrderById(int m_id,MedOrder medOrder);
	
	List<MedOrder> getAllMedorder();
	List<MedOrder> getMedorderByDoctorName(String name);
	List<MedOrder> getMedOrderByDate(String date);
	
	
}
