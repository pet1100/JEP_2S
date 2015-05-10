package dbe;
import Timestamp;

public class DBE {

	private int id;
	private Timestamp dateFrom;
	private String name;
	private boolean active;
	private String address;
	private short zipCode;
	private string city;

	public int getId() {
		return this.id;
	}

	public Timestamp getDateFrom() {
		return this.dateFrom;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getActive() {
		return this.active;
	}

	public void setActive(boolean Active) {
		this.active = Active;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public short getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(short zipCode) {
		this.zipCode = zipCode;
	}

	public string getCity() {
		return this.city;
	}

	public void setCity(string city) {
		this.city = city;
	}
}