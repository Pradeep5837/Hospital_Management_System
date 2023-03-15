package com.ty.hospital.dao;

import java.util.List;

import com.ty.hospital.dto.Branch;

public interface BranchDAO {
	
	Branch saveBranch(int h_id,Branch branche);
	Branch getBranchById(int b_id);
	boolean deletBranchById(int b_id);
	Branch updateBranch(int b_id,Branch branch);
	List<Branch> getAllBranchs();

}
