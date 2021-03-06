package dbe;

// @Elinor

import java.util.ArrayList;

public class Offer extends Case
{
	private int rentalDays;
	private ArrayList<Prices> priceList;

	public Offer(int id, String name, String address, short zipCode,
			String type, Byte department, int employeeID, int clientID,
			int rentalDays)
	{
		super(id, name, address, zipCode, type, department, employeeID,
				clientID);// nedarvet fra dbe class
		this.rentalDays = rentalDays;
		priceList = new ArrayList<Prices>();
	}

	public int getRentalDays()
	{
		return this.rentalDays;
	}

	public void setRentalDays(int rentalDays)
	{
		this.rentalDays = rentalDays;
	}

	public ArrayList<Prices> getPriceList()
	{
		return this.priceList;
	}

	public void setPrice(ArrayList<Prices> price)
	{
		this.priceList = price;
	}

	public void addPrice(Prices newPrice)
	{
		priceList.add(newPrice);
	}
}