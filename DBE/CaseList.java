package DBE;
import java.

import f

public class CaseList extends Case {

	private ArrayList<Offer> offerList;
	private ArrayList<invoice> invoiceList;

	public ArrayList<Offer> getOfferList() {
		return this.offerList;
	}

	public void setOfferList(ArrayList<Offer> offerList) {
		this.offerList = offerList;
	}

	public ArrayList<invoice> getInvoiceList() {
		return this.invoiceList;
	}

	public void setInvoiceList(ArrayList<invoice> invoiceList) {
		this.invoiceList = invoiceList;
	}
}