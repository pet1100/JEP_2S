package dbe;
public class Employee extends DBE {

	private int tlf;
	private String lastName;
	private byte userlevel;
	private string passWord;
	private string userName;

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

	public byte getUserlevel() {
		return this.userlevel;
	}

	public void setUserlevel(byte userlevel) {
		this.userlevel = userlevel;
	}

	public string getPassWord() {
		return this.passWord;
	}

	public void setPassWord(string passWord) {
		this.passWord = passWord;
	}

	public string getUserName() {
		return this.userName;
	}

	public void setUserName(string userName) {
		this.userName = userName;
	}
}