package dbe;
//@Elinor

import java.util.Date;

import time.Timestamp;

public class DBE {

	private int id;
	private String name;
	private boolean active;
	private String address;
	private short zipCode;
	private String city;
	public DBE(int id, String name, String address, int zipCode){
		this.id = id;
		this.name = name;
		this.address = address; 
		this.zipCode = (short) zipCode;
		active = true;
		//String city;	skal hentes fra db	
	}
	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getActive() {
		return this.active;
	}

	public void setActive(boolean Active) {
		this.active = Active;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public short getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(short zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}