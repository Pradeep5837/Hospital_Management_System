package com.ty.hospital.daoIml;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dao.MedOrderDAO;
import com.ty.hospital.dto.Branch;
import com.ty.hospital.dto.Encounter;
import com.ty.hospital.dto.MedOrder;

public class MedorderDAOImpl implements MedOrderDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pradeep");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public MedOrder saveMedOrder(int e_id, MedOrder medOrder) {

		Encounter b = em.find(Encounter.class, e_id);
		if (b != null) {

			List<MedOrder> lm = b.getMedOrder();
			lm.add(medOrder);
			b.setMedOrder(lm);

			medOrder.setEncounters(b);
			et.begin();
			em.persist(medOrder);
			et.commit();
			return medOrder;
		}

		return null;
	}

	public MedOrder getMEdOrgerById(int m_id) {

		MedOrder m = em.find(MedOrder.class, m_id);
		if (m != null) {
			return m;
		}

		return null;
	}

	public boolean deletMedOrderById(int m_id) {

		MedOrder m = em.find(MedOrder.class, m_id);
		if (m != null) {

			et.begin();
			em.remove(m);
			et.commit();
			return true;
		}

		return false;
	}

	public MedOrder updateMedOrderById(int m_id, MedOrder medOrder) {

		MedOrder m = em.find(MedOrder.class, m_id);
		if (m != null) {

			if (medOrder.getdName() != null)
				m.setdName(medOrder.getdName());
			if (medOrder.getOrderDate() != null)
				m.setOrderDate(medOrder.getOrderDate());
			if (medOrder.getTotal() > 0)
				m.setTotal(medOrder.getTotal());
			if (medOrder.getItems() != null)
				m.setItems(medOrder.getItems());
			if (medOrder.getEncounters() != null)
				m.setEncounters(medOrder.getEncounters());
			et.begin();
			em.merge(m);
			et.commit();
			return m;
		}
		return null;
	}

	public List<MedOrder> getAllMedorder() {

		Query q = em.createQuery("select m from MedOrder m");
		List<MedOrder> medOrders = q.getResultList();
		return medOrders;
	}

	public List<MedOrder> getMedorderByDoctorName(String name) {

		Query q = em.createQuery("select m from MedOrder m where m.dName=?1");
		q.setParameter(1, name);
		List<MedOrder> medOrders = q.getResultList();

		return medOrders;
	}

	public List<MedOrder> getMedOrderByDate(String date) {
		Query q = em.createQuery("select m from MedOrder m where m.orderDate=?1");
		q.setParameter(1, date);
		List<MedOrder> medOrders = q.getResultList();

		return medOrders;
	}

}
