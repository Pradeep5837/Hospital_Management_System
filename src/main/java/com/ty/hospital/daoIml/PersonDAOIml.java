package com.ty.hospital.daoIml;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dao.PersonDAO;
import com.ty.hospital.dto.Encounter;
import com.ty.hospital.dto.Person;

public class PersonDAOIml implements PersonDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pradeep");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public Person savePerson(int e_id, Person person) {

		Encounter e = em.find(Encounter.class, e_id);
		if (e != null) {
			
			
			e.setPersons(person);
			et.begin();
			em.persist(person);
			et.commit();
			return person;
		}

		return null;
	}

	public Person getPersonById(int p_id) {

		Person p = em.find(Person.class, p_id);
		if (p != null) {
			return p;
		}
		return null;
	}

	public boolean deletPerson(int p_id) {
		Person p = em.find(Person.class, p_id);
		if (p != null) {
			et.begin();
			em.remove(p);
			et.commit();
			return true;
		}
		return false;
	}

	public Person updatePerson(int p_id, Person person) {
		Person p = em.find(Person.class, p_id);
		if (p != null) {
			if (person.getP_address() != null)
				p.setP_address(person.getP_address());
			if (person.getP_dob() != null)
				p.setP_dob(person.getP_dob());
			if (person.getP_age() > 0)
				p.setP_age(person.getP_age());
			if (person.getP_email() != null)
				p.setP_email(person.getP_email());
			if (person.getP_gender() != '\0')
				p.setP_gender(person.getP_gender());
			if (person.getP_name() != null)
				p.setP_name(person.getP_name());
			if (person.getP_phno() > 10000000)
				p.setP_phno(person.getP_phno());
			if (person.getEncounters() != null)
				p.setEncounters(person.getEncounters());
			et.begin();
			em.merge(p);
			et.commit();
			return p;
		}
		return null;
	}

	public List<Person> getAllPerson() {

		Query q = em.createQuery("select p from Person p");
		List<Person> persons = q.getResultList();

		return persons;
	}

	public List<Person> getpersonByGender(char gender) {

		Query q = em.createQuery("select p from Person p where p.p_name=?1");
		q.setParameter(1, gender);
		List<Person> persons = q.getResultList();

		return persons;
	}

	public List<Person> getPesonByAge(int age) {
		Query q = em.createQuery("select p from Person p where p.p_age=?1");
		q.setParameter(1, age);
		List<Person> persons = q.getResultList();

		return persons;
	}

	public List<Person> getPersonByPhnoneNumber(long phno) {

		Query q = em.createQuery("select p from Person p where p.p_phno=?1");
		q.setParameter(1, phno);
		List<Person> persons = q.getResultList();

		return persons;
	}

}
