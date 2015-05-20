package dbe;

import java.util.Date;

import time.Timestamp;
//@Elinor

public class Employee extends DBE {

	private int tlf;
	private String lastName;
	private byte userlevel;
	private String passWord;
	private String userName;
	public Employee(int id, Date dateFrom, String name, String address,
			short zipCode,int tlf, String lastName, byte userlevel, String passWord, String userName) {
		super(id, dateFrom, name, address, zipCode);
		this.tlf = tlf;
		this.lastName = lastName;
		this.userlevel = userlevel;
		this.passWord = passWord;
		this.userName = userName;
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

	public byte getUserlevel() {
		return this.userlevel;
	}

	public void setUserlevel(byte userlevel) {
		this.userlevel = userlevel;
	}

	public String getPassWord() {
		return this.passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}