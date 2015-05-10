package dbe;
public class invoice extends Case {

	private byte tax;
	private int total;

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