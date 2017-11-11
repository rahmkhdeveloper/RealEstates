package com.cg.frs.ui;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.frs.dto.FlatRegistrationDTO;
import com.cg.frs.exception.FlatRegistrationException;
import com.cg.frs.service.FlatRegistrationServiceImpl;
import com.cg.frs.service.IFlatRegistrationService;

public class Client {

	
	static FlatRegistrationDTO dto = null;
	static IFlatRegistrationService service = null;
	
	static Client clientObject = new Client();
	
	
	
	
	Logger logger = Logger.getRootLogger();
	
	public Client(){
		
		PropertyConfigurator.configure("log4j.properties");
	}
	
	
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args){
		// TODO Auto-generated method stub

		while(true){
			
			System.out.println("Flat Registration Service");
			System.out.println("***********************************");
			System.out.print("Enter your choice\n");
			System.out.println("1.Register Flat\t\t2.Exit");
			
			
			int choice = sc.nextInt();
	
			switch(choice){
			case 1:
				clientObject.addDetails();
				break;
			
			case 2:
				System.exit(0);
				break;
			default:
				System.out.println("Enter valid choice\n\n");
			}
		}
	}


	private void addDetails(){
		
		int res = 0;
		
		sc = new Scanner(System.in);
		service = new FlatRegistrationServiceImpl();
		
		ArrayList<Integer> list = service.retrieveDetails();
		System.out.println("Existing Owner IDS Are: "+list);
		
		
		try{
			
			
			System.out.println("Please enter your owner id from above list:");
			int ownerId = sc.nextInt();
		

			if(service.validateOwnerId(ownerId, list)){
				System.out.println("Select  Flat Type (1-1BHK, 2-2BHK):");
				int flatType = sc.nextInt();
				
				
					if(service.validateType(flatType)){
						System.out.println("Enter Flat area in sq. ft.: ");
						int flatArea = sc.nextInt();
				
						
						if(service.validateArea(flatArea)){
							System.out.println("Enter desired rent amount Rs: ");
							float rent = sc.nextFloat();
						
							
							if(service.validateRent(rent)){
								System.out.println("Enter desired deposit amount Rs: ");
								float deposit = sc.nextFloat();
							
								
								if(service.validateDepositAmount(rent, deposit)){
								
									
									dto = new FlatRegistrationDTO(ownerId, flatType, flatArea, rent, deposit);
									res = service.addDetails(dto);
									
									
									if(res > 0){
									
										System.out.println("\n\n***************************************************");
										System.out.print("Flat Successfully registered.");
										System.out.println("Registration id: <"+res+">");
										System.out.println("****************************************************\n\n");
										
									}
									else
									{
										System.out.println("Flat registeration Unsuccessful.\n\n");
									
									}
								}	
							}
						}
					}
				}	
			}
			catch(FlatRegistrationException e){
		
				logger.error("Exception occurred in UI layer");
				System.out.println(e+"\n\n");
			}
	}
}
