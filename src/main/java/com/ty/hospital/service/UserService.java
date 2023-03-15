package com.ty.hospital.service;

import java.util.List;

import com.ty.hospital.dao.UserDAO;
import com.ty.hospital.daoIml.UserDAOImpl;
import com.ty.hospital.dto.Person;
import com.ty.hospital.dto.User;

public class UserService {
	
	UserDAO uimpl=new UserDAOImpl();
	
	public User saveUser( User user) {

		User a = uimpl.saveUser(user);
		if (a != null) {
			System.out.println("User data saved");
			return a;
		}
		System.out.println("");
		return null;
		
	}

	public User getUserById(int id) {

		User a = uimpl.getUserById(id);
		if (a != null) {
			return a;
		}
		return null;
	}

	public void deletUserById(int id) {

		if (uimpl.deletUserById(id)) {
			System.out.println("User deleted");
		} else {
			System.err.println("User not deleted");
		}
	}

	public void updateUserById(int id, User user) {

		User m = uimpl.updateUserById(id, user);
		if (m != null) {
			System.out.println("User is updated");
		} else {
			System.err.println("User is not updated");
		}
	}

	public List<User> getAllUser() {

		List<User> l = uimpl.getAllUser();
		return l;
	}

	public List<User> getUserByRole(String role) {
		List<User> l = uimpl.getUserByRole(role);
		return l;
	}

	

}
