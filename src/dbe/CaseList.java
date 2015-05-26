package dbe;
//@Elinor

import java.util.*;

import time.Timestamp;


public class CaseList extends Case {

	public CaseList(int id, String name, String address,
			short zipCode, String type, Byte department, int employeeID,
			int clientID) {
		super(id, name, address, zipCode, type, department, employeeID,
				clientID);// nedarvet fra case class
			offerList = new ArrayList<Offer>();
			invoiceList = new ArrayList<Invoice>();
	}
	private ArrayList<Offer> offerList;
	private ArrayList<Invoice> invoiceList;


	

	public ArrayList<Offer> getOfferList() {
		return this.offerList;
	}

	public void setOfferList(ArrayList<Offer> offerList) {
		this.offerList = offerList;
	}

	public ArrayList<Invoice> getInvoiceList() {
		return this.invoiceList;
	}

	public void setInvoiceList(ArrayList<Invoice> invoiceList) {
		this.invoiceList = invoiceList;
	}
	public void addOffer(Offer offer){
		offerList.add(offer);	
	}
	public void addInvoice(Invoice invoice){
		invoiceList.add(invoice);
	}
}