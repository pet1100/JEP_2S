package dbe;
//@Elinor

public class Prices {

	private byte quantity;
	private int price;
	private int type;
	private String headline;
	private String bodyText;
	public Prices(byte quantity,int price, int type){
	this.quantity = quantity;
	this.price = price;
	this.type = type;	
	}
	public byte getQuantity() {
		return this.quantity;
	}

	public void setQuantity(byte quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getHeadline() {
		return this.headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getBodyText() {
		return this.bodyText;
	}

	public void setBodyText(String bodyText) {
		this.bodyText = bodyText;
	}
}