package com.ty.hospital.service;

import java.util.List;

import com.ty.hospital.dao.BranchDAO;
import com.ty.hospital.daoIml.BranchDAOimpl;
import com.ty.hospital.dto.Branch;

public class BranchService {

	BranchDAO bimpl = new BranchDAOimpl();

	public void saveBranch(int h_id, Branch branch) {

		Branch b = bimpl.saveBranch(h_id, branch);
		if (b != null) {
			System.out.println("Branch data saved");
		} else {
			System.err.println("Branch data not saved");
		}
	}

	public Branch getBranchById(int id) {

		Branch b = bimpl.getBranchById(id);
		if (b != null) {
			return b;
		}
		return null;
	}

	public void deletBranchById(int id) {

		if (bimpl.deletBranchById(id)) {
			System.out.println("Branch deleted ");
		} else {
			System.err.println("Branch not deleted");
		}

	}

	public void updateBrabchById(int id, Branch branch) {

		Branch b = bimpl.updateBranch(id, branch);
		if (b != null)
			System.out.println("branch data updated");
		else
			System.err.println("Branch data not updated");

	}

	public List<Branch> getAllBranch() {

		List<Branch> l = bimpl.getAllBranchs();
		return l;
	}
}
