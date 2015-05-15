package dbe;
//@Elinor

import java.util.ArrayList;
import java.util.*;

public class Offer extends Case {

	private int rentalDays;
	private ArrayList<Prices> priceList;

	public int getRentalDays() {
		return this.rentalDays;
	}

	public void setRentalDays(int rentalDays) {
		this.rentalDays = rentalDays;
	}

	public ArrayList<Prices> getPriceList() {
		return this.priceList;
	}

	public void setPrice(ArrayList<Prices> price) {
		this.priceList = price;
	}
	
	public void addPrice(Prices newPrice){
		priceList.add(newPrice);
	}
}