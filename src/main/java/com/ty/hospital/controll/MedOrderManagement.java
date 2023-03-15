package com.ty.hospital.controll;

import java.util.List;

import com.ty.hospital.daoIml.MedorderDAOImpl;
import com.ty.hospital.dto.Item;
import com.ty.hospital.dto.MedOrder;
import com.ty.hospital.service.ItemService;
import com.ty.hospital.service.MedOrderService;

public class MedOrderManagement {
	
	static MedOrderService as=new MedOrderService();
	
	public static void saveData(String name, String Odate, int cost) {

		MedOrder m=new MedOrder();
		
		m.setdName(name);
		m.setOrderDate(Odate);
		m.setTotal(cost);
		
		MedOrderService ms=new MedOrderService();
		ms.saveMedOrder(1, m);
		

	}

	public static void getAllData() {

		List<MedOrder> la = as.getAllMedOrder();
		for (MedOrder i : la) {

			System.out.println(i);

		}

	}

	public static void delet(int id) {

		as.deletMedOrderById(id);
	}

	static void getDataById(int id) {

		System.out.print(as.getMedOrderById(id));
	}
	
	static void getDataByDoctorName(String name) {

		System.out.print(as.getAllMedOrderByDoctorNmae(name));
	}
	
	static void getDataBydate(String date) {

		System.out.print(as.getAllMedOrderByDate(date));
	}
	
	public static void main(String[] args) {

		getAllData();
		

	}
		
		
	

}
