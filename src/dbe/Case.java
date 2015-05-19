package dbe;

import time.Timestamp;

//@Elinor

public class Case extends DBE {
	private String type;
	private Byte department;
	private String noteInternal;
	private int employeeID;
	private int clientID;
	private String noteExternal;
	
	
	public Case(int id, Timestamp dateFrom, String name, String address,
			short zipCode, String type, Byte department, int employeeID, int clientID) {
		super(id, dateFrom, name, address, zipCode);
			this.type = type;
			this.department = department;
			this.employeeID = employeeID;
			this.clientID = clientID;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Byte getDepartment() {
		return this.department;
	}

	public void setDepartment(Byte department) {
		this.department = department;
	}

	public String getNoteInternal() {
		return this.noteInternal;
	}

	public void setNoteInternal(String noteInternal) {
		this.noteInternal = noteInternal;
	}

	public int getAccountable() {
		return this.employeeID;
	}

	public void setAccountable(int employeeID) {
		this.employeeID = employeeID;
	}

	public int getClient() {
		return this.clientID;
	}

	public void setClient(int clientID) {
		this.clientID = clientID;
	}

	public String getNoteExternal() {
		return this.noteExternal;
	}

	public void setNoteExternal(String noteExternal) {
		this.noteExternal = noteExternal;
	}
}