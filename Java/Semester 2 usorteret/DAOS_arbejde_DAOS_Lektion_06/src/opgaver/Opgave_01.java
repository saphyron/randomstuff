package opgaver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Opgave_01 {

	public static void main(String[] args) {
		try {
			Connection minConnection;
			minConnection = DriverManager
//					.getConnection("jdbc:sqlserver://JOHN-LAPPY;databaseName=Lektion_03_tidsregistrering;user=sa;password=8260Viby;");
					.getConnection("jdbc:sqlserver://10.24.0.1:1433;databaseName=Lektion_03_tidsregistrering;user=sa;password=8260Viby");
			Statement stmt = minConnection.createStatement();

			ResultSet res = stmt.executeQuery("select medarbejderNr, navn, stillingsbetegnelse, mobil from Medarbejder");
			while (res.next()) {
				System.out.println(res.getString(1)+ "\t"  + res.getString(2) + " \t "  +res.getString(3) + " \t "  +res.getString(4));
			}

			if (res != null)
				res.close();
			if (stmt != null)
				stmt.close();
			if (minConnection != null)
				minConnection.close();
		} catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		} 
	}

}
