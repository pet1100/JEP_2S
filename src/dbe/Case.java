package dbe;

import time.Timestamp;

//@Elinor

public class Case extends DBE {
	private String type;
	private Byte department;
	private String noteInternal;
	private Employee accountable;
	private Client client;
	private String noteExternal;
	public Case(int id, Timestamp dateFrom, String name, String address,
			short zipCode, String type, Byte department, Employee accountable, Client client) {
		super(id, dateFrom, name, address, zipCode);
			this.type = type;
			this.department = department;
			this.accountable = accountable;
			this.client = client;
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

	public Employee getAccountable() {
		return this.accountable;
	}

	public void setAccountable(Employee accountable) {
		this.accountable = accountable;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getNoteExternal() {
		return this.noteExternal;
	}

	public void setNoteExternal(String noteExternal) {
		this.noteExternal = noteExternal;
	}
}