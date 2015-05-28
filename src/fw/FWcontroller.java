package fw;
//@Jannik E.


import java.sql.Connection;
import java.sql.ResultSet;

import dbe.Case;
import dbe.Client;
import dbe.DBAddress;
import dbe.Employee;

public class FWcontroller {
	public static  FWCase cs = new FWCase () ; // Controller for Case
	public static FWCient ci = new FWCient ();// Controller for Client
	public static FWEmployee em = new FWEmployee();// Controller for Employe
	static DBAddress db = new DBAddress();;// Controller for DBA
	static Connection con;
	
	
// read methods
	public static ResultSet caseRead(int id) { //reads case where the caseid is the same as the parameter id
		
		return (cs.read(id));
		
	}
	public static ResultSet clientRead(int id) { 
		
		return (ci.read(id));
		
	}
	public static ResultSet employeeRead(int id) {
		
		return (em.read(id));
		
	}
	
	// Read all methods

	public static ResultSet caseReadAll() {
		return(cs.readAll());
	}
	public static ResultSet clientReadAll() {
		return(ci.readAll());
	}
	public static ResultSet employeeReadAll() {
		return(em.readAll());
	}

// update Methods
	public static void caseUpdate(Case c) {
		cs.update(c);
	}
	public static void clientUpdate(Client c) {
		ci.update(c);
	}
	public static void empoyeeUpdate(Employee c) {
		em.update(c);
	}

	
	//Create Methods
	public static Integer createCase() {
	
		return (cs.create());
	}
	public static Integer clientCreate() {
		
		return (ci.create());
	}
	public static Integer employeeCreate() {
		
		return (em.create());
	}

}
	