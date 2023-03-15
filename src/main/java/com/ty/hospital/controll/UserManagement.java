package com.ty.hospital.controll;

import java.util.List;

import com.ty.hospital.dto.Person;
import com.ty.hospital.dto.User;
import com.ty.hospital.service.PersonService;
import com.ty.hospital.service.UserService;

public class UserManagement {
	
	static UserService as=new UserService();
	
	
	public static void saveData(String name,  String email, long phno, int password,
			String role) {

		User u=new User();
		u.setName(name);
		u.setPhno(phno);
		u.setEmail(email);
		u.setPassword(password);
		u.setRole(role);
		
		UserService us=new UserService();
		us.saveUser(u);
	}

	public static void getAllData() {

		List<User> la = as.getAllUser();
		for (User i : la) {

			System.out.println(i);

		}

	}

	public static void delet(int id) {

		as.deletUserById(id);
	}

	static void getDataById(int id) {

		System.out.print(as.getUserById(id));
	}

	static void getDataByRole(String role) {

		System.out.print(as.getUserByRole(role));
	}

	
	public static void main(String[] args) {

		getAllData();
	
		
	}

}
