package fw;



import dbe.Case;
import dbe.Client;
import dbe.DBAddress;
import dbe.DBE;
import time.Timestamp;

import java.sql.*;

public class FWcontroller {
	public static  FWCase cs = new FWCase () ;
	public static FWCient ci = new FWCient ();
	static DBAddress db = new DBAddress();;
	static Connection con;
	public static void main(String[] args) throws SQLException {
				clientReadAll();
	
	}	
	
		
	

	private ResultSet resultat;

	public static ResultSet caseRead(int id) {
		
		return (cs.read(id));
		
	}
	public static ResultSet clientRead(int id) {
		
		return (ci.read(id));
		
	}

	public static ResultSet caseReadAll() {
		return(cs.readAll());
	}
	public static ResultSet clientReadAll() {
		return(ci.readAll());
	}


	public static void caseUpdate(Case c) {
		cs.update(c);
	}
	public static void clientUpdate(Client c) {
		ci.update(c);
	}

	public static Integer createCase() {
	
		return (cs.create());
	}
	public static Integer clientCreate() {
		
		return (ci.create());
	}


	public ResultSet getResultat() {
		return this.resultat;
	}

	public void setResultat(ResultSet resultat) {
		this.resultat = resultat;
	}
}
	