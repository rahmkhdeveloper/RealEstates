package com.cg.frs.service;

import java.util.ArrayList;

import com.cg.frs.dao.FlatRegistrationDAOImpl;
import com.cg.frs.dao.IFlatRegistrationDAO;
import com.cg.frs.dto.FlatRegistrationDTO;
import com.cg.frs.exception.FlatRegistrationException;

public class FlatRegistrationServiceImpl implements IFlatRegistrationService {


	IFlatRegistrationDAO dao = null;
	

	/***************************************************************************************
	 *
	 *Function Name						:addDetails()
	 *Initial Parameters				:				
	 *Return Type						:Integer
	 *Throws							:							
	 *Author							:Rahul Mukherjee
	 *Creation Date						:27/09/2017
	 *Description						:Concerned with processing and transformation of application data.
	 *				
	 ****************************************************************************************/
	
	@Override
	public int addDetails(FlatRegistrationDTO details) {
		// TODO Auto-generated method stub
		
		dao = new FlatRegistrationDAOImpl();
		return dao.addDetails(details);
	}


	/***************************************************************************************
	 *
	 *Function Name						:retrieveDetails()
	 *Initial Parameters				:				
	 *Return Type						:ArrayList<Integer>
	 *Throws							:							
	 *Author							:Rahul Mukherjee
	 *Creation Date						:27/09/2017
	 *Description						:Concerned with retrieval and management of application data.
	 *				
	 ****************************************************************************************/
	
	public ArrayList<Integer> retrieveDetails() {
		// TODO Auto-generated method stub
		
		dao = new FlatRegistrationDAOImpl();
		return dao.retrieveDetails();
	}
	
	
	
	
	
	@Override
	public boolean validateOwnerId(int ownerId, ArrayList<Integer> list) throws FlatRegistrationException {
		// TODO Auto-generated method stub
		if(list.contains(ownerId)){
			return true;
		}
		else{
			throw new FlatRegistrationException();
		}
	}

	
	@Override
	public boolean validateArea(int flatArea) {
		// TODO Auto-generated method stub
		if(flatArea>0){
			return true;
		}
		else {
			System.out.println("Invalid input for flat Area\n\n");
			return false;
		}
			
	}


	@Override
	public boolean validateType(int flatType) {
		// TODO Auto-generated method stub
		if(flatType == 1 || flatType == 2){
			return true;
		}
		else{
			System.out.println("Enter valid flat Type\n\n");
			return false;
		}
	}


	@Override
	public boolean validateRent(float rent) {
		// TODO Auto-generated method stub
		if(rent>0){
			return true;
		}
		else{
			System.out.println("Invalid rent amount");
			return false;
		}
	
	}

	@Override
	public boolean validateDepositAmount(float rent, float deposit) {
		// TODO Auto-generated method stub
		if(rent<deposit && deposit>0){
			return true;
		}
		else {
			System.out.println("deposited amount should be greater than rent\n\n");
			return false;
		}
	}

	
	

}
