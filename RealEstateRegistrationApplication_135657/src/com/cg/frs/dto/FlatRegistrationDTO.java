package com.cg.frs.dto;

public class FlatRegistrationDTO {

	
	private int ownerid, flatType, flatArea;
	private float  rent, deposit;
	
	
	//GETTERS AND SETTERS
	public int getOwnerid() {
		return ownerid;
	}
	public void setOwnerid(int ownerid) {
		this.ownerid = ownerid;
	}
	public int getFlatType() {
		return flatType;
	}
	public void setFlatType(int flatType) {
		this.flatType = flatType;
	}
	public int getFlatArea() {
		return flatArea;
	}
	public void setFlatArea(int flatArea) {
		this.flatArea = flatArea;
	}
	public float getRent() {
		return rent;
	}
	public void setRent(float rent) {
		this.rent = rent;
	}
	public float getDeposit() {
		return deposit;
	}
	public void setDeposit(float deposit) {
		this.deposit = deposit;
	}
	
	
	
	//PARAMETERIZED CONSTRUCTOR
	public FlatRegistrationDTO(int ownerid, int flatType, int flatArea,
			float rent, float deposit) {
		super();
		this.ownerid = ownerid;
		this.flatType = flatType;
		this.flatArea = flatArea;
		this.rent = rent;
		this.deposit = deposit;
	}
	
	//DEFAULT CONSTRUCTOR
	public FlatRegistrationDTO() {}
	
	
	
	
	
}
