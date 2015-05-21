package fw;



import dbe.Case;
import dbe.DBAddress;
import dbe.DBE;
import time.Timestamp;

import java.sql.*;

import com.mysql.jdbc.UpdatableResultSet;

public class FWcontroller {
	public static  FWCase cs = new FWCase () ;
	static DBAddress db = new DBAddress();;
	static Connection con;
	public static void main(String[] args) throws SQLException {
		
	
		
		readCase(43);
		
	}

	private ResultSet resultat;

	public static void readCase(int id) {
		
		cs.read(id);
		
	}

	public ResultSet readAll() {
		return (cs.readAll());
	}

	public static void update(Case c) {
		cs.update(c);
	}

	public static Integer createCase() {
	
		return (cs.create());
	}
}

