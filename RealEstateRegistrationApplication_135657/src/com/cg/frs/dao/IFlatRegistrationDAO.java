package com.cg.frs.dao;

import java.util.ArrayList;

import com.cg.frs.dto.FlatRegistrationDTO;

/*This interface abstracts the logic required 
 * to access the underlying data stored
 * 
 */
public interface IFlatRegistrationDAO {

	int addDetails(FlatRegistrationDTO details);
	ArrayList<Integer> retrieveDetails();

}
