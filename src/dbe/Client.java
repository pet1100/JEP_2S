package dbe;

import java.util.Date;

import time.Timestamp;
//@Elinor

public class Client extends DBE {
	private int tlf;
	private String lastName;
	private String email;
	public Client(int id, String name, String address,
			short zipCode, int tlf, String lastName, String email) {
		super(id, name, address, zipCode);// nedarvet fra dbe class
		this.tlf = tlf;
		this.lastName = lastName;
		this.email = email;
	}


	public int getTlf() {
		return this.tlf;
	}

	public void setTlf(int tlf) {
		this.tlf = tlf;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}