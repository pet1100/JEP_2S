package DBE;
public class Offer extends Case {

	private int rentalDays;
	private ArrayList<Prices> price;

	public int getRentalDays() {
		return this.rentalDays;
	}

	public void setRentalDays(int rentalDays) {
		this.rentalDays = rentalDays;
	}

	public ArrayList<Prices> getPrice() {
		return this.price;
	}

	public void setPrice(ArrayList<Prices> price) {
		this.price = price;
	}
}