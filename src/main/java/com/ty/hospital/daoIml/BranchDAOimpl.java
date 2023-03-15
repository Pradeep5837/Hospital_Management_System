package com.ty.hospital.daoIml;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import javax.persistence.Query;
import com.ty.hospital.dao.BranchDAO;
import com.ty.hospital.dto.Branch;
import com.ty.hospital.dto.Hospital;
import com.ty.hospital.service.AddressService;

public class BranchDAOimpl implements BranchDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pradeep");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public Branch saveBranch(int h_id, Branch branch) {

		Hospital h = em.find(Hospital.class, h_id);
		
		if (h != null) {
			
			List<Branch> a=h.getBranchs();
			a.add(branch);
			h.setBranchs(a);
			branch.setHospitals(h);
			et.begin();
			em.persist(branch);
			et.commit();
			
			et.begin();
			
			return branch;
		}
		return null;
	}

	public Branch getBranchById(int b_id) {

		Branch b = em.find(Branch.class, b_id);
		if (b != null) {
			return b;
		}
		return null;
	}

	public boolean deletBranchById(int b_id) {

		Branch b = em.find(Branch.class, b_id);
		if (b != null) {
			et.begin();
			em.remove(b);
			et.commit();
			return true;
		}

		return false;
	}

	public Branch updateBranch(int b_id, Branch branch) {

		Branch b = em.find(Branch.class, b_id);
		if (b != null) {
			if (branch.getB_name() != null) {
				b.setB_name(branch.getB_name());
			}
			if (branch.getB_phno() >= 100) {
				b.setB_phno(branch.getB_phno());
			}
			if (branch.getEmail() != null) {
				b.setEmail(branch.getEmail());
			}
			if (branch.getHospitals() != null) {
				b.setHospitals(branch.getHospitals());
			}
			if(branch.getAddress()!=null)
				b.setAddress(branch.getAddress());
			if(branch.getEncounters()!=null)
				b.setEncounters(branch.getEncounters());
			
			et.begin();
			em.merge(b);
			et.commit();
			return b;

		}
		return null;
	}

	public List<Branch> getAllBranchs() {

		Query q = em.createQuery("select b from Branch b");

		List<Branch> branches = q.getResultList();
		return branches;
	}

}
