package fw;


import dbe.Client;

import java.sql.*;


public class FWCient extends dbe.DBAddress {

	private Connection con;
	 Integer numero=0;
	Integer  clientid = -1;
	

	public ResultSet read(int id) {
		
		ResultSet rs = null;
		try {
			Statement s = null;
			Class.forName(getJDBC_DRIVER());
			con = DriverManager.getConnection(getDATABASE_URL(), getUsername(),
					getpassword());
			s = con.createStatement();
			 rs = s.executeQuery("Select sager.Sager_emne, sager.Sager_Notat, sager.Sager_OprettetDato, sager.Sager_Aktiv, sager.Sager_Adresse, postnr.postnr, postnr.BYNAVN, kunder.Kunde_navn, kunder.Kunde_EfterNavn, kunder.Kunde_Tlf, kunder.Kunde_Email, medarbejder.Medarbejder_Navn, medarbejder.Medarbejder_EfterNavn  from sager"
				+	" join postnr on sager.FK_postnr = postnr.postnr"
				+	" join kunder on sager.Fk_kunde = kunder.Kunde_Id"
				+	" join medarbejder on sager.Fk_Ansvarlig = Medarbejder_Id where sager.Sager_Id = '"+id+"' ");






			
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
		return rs; // id(skal du ikkebruge navn efternavn tlf email adresse postnr dato
		
	
	}

	public Client update(Client name) {
		
		try {
			Statement s = null;
			Class.forName(getJDBC_DRIVER());
			con = DriverManager.getConnection(getDATABASE_URL(), getUsername(),
					getpassword());
			s = con.createStatement();
	
			 String query = "update kunder set Kunde_navn = ?, Kunde_EfterNavn = ?, Kunde_Tlf = ?, Kunde_Email = ?, Fk_postnr = ?, "
			 		+ " where Kunde_Id = ("+name.getId()+")";
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
		try {
			Statement s = null;
			Class.forName(getJDBC_DRIVER());
			con = DriverManager.getConnection(getDATABASE_URL(), getUsername(),
					getpassword());
			s = con.createStatement();
			 rs = s.executeQuery("select kunder.Kunde_Navn,  kunder.Kunde_EfterNavn,  kunder.Kunde_Tlf,   kunder.Kunde_Email,  kunder.Kunde_Adresse,  kunder.Kunde_Dato, postnr.postnr, postnr.BYNAVN from kunder"
			 		+ "join postnr where kunder.Fk_postnr = postnr.postnr");


 




while(rs.next())
{
	System.out.println(rs.getString(1));// test
}

			
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
		return rs; // emne notat oprettelsesdato aktiv sag_adresse sagpostnr bynavn kunde_navn kunde_efternavn kundetlf kunde_email medarbejder_navn medarbejder_efternavn
	}
}