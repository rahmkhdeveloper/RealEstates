package com.cg.frs.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.frs.dto.FlatRegistrationDTO;
import com.cg.frs.util.DBUtil;



  

public class FlatRegistrationDAOImpl implements IFlatRegistrationDAO{

	Connection con = null;
	Logger logger = Logger.getRootLogger();
	
	
	public FlatRegistrationDAOImpl(){
		
		PropertyConfigurator.configure("log4j.properties");
	}
	
	
	int result = 0, roomNo = 0;
	
	
	
	/***************************************************************************************
	 *
	 *Function Name						:addDetails()
	 *Initial Parameters				:details
	 *Return Type						:Integer
	 *Throws							:							
	 *Author							:Rahul Mukherjee
	 *Creation Date       				:27/09/2017
	 *Description 						:insert data into the DataBase.	
	 *			
	 ****************************************************************************************/

	@Override
	public int addDetails(FlatRegistrationDTO details) {
		// TODO Auto-generated method stub

		
		
		try {
			
			
			con = DBUtil.getConnection();
			String insertQuery = "INSERT INTO Flat_Registration VALUES(FLAT_SEQ.nextval,?,?,?,?,?)";
			PreparedStatement psi = con.prepareStatement(insertQuery);
			
			
			psi.setInt(1, details.getOwnerid());
			psi.setInt(2, details.getFlatType());
			psi.setInt(3, details.getFlatArea());
	        psi.setFloat(4, details.getRent());
	        psi.setFloat(5, details.getDeposit());
		
	        	result = psi.executeUpdate();
	        	//System.out.println(result+" rows inserted\n");
	        	logger.info("Executed successfully");
	        	
	        	
	        String selectquery = "SELECT FLAT_SEQ.currval FROM Flat_Registration";
	
			PreparedStatement ps = con.prepareStatement(selectquery);
			ResultSet rs = ps.executeQuery();
		
			while(rs.next()){
				roomNo = rs.getInt(1);
			}
		}
		catch (IOException|SQLException e) {
			logger.error("Exception Occurred in DAO layer"+e.getMessage());
			System.out.println(e.getMessage()+"\n\n");
		}
	
		return roomNo;

	}

	
	/***************************************************************************************
	 *
	 *Function Name						:retrieveDetails()
	 *Initial Parameters				:				
	 *Return Type						:ArrayList<Integer>
	 *Throws							:							
	 *Author							:Rahul Mukherjee
	 *Creation Date						:27/09/2017
	 *Description						:fetching data from the DataBase.
	 *				
	 ****************************************************************************************/
	
	@Override
	public ArrayList<Integer> retrieveDetails() {
		// TODO Auto-generated method stub

		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int id=0;

		try {
			con = DBUtil.getConnection();
			
			String selectquery1 = "SELECT OWNER_ID FROM FLAT_OWNERS";
			
			PreparedStatement ps = con.prepareStatement(selectquery1);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				
				id = rs.getInt(1);
				list.add(id);
			}
			
			
		} 
		
		catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			logger.error("Exception Occurred in DAO layer"+e.getMessage());
			System.out.println(e.getMessage()+"\n\n");
		}
		
		return list;
	}

	
}
