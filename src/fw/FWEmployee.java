package fw;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dbe.*;

import java.sql.*;

import com.sun.rowset.CachedRowSetImpl;
public class FWEmployee extends DBAddress {

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
			 rs = s.executeQuery("Select * from Medarbejder WHERE Medarbejder_Id = '"+id+"' "
			 		+ " order by Medarbejder_Id");

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

	public Employee update(Employee name) {
		
		try {
			Statement s = null;
			Class.forName(getJDBC_DRIVER());
			con = DriverManager.getConnection(getDATABASE_URL(), getUsername(),
					getpassword());
			s = con.createStatement();
			
			 String query = "update Medarbejder set Medarbejder_Navn = ?, Medarbejder_EfterNavn = ?, Medarbejder_Password = ?, FK_postnr = ?, Medarbejder_Adresse = ? "
			 		+ " where medarbejder_Id = ("+name.getId()+")";
		      PreparedStatement preparedStmt = con.prepareStatement(query);
		      preparedStmt.setString(1, name.getName());
		      preparedStmt.setString(2, name.getLastName());
		      preparedStmt.setString(3, name.getPassWord());
		      preparedStmt.setInt(4, name.getZipCode());
		      preparedStmt.setString(5, name.getAddress());
		 
		      
		     
		     
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
	
			 String query = ("INSERT INTO medarbejder (Medarbejder_Dato)  VALUES (?)");
			
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
			 rs = s.executeQuery("select * from medarbejder"
			 		+ " left join postnr on medarbejder.FK_postnr = postnr.postnr");
			 
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