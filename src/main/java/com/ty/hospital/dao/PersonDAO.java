package com.ty.hospital.dao;

import java.util.List;

import com.ty.hospital.dto.Person;

public interface PersonDAO {
	
	Person savePerson(int e_id,Person person);
	Person getPersonById(int p_id);
	boolean deletPerson(int p_id);
	Person updatePerson(int p_id,Person person);
	
	List<Person> getAllPerson();
	List<Person> getpersonByGender(char gener);
	List<Person> getPesonByAge(int age);
	List<Person> getPersonByPhnoneNumber(long phno);

}
