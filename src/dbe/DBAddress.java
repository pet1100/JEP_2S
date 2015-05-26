package dbe;
import java.sql.*;


public class DBAddress {

	private  String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;
	private  String DATABASE_URL = "jdbc:mysql://localhost/mydb";
	private String username = "root";
	private String password = "admin" ;
	

	public DBAddress()
	{
		
	}
	public String getJDBC_DRIVER() {
		
		
		
		return JDBC_DRIVER;
	
	}

	

	public String getDATABASE_URL() {
		return DATABASE_URL;
	}

	public String getUsername () {
		return username;
	}

	public String getpassword() {
		return password;
	}

	
}