package com.ty.hospital.service;

import java.util.List;

import com.ty.hospital.dao.PersonDAO;
import com.ty.hospital.daoIml.PersonDAOIml;
import com.ty.hospital.dto.Observation;
import com.ty.hospital.dto.Person;

public class PersonService {

	PersonDAO pimpl = new PersonDAOIml();

	public void savePerson(int e_id, Person person) {

		Person a = pimpl.savePerson(e_id, person);
		if (a != null) {
			System.out.println("Person data saved");
		} else {
			System.err.println("Person not saved");
		}
	}

	public Person getPersonById(int id) {

		Person a = pimpl.getPersonById(id);
		if (a != null) {
			return a;
		}
		return null;
	}

	public void deletPersonById(int id) {

		if (pimpl.deletPerson(id)) {
			System.out.println("Person deleted");
		} else {
			System.err.println("Person not deleted");
		}
	}

	public void updatePersonById(int id, Person person) {

		Person m = pimpl.updatePerson(id, person);
		if (m != null) {
			System.out.println("Person is updated");
		} else {
			System.err.println("Person is not updated");
		}
	}

	public List<Person> getAllPerson() {

		List<Person> l = pimpl.getAllPerson();
		return l;
	}

	public List<Person> getPersonByGender(char gener) {
		List<Person> l = pimpl.getpersonByGender(gener);
		return l;
	}

	public List<Person> getPesonByAge(int age) {
		List<Person> l = pimpl.getPesonByAge(age);
		return l;
	}

	public List<Person> getPersonByPhnoneNumber(long phno) {

		List<Person> l = pimpl.getPersonByPhnoneNumber(phno);
		return l;
	}

}
