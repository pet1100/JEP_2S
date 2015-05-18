package fw;
import dbe.Case;
import dbe.DBAddress;

import java.sql.*;


public class FWCase extends dbe.DBAddress {

	private Connection con;
	 Integer numero=0;
	Integer  sagsid = -1;
	public FWCase()
	{

		
		
	}
	
	

	public void read(int id) {
		
		String txt = null;
		ResultSet rs = null;
		try {
			Statement s = null;
			Class.forName(getJDBC_DRIVER());
			con = DriverManager.getConnection(getDATABASE_URL(), "root",
					"hejhej123");
			s = con.createStatement();
			 rs = s.executeQuery("SELECT * from sager where Sager_Id = ("+id+")");

			if (rs != null)
				while (rs.next()) {
				 System.out.println( "Sag: " + rs.getString(1)
							+ " " + rs.getString("Sager_emne") + " "
							+ rs.getByte("Sager_Aktiv") + " "
							+ rs.getString("Sager_Notat"));
				
				
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
	
		
		
	}

	public boolean update(dbe.DBE name) {
		throw new UnsupportedOperationException();
	}

	public  void create() {
		ResultSet rs ;
		try {
			Statement s = null;
			Class.forName(getJDBC_DRIVER());
			con = DriverManager.getConnection(getDATABASE_URL(), getUsername(),
					getpassword());
			s = con.createStatement();
	
			 String query = ("INSERT INTO sager (Sager_emne, Sager_Notat, Sager_Aktiv, Sager_Type)  VALUES (?, ?, ?, ?) ");
			
			 PreparedStatement preparedStmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			
			 
			 
		      preparedStmt.setString (1, "sss11");
		      preparedStmt.setString (2, "sss11");
		      preparedStmt.setByte(3, (byte) 1);
		      preparedStmt.setString(4, "s11");
		      
		     
		     
		      preparedStmt.execute();
		   rs = preparedStmt.getGeneratedKeys();
		     if (rs.next()){
		            sagsid = rs.getInt(1);
		           
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
		System.out.println(sagsid);

	}

	public ResultSet readAll() {
		throw new UnsupportedOperationException();
	}
}