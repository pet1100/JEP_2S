package dbe;
//@Elinor

import java.util.ArrayList;
import java.util.*;


public class CaseList extends Case {

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