package com.ty.hospital.controll;

import java.util.List;

import com.ty.hospital.dto.Observation;
import com.ty.hospital.dto.Person;
import com.ty.hospital.service.ObservationService;
import com.ty.hospital.service.PersonService;

public class PersonManagement {

	static PersonService as = new PersonService();

	public static void saveData(String name, int age, String dob, char gender, String email, long phno,
			String address) {

		Person p = new Person();
		p.setP_name(name);
		p.setP_age(age);
		p.setP_dob(dob);
		p.setP_gender(gender);
		p.setP_email(email);
		p.setP_phno(phno);
		p.setP_address(address);

		PersonService ps = new PersonService();
		ps.savePerson(1, p);

	}

	public static void getAllData() {

		List<Person> la = as.getAllPerson();
		for (Person i : la) {

			System.out.println(i);

		}

	}

	public static void delet(int id) {

		as.deletPersonById(id);
	}

	static void getDataById(int id) {

		System.out.print(as.getPersonById(id));
	}

	static void getDataByGender(char gender) {

		System.out.print(as.getPersonByGender(gender));
	}

	static void getDataByPhno(long phno) {

		System.out.print(as.getPersonByPhnoneNumber(phno));
	}

	public static void main(String[] args) {

		getAllData();

	}

}
