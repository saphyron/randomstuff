package opgaver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Opgave_07 {

	public static void main(String[] args) {
		try {
			Connection minConnection;
			minConnection = DriverManager
//					.getConnection("jdbc:sqlserver://JOHN-LAPPY;databaseName=Lektion_03_tidsregistrering;user=sa;password=8260Viby;");
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Lektion_03_tidsregistrering;user=sa;password=8260Viby");
			Statement stmt = minConnection.createStatement();
			System.out.println("Registrer Medarbejder ");
			BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Intast navn: ");
			String navn = inLine.readLine();
			System.out.println("Intast Stillingsbetegnelse: ");
			String stilling = inLine.readLine();
			System.out.println("Intast mobilnummer: ");
			String mobil = inLine.readLine();
			
			//tidsid, starttid, sluttid, beskrivelse, datoregistrering, medarbejdernr, opgavenr
			int id = Integer.parseInt(stmt.executeQuery("select max(medarbejderNr) from Medarbejder").getString(1));
			String sql = "insert into Medarbejder values(?,?,?,?)";
			PreparedStatement prestmt = minConnection.prepareStatement(sql);
			prestmt.clearParameters();
			prestmt.setInt(1, id);
			prestmt.setString(2, navn);
			prestmt.setString(3, stilling);
			prestmt.setString(4, mobil);
			
			//prestmt.setInt(6, Integer.parseInt(opgaveNummer.trim()));
			prestmt.executeUpdate();
			System.out.println("Medlem indsat");

			if (prestmt != null)
				prestmt.close();
			if (minConnection != null)
				minConnection.close();
		} catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		} 

	}

}
