package dbe;
public class Client extends DBE {

	private int tlf;
	private String lastName;
	private String email;

	public int getTlf() {
		return this.tlf;
	}

	public void setTlf(int tlf) {
		this.tlf = tlf;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}