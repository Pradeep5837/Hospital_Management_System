package com.ty.hospital.daoIml;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dao.AddressDAO;
import com.ty.hospital.dto.Address;
import com.ty.hospital.dto.Branch;
import com.ty.hospital.dto.Encounter;
import com.ty.hospital.service.AddressService;
import com.ty.hospital.service.BranchService;

public class AddressDAOImpl implements AddressDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pradeep");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public Address saveAddress(int b_id, Address address) {

		Branch b = em.find(Branch.class, b_id);
		if (b != null) {
			b.setAddress(address);
			et.begin();
			address.setBranches(b);
			em.persist(address);

			et.commit();
			et.begin();

			return address;
		}

		return null;
	}

	public Address getAddressById(int a_id) {
		Address e = em.find(Address.class, a_id);
		if (e != null) {
			return e;
		}
		return null;
	}

	public boolean deletAddressById(int a_id) {

		Address e = em.find(Address.class, a_id);
		if (e != null) {

			et.begin();
			em.remove(e);
			et.commit();
			return true;
		}
		return false;
	}

	public Address updateAddressById(int a_id, Address address) {
		Address e = em.find(Address.class, a_id);
		if (e != null) {
			if (address.getA_street() != null)
				e.setA_street(address.getA_street());
			if (address.getCantry() != null)
				e.setCantry(address.getCantry());
			if (address.getPin() >= 100)
				e.setPin(address.getPin());
			if (address.getState() != null)
				e.setState(address.getState());
			if (address.getBranches() != null) {
				e.setBranches(address.getBranches());
			}
			et.begin();
			em.merge(e);
			et.commit();

			return e;
		}
		return null;
	}

	public List<Address> getAllAddress() {

		Query q = em.createQuery("select a from Address a");
		List<Address> address = q.getResultList();

		return address;
	}

}
