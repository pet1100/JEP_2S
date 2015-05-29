package fw;

// @Jannik E.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.rowset.CachedRowSetImpl;

import dbe.Client;

public class FWCient extends dbe.DBAddress
{ // Extends DBA to use the database connection

	private Connection con;
	Integer numero = 0;
	Integer clientid = -1;

	public ResultSet read(int id)
	{ // read a specific Client where id = the one put in and returns it as a
		// resultSet

		ResultSet rs = null;
		CachedRowSetImpl crs = null;

		try
		{
			Statement s = null;
			Class.forName(getJDBC_DRIVER());
			con = DriverManager.getConnection(getDATABASE_URL(), getUsername(),
					getpassword());
			s = con.createStatement();
			rs = s.executeQuery("Select * from Kunder WHERE Kunde_Id = '" + id
					+ "' ");

			crs = new CachedRowSetImpl();
			crs.populate(rs);

			con.close();
			s.close();
		}
		catch (SQLException sqlex)
		{
			try
			{
				System.out.println(sqlex.getMessage());
				con.close();

			}
			catch (SQLException sql)
			{}
		}
		catch (ClassNotFoundException noClass)
		{
			System.err.println("Driver Class not found");
			System.out.println(noClass.getMessage());

		}
		return crs; // id(skal du ikkebruge navn efternavn tlf email adresse
					// postnr dato

	}

	public Client update(Client name)
	{ // Updates Client by taking an object of client in

		try
		{
			Statement s = null;
			Class.forName(getJDBC_DRIVER());
			con = DriverManager.getConnection(getDATABASE_URL(), getUsername(),
					getpassword());
			s = con.createStatement();

			System.out.println(name.getId() + " " + name.getName() + " "
					+ name.getTlf());

			String query = "update kunder set Kunde_navn = ?, Kunde_EfterNavn = ?, Kunde_Tlf = ?, Kunde_Email = ?, Fk_postnr = ? "
					+ " where Kunde_Id = " + name.getId() + "";
			PreparedStatement preparedStmt = con.prepareStatement(query); // using
																			// Prepared
																			// statements
																			// to
																			// insert
																			// the
																			// objects
																			// attributes
																			// at
																			// the
																			// right
																			// coloums
			preparedStmt.setString(1, name.getName());
			preparedStmt.setString(2, name.getLastName());
			preparedStmt.setInt(3, name.getTlf());
			preparedStmt.setString(4, name.getEmail());
			preparedStmt.setInt(5, name.getZipCode());

			preparedStmt.execute(); // executes the Statement

			con.close();
			s.close();

		}
		catch (SQLException sqlex)
		{
			try
			{
				System.out.println(sqlex.getMessage());
				con.close();

			}
			catch (SQLException sql)
			{}
		}
		catch (ClassNotFoundException noClass)
		{
			System.err.println("Driver Class not found");
			System.out.println(noClass.getMessage());

		}
		return name;

	}

	public int create()
	{ // Creates the Client and Returns an Integer with the Id
		java.util.Date today = new java.util.Date();
		java.sql.Timestamp ts1 = new java.sql.Timestamp(today.getTime());// gets
																			// the
																			// time
																			// now
																			// (windows
																			// time)
																			// in
																			// sql
																			// format
		ResultSet rs;
		try
		{
			Statement s = null;
			Class.forName(getJDBC_DRIVER());
			con = DriverManager.getConnection(getDATABASE_URL(), getUsername(),
					getpassword());
			s = con.createStatement();

			String query = ("INSERT INTO kunder (Kunde_Dato)  VALUES (?)");

			PreparedStatement preparedStmt = con.prepareStatement(query,
					PreparedStatement.RETURN_GENERATED_KEYS); // Places the
																// generated key
																// in prepared
																// statement
			preparedStmt.setTimestamp(1, ts1);

			preparedStmt.execute();
			rs = preparedStmt.getGeneratedKeys(); // puts the generated key into
													// Resultset
			if (rs.next())
			{
				clientid = rs.getInt(1);

			}

			rs.close();
			con.close();
			s.close();

		}
		catch (SQLException sqlex)
		{
			try
			{
				System.out.println(sqlex.getMessage());
				con.close();

			}
			catch (SQLException sql)
			{}
		}
		catch (ClassNotFoundException noClass)
		{
			System.err.println("Driver Class not found");
			System.out.println(noClass.getMessage());

		}
		return clientid;
	}

	public ResultSet readAll()
	{ // Read all Clients

		ResultSet rs = null;
		CachedRowSetImpl crs = null;

		try
		{
			Statement s = null;
			Class.forName(getJDBC_DRIVER());
			con = DriverManager.getConnection(getDATABASE_URL(), getUsername(),
					getpassword());
			s = con.createStatement();
			rs = s.executeQuery("select kunder.Kunde_Navn,  kunder.Kunde_EfterNavn,  kunder.Kunde_Tlf,   kunder.Kunde_Email,  kunder.Kunde_Adresse,  kunder.Kunde_Dato, postnr.postnr, postnr.By, kunder.Kunde_Id from kunder"
					+ " left join postnr on postnr.postnr = kunder.Fk_postnr "
					+ " order by Kunde_Id"); // Sql statements with left join to
												// get acces to all the diffrent
												// coloums, order it by Client
												// id

			crs = new CachedRowSetImpl();
			crs.populate(rs);

			con.close();
			s.close();
		}
		catch (SQLException sqlex)
		{
			try
			{
				System.out.println(sqlex.getMessage());
				con.close();

			}
			catch (SQLException sql)
			{}
		}
		catch (ClassNotFoundException noClass)
		{
			System.err.println("Driver Class not found");
			System.out.println(noClass.getMessage());

		}
		return crs; // emne notat oprettelsesdato aktiv sag_adresse sagpostnr
					// bynavn kunde_navn kunde_efternavn kundetlf kunde_email
					// medarbejder_navn medarbejder_efternavn
	}
}