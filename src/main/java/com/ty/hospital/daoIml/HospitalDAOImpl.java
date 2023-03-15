package com.ty.hospital.daoIml;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospital.dao.HospitalDAO;
import com.ty.hospital.dto.Hospital;

public class HospitalDAOImpl implements HospitalDAO {

	public Hospital saveHospital(Hospital hospital) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pradeep");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(hospital);
		et.commit();
		return hospital;
	}

	public Hospital getHospitalById(int id) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pradeep");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Hospital h = em.find(Hospital.class, id);

		if (h != null) {
			return h;
		}
		return null;
	}

	public boolean deletHospitalById(int id) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pradeep");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Hospital h = em.find(Hospital.class, id);
		if (h != null) {
			em.remove(h);
			et.commit();
			return true;
		}
		et.commit();
		return false;
	}

	public Hospital updateHospitalById(int id, Hospital hospital) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pradeep");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		if(hospital!=null)
		{
		et.begin();
		Hospital h = em.find(Hospital.class, id);
		if(hospital.getName()!=null)
		 h.setName(hospital.getName());
		if(hospital.getWeb()!=null)
		 h.setWeb(hospital.getWeb());
		if(hospital.getBranchs()!=null)
			h.setBranchs(hospital.getBranchs());
		em.merge(h);
		et.commit();
		return h;
		}
		return null;
	}

}
