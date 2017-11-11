package com.cg.frs.service;

import java.util.ArrayList;

import com.cg.frs.dto.FlatRegistrationDTO;
import com.cg.frs.exception.FlatRegistrationException;

public interface IFlatRegistrationService {

	int addDetails(FlatRegistrationDTO details);
	
	ArrayList<Integer> retrieveDetails();

	boolean validateOwnerId(int ownerId, ArrayList<Integer> list) throws FlatRegistrationException;

	boolean validateDepositAmount(float rent, float deposit);
	boolean validateRent(float rent);
	boolean validateArea(int flatArea);
	boolean validateType(int flatType);
}
