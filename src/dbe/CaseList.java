package dbe;
//@Elinor

import java.util.*;

import time.Timestamp;


public class CaseList extends Case {

	private ArrayList<Offer> offerList;
	private ArrayList<Invoice> invoiceList;

	public CaseList(int id, Timestamp dateFrom, String name, String address,
			short zipCode, String type, Byte department, Employee accountable,
			Client client) {
		super(id, dateFrom, name, address, zipCode, type, department, accountable,
				client);// nedarvet fra case class
		offerList = new ArrayList<Offer>();
		invoiceList = new ArrayList<Invoice>();
	}
	

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