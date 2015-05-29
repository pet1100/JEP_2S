package dbe;

// @Jannik E.
// this class is used to access database.
public class DBAddress
{

	private String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private String DATABASE_URL = "jdbc:mysql://localhost/mydb";
	private String username = "root";
	private String password = "1337";

	public DBAddress()
	{

	}

	public String getJDBC_DRIVER()
	{

		return JDBC_DRIVER;

	}

	public String getDATABASE_URL()
	{
		return DATABASE_URL;
	}

	public String getUsername()
	{
		return username;
	}

	public String getpassword()
	{
		return password;
	}

}