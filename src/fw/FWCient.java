package fw;


import dbe.Client;

import java.sql.*;

import com.sun.rowset.CachedRowSetImpl;


public class FWCient extends dbe.DBAddress {

	private Connection con;
	 Integer numero=0;
	Integer  clientid = -1;
	

	public ResultSet read(int id) {
		
		ResultSet rs = null;
		CachedRowSetImpl crs = null;
		
		try {
			Statement s = null;
			Class.forName(getJDBC_DRIVER());
			con = DriverManager.getConnection(getDATABASE_URL(), getUsername(),
					getpassword());
			s = con.createStatement();
			 rs = s.executeQuery("Select * from Kunder WHERE Kunde_Id = '"+id+"' ");

			 crs = new CachedRowSetImpl();
			 crs.populate(rs);
			
			con.close();
			s.close();
		} catch (SQLException sqlex) {
			try {
				System.out.println(sqlex.getMessage());
				con.close();
				System.exit(1); // terminate program
			} catch (SQLException sql) {
			}
		} catch (ClassNotFoundException noClass) {
			System.err.println("Driver Class not found");
			System.out.println(noClass.getMessage());
			System.exit(1); // terminate program
		} 
		return crs; // id(skal du ikkebruge navn efternavn tlf email adresse postnr dato
		
	
	}

	public Client update(Client name) {
		
		try {
			Statement s = null;
			Class.forName(getJDBC_DRIVER());
			con = DriverManager.getConnection(getDATABASE_URL(), getUsername(),
					getpassword());
			s = con.createStatement();
			
			System.out.println(name.getId() + " " + name.getName() + " " + name.getTlf());
	
			 String query = "update kunder set Kunde_navn = ?, Kunde_EfterNavn = ?, Kunde_Tlf = ?, Kunde_Email = ?, Fk_postnr = ? "
			 		+ " where Kunde_Id = "+name.getId()+"";
		      PreparedStatement preparedStmt = con.prepareStatement(query);
		      preparedStmt.setString(1, name.getName());
		      preparedStmt.setString(2, name.getLastName());
		      preparedStmt.setInt(3, name.getTlf());
		      preparedStmt.setString(4, name.getEmail());
		      preparedStmt.setInt(5, name.getZipCode());
		 
		      
		     
		     
		      preparedStmt.execute();
		 
		      
		

		     
		   
			
			con.close();
			s.close();
			
		} catch (SQLException sqlex) {
			try {
				System.out.println(sqlex.getMessage());
				con.close();
				System.exit(1); // terminate program
			} catch (SQLException sql) {
			}
		} catch (ClassNotFoundException noClass) {
			System.err.println("Driver Class not found");
			System.out.println(noClass.getMessage());
			System.exit(1); // terminate program
		}
		return name;
		
	}

	public int create() {
		java.util.Date today = new java.util.Date();
		java.sql.Timestamp ts1 = new java.sql.Timestamp(today.getTime());
		ResultSet rs ;
		try {
			Statement s = null;
			Class.forName(getJDBC_DRIVER());
			con = DriverManager.getConnection(getDATABASE_URL(), getUsername(),
					getpassword());
			s = con.createStatement();
	
			 String query = ("INSERT INTO kunder (Kunde_Dato)  VALUES (?)");
			
			 PreparedStatement preparedStmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			 preparedStmt.setTimestamp(1, ts1);
			 
			 
		    
		      
		     
		     
		      preparedStmt.execute();
		   rs = preparedStmt.getGeneratedKeys();
		     if (rs.next()){
		    	 clientid = rs.getInt(1);
		           
		        }
		      
		

		     
		   
			rs.close();
			con.close();
			s.close();
			System.out.println("sat ind");
		} catch (SQLException sqlex) {
			try {
				System.out.println(sqlex.getMessage());
				con.close();
				System.exit(1); // terminate program
			} catch (SQLException sql) {
			}
		} catch (ClassNotFoundException noClass) {
			System.err.println("Driver Class not found");
			System.out.println(noClass.getMessage());
			System.exit(1); // terminate program
		}
		return clientid;
	}

	public ResultSet readAll() {
		
		ResultSet rs = null;
		CachedRowSetImpl crs = null;
		
		try {
			Statement s = null;
			Class.forName(getJDBC_DRIVER());
			con = DriverManager.getConnection(getDATABASE_URL(), getUsername(),
					getpassword());
			s = con.createStatement();
			 rs = s.executeQuery("select kunder.Kunde_Navn,  kunder.Kunde_EfterNavn,  kunder.Kunde_Tlf,   kunder.Kunde_Email,  kunder.Kunde_Adresse,  kunder.Kunde_Dato, postnr.postnr, postnr.By, kunder.Kunde_Id from kunder"
			 		+ " left join postnr on postnr.postnr = kunder.Fk_postnr "
			 		+ " order by Kunde_Id");

			 crs = new CachedRowSetImpl();
			 crs.populate(rs);


			
			con.close();
			s.close();
		} catch (SQLException sqlex) {
			try {
				System.out.println(sqlex.getMessage());
				con.close();
				System.exit(1); // terminate program
			} catch (SQLException sql) {
			}
		} catch (ClassNotFoundException noClass) {
			System.err.println("Driver Class not found");
			System.out.println(noClass.getMessage());
			System.exit(1); // terminate program
		} 
		return crs; // emne notat oprettelsesdato aktiv sag_adresse sagpostnr bynavn kunde_navn kunde_efternavn kundetlf kunde_email medarbejder_navn medarbejder_efternavn
	}
}