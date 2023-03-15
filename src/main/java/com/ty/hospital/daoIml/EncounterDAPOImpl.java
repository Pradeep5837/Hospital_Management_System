package com.ty.hospital.daoIml;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
//import javax.persistence.*;
import javax.persistence.Query;
import com.ty.hospital.dao.EncounterDAO;
import com.ty.hospital.dto.Branch;
import com.ty.hospital.dto.Encounter;

public class EncounterDAPOImpl implements EncounterDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pradeep");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public Encounter saveEncounter(int b_id, Encounter encounter) {

		Branch b = em.find(Branch.class, b_id);
		if (b != null) {

			List<Encounter> lb = b.getEncounters();
			lb.add(encounter);
			b.setEncounters(lb);

			encounter.setBranchs(b);
			et.begin();
			em.persist(encounter);
			et.commit();
			return encounter;
		}

		return null;
	}

	public Encounter getEncounterById(int e_id) {

		Encounter e = em.find(Encounter.class, e_id);
		if (e != null) {
			return e;
		}
		return null;
	}

	public boolean deletEncounterById(int e_id) {

		Encounter e = em.find(Encounter.class, e_id);
		if (e != null) {
			et.begin();
			em.remove(e);
			et.commit();
			return true;
		}

		return false;
	}

	public Encounter updateEncounter(int e_id, Encounter encounter) {

		Encounter e = em.find(Encounter.class, e_id);
		if (e != null) {
			if (encounter.getDateOfDischarge() != null)
				e.setDateOfDischarge(encounter.getDateOfDischarge());
			if (encounter.getDateOfJoin() != null)
				e.setDateOfJoin(encounter.getDateOfJoin());
			if (encounter.getBranchs() != null)
				e.setBranchs(encounter.getBranchs());
			if (encounter.getMedOrder() != null)
				e.setMedOrder(encounter.getMedOrder());
			if (encounter.getObservation() != null)
				e.setObservation(encounter.getObservation());
			et.begin();
			em.merge(e);
			et.commit();
			return e;

		}

		return null;
	}

	public List<Encounter> getAllEncounter() {

		Query q = em.createQuery("select e from Encounter e");
		List<Encounter> enconters = q.getResultList();
		return enconters;
	}

}
