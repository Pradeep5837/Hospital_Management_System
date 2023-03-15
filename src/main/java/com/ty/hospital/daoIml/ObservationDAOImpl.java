package com.ty.hospital.daoIml;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dao.ObservationDAO;
import com.ty.hospital.dto.Branch;
import com.ty.hospital.dto.Encounter;
import com.ty.hospital.dto.Observation;

public class ObservationDAOImpl implements ObservationDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pradeep");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public Observation saveObservation(int e_id, Observation obsaervation) {

		Encounter e = em.find(Encounter.class, e_id);
		if (e != null) {

			List<Observation> lo = e.getObservation();
			lo.add(obsaervation);
			e.setObservation(lo);

			obsaervation.setEncounter(e);
			et.begin();
			em.persist(obsaervation);
			et.commit();
			return obsaervation;
		}
		return null;
	}

	public Observation getObsarvationById(int o_id) {

		Observation o = em.find(Observation.class, o_id);
		if (o != null) {

			return o;
		}
		return null;
	}

	public boolean deletObservationById(int o_id) {

		Observation o = em.find(Observation.class, o_id);
		if (o != null) {
			et.begin();
			em.remove(o);
			et.commit();
			return true;
		}
		return false;
	}

	public Observation updateObservationById(int o_id, Observation observatio) {

		Observation o = em.find(Observation.class, o_id);
		if (o != null) {
			if (observatio.getDname() != null)
				o.setDname(observatio.getDname());
			if (observatio.getOrObservation() != null)
				o.setOrObservation(observatio.getOrObservation());
			if (observatio.getEncounter() != null)
				o.setEncounter(observatio.getEncounter());
			et.begin();
			em.merge(o);
			et.commit();
			return o;
		}
		return null;
	}

	public List<Observation> getObservation() {

		Query q = em.createQuery("select o from Observation o");
		List<Observation> observations = q.getResultList();
		return observations;
	}

	public List<Observation> getObservationByDoctorName(String name) {

		Query q = em.createQuery("select o from Observation o where o.dname=?1");
		q.setParameter(1, name);
		List<Observation> observations = q.getResultList();
		return observations;
	}

}
