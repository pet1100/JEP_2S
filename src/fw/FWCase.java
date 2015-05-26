package fw;

import dbe.Case;
import dbe.DBAddress;

import java.sql.*;

import com.sun.rowset.CachedRowSetImpl;

public class FWCase extends dbe.DBAddress {

	private Connection con;
	Integer numero = 0;
	Integer sagsid = -1;

	public FWCase() {

	}

	public ResultSet read(int id) {

		String txt = null;
		ResultSet rs = null;
		try {
			Statement s = null;
			Class.forName(getJDBC_DRIVER());
			con = DriverManager.getConnection(getDATABASE_URL(), getUsername(),
					getpassword());
			s = con.createStatement();
			rs = s.executeQuery("SELECT * FROM mydb.kunder where Kunde_Id = 1 = '"
					+ id + "' ");

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
		return rs; // emne notat oprettelsesdato aktiv sag_adresse sagpostnr
					// bynavn kunde_navn kunde_efternavn kundetlf kunde_email
					// medarbejder_navn medarbejder_efternavn

	}

	public dbe.Case update(dbe.Case name) {
		ResultSet rs;
		try {
			Statement s = null;
			Class.forName(getJDBC_DRIVER());
			con = DriverManager.getConnection(getDATABASE_URL(), getUsername(),
					getpassword());
			s = con.createStatement();

			String query = "update sager set Sager_Emne = ?, Sager_Notat = ?, Sager_Aktiv = 1, Fk_Kunde = ?, Fk_Ansvarlig = ?, "
					+ "Sager_Type = ?, Sager_Adresse = ?, Fk_postnr = ? where Sager_Id = ("
					+ name.getId() + ")";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, name.getName());
			preparedStmt.setString(2, name.getNoteInternal());
			preparedStmt.setInt(3, name.getClient());
			preparedStmt.setInt(4, name.getAccountable());
			preparedStmt.setString(5, name.getType());
			preparedStmt.setString(6, name.getAddress());
			preparedStmt.setShort(7, name.getZipCode());

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

	public Integer create() {
		java.util.Date today = new java.util.Date();
		java.sql.Timestamp ts1 = new java.sql.Timestamp(today.getTime());
		ResultSet rs;
		try {
			Statement s = null;
			Class.forName(getJDBC_DRIVER());
			con = DriverManager.getConnection(getDATABASE_URL(), getUsername(),
					getpassword());
			s = con.createStatement();

			String query = ("INSERT INTO sager (Sager_OprettetDato)  VALUES (?)");

			PreparedStatement preparedStmt = con.prepareStatement(query,
					PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStmt.setTimestamp(1, ts1);

			preparedStmt.execute();
			rs = preparedStmt.getGeneratedKeys();
			if (rs.next()) {
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
		return sagsid;

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
			 rs = s.executeQuery("Select sager.Sager_emne, sager.Sager_Notat, sager.Sager_OprettetDato, sager.Sager_Aktiv, sager.Sager_Adresse, postnr.postnr, postnr.By, kunder.Kunde_navn, kunder.Kunde_EfterNavn, kunder.Kunde_Tlf, kunder.Kunde_Email, medarbejder.Medarbejder_Navn, medarbejder.Medarbejder_EfterNavn, sager.Sager_Id from sager"
				+	" left join medarbejder on sager.Fk_Ansvarlig = Medarbejder_Id"
				+	" left join kunder on sager.Fk_kunde = Kunde_Id"
				+	" left join postnr on sager.FK_postnr = postnr"
				+ 	" order by sager_Id");

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
