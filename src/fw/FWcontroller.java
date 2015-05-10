package fw;
import DBE.DBE;

public class FWcontroller {

	private resultset resultat;

	public DBE read(int id, string type) {
		throw new UnsupportedOperationException();
	}

	public resultset readAll(string type) {
		throw new UnsupportedOperationException();
	}

	public void update(DBE element) {
		throw new UnsupportedOperationException();
	}

	public int create() {
		throw new UnsupportedOperationException();
	}

	public resultset getResultat() {
		return this.resultat;
	}

	public void setResultat(resultset resultat) {
		this.resultat = resultat;
	}
}