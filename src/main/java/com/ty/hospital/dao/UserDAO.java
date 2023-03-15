package com.ty.hospital.dao;

import java.util.List;


import com.ty.hospital.dto.User;

public interface UserDAO {
	
	User saveUser(User user);
	User getUserById(int u_id);
	boolean deletUserById(int u_id);
	User updateUserById(int u_id,User user);
	public List<User> getAllUser();

	List<User >getUserByRole(String role);
}
 