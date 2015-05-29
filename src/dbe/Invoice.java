package dbe;

// @Elinor

public class Invoice extends Case
{
	private byte tax;
	private int total;

	public Invoice(int id, String name, String address, short zipCode,
			String type, Byte department, int employeeID, int clientID)
	{
		super(id, name, address, zipCode, type, department, employeeID,
				clientID);// nedarvet fra dbe case

	}

	public byte getTax()
	{
		return this.tax;
	}

	public void setTax(byte tax)
	{
		this.tax = tax;
	}

	public int getTotal()
	{
		return this.total;
	}

	public void setTotal(int total)
	{
		this.total = total;
	}
}