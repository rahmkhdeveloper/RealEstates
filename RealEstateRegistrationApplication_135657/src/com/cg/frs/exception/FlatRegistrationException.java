package com.cg.frs.exception;

public class FlatRegistrationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FlatRegistrationException(){
		
		System.err.println("\nOwner does not exist");
	}
}
