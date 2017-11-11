package com.cg.frs.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.frs.dao.FlatRegistrationDAOImpl;
import com.cg.frs.dao.IFlatRegistrationDAO;
import com.cg.frs.dto.FlatRegistrationDTO;
import com.cg.frs.exception.FlatRegistrationException;


public class RealEstateRegistrationTest {

	static IFlatRegistrationDAO dao = null;
	static FlatRegistrationDTO bean = null;
	
	
	@BeforeClass
	public static void initialize(){
		System.out.println("Object created");
		dao = new FlatRegistrationDAOImpl();
		bean = new FlatRegistrationDTO();
		
	}
	
	@Test
	public void testaddDetails()throws SQLException, IOException, FlatRegistrationException {
	
		assertNotNull(dao.addDetails(bean));
	}

	@Test
	public void getDetails()throws FlatRegistrationException{
	
		assertNotNull(dao.retrieveDetails());
	}
	

}
