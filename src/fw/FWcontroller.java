package fw;



import dbe.DBAddress;
import dbe.DBE;

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
		create();	
	}

	private ResultSet resultat;

	public static void readCase(int id) {
		
		cs.read(id);
		
	}

	public ResultSet readAll(String type) {
		throw new UnsupportedOperationException();
	}

	public void update(DBE element) {
		throw new UnsupportedOperationException();
	}

	public static void  create() {
		cs.create();
	}

	public ResultSet getResultat() {
		return this.resultat;
	}

	public void setResultat(ResultSet resultat) {
		this.resultat = resultat;
	}
}