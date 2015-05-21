package dbe;

import java.util.Date;

import time.Timestamp;

//@Elinor

public class Invoice extends Case {
	private byte tax;
	private int total;
	public Invoice(int id, Date date, String name, String address,
			short zipCode, String type, Byte department, int employeeID,
			int clientID) {
		super(id, date, name, address, zipCode, type, department, employeeID,
				clientID);
		// TODO Auto-generated constructor stub
	}





	public byte getTax() {
		return this.tax;
	}

	public void setTax(byte tax) {
		this.tax = tax;
	}

	public int getTotal() {
		return this.total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}