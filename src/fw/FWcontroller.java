package fw;
import java.sql.ResultSet;

import dbe.*;
import java.sql.*;

public class FWcontroller {

	private ResultSet resultat;

	public DBE read(int id, String type) {
		throw new UnsupportedOperationException();
	}

	public ResultSet readAll(String type) {
		throw new UnsupportedOperationException();
	}

	public void update(DBE element) {
		throw new UnsupportedOperationException();
	}

	public int create() {
		throw new UnsupportedOperationException();
	}

	public ResultSet getResultat() {
		return this.resultat;
	}

	public void setResultat(ResultSet resultat) {
		this.resultat = resultat;
	}
}