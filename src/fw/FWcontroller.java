package fw;



import dbe.Case;
import dbe.DBAddress;
import dbe.DBE;
import time.Timestamp;

import java.sql.*;

public class FWcontroller {
	public static  FWCase cs = new FWCase () ;
	static DBAddress db = new DBAddress();;
	static Connection con;
	public static void main(String[] args) throws SQLException {
		
		
//		try {
//			Statement s = null;
//			Class.forName(db.getJDBC_DRIVER());
//			con = DriverManager.getConnection(db.getDATABASE_URL(), "root",
//					"hejhej123");
//			s = con.createStatement();
//			ResultSet rs = s.executeQuery("SELECT * from postnr where Postnr = 4060");
//
//			if (rs != null)
//				while (rs.next()) {
//					System.out.println("Postnr: " + rs.getString(1)
//							+ " " + rs.getString("BYNAVN") + " "
//							+ rs.getInt("Postnr"));
//				}
//			con.close();
//			s.close();
//		} catch (SQLException sqlex) {
//			try {
//				System.out.println(sqlex.getMessage());
//				con.close();
//				System.exit(1); // terminate program
//			} catch (SQLException sql) {
//			}
//		} catch (ClassNotFoundException noClass) {
//			System.err.println("Driver Class not found");
//			System.out.println(noClass.getMessage());
//			System.exit(1); // terminate program
//		}
//		readCase(6);
		
//
//		Case c = new Case(createCase(), Timestamp.getTimeNow(), "ydre-stillads ", "Bygmarken 108 ", 4060, "nub", null , 1, 1);
//		c.setNoteInternal("hej med dig dette er en notat");
//		update(c);
//		
		
		readCase(43);
		
	}

	private ResultSet resultat;

	public static void readCase(int id) {
		
		cs.read(id);
		
	}

	public ResultSet readAll(String type) {
		throw new UnsupportedOperationException();
	}

	public static void update(Case c) {
		cs.update(c);
	}

	public static Integer createCase() {
	
		return (cs.create());
	}

	public ResultSet getResultat() {
		return this.resultat;
	}

	public void setResultat(ResultSet resultat) {
		this.resultat = resultat;
	}
}