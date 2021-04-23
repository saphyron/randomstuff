package opgaver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

public class Opgave_06 {

	public static void main(String[] args) {
		String datoReg = "";
		
		try {
			System.out.println("Find Medarbejder ");
			BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Intast Start Tid: ");
			String startTid = inLine.readLine();
			System.out.println("Intast Slut Tid: ");
			String slutTid = inLine.readLine();
			System.out.println("Intast beskrivelse: ");
			String beskrivelse = inLine.readLine();
			System.out.println("Er Datoregistrering idag? Ja/Nej: ");
			String datoRegIdag = inLine.readLine();
			//anden måde
			if(datoRegIdag == "Nej") {
				System.out.println("Intast datoregistrering: ");
				datoReg = inLine.readLine();
			}
			System.out.println("Intast medarbejdernummer: ");
			String medarbejderNummer = inLine.readLine();
			System.out.println("Intast opgavenummer: ");
			String opgaveNummer = inLine.readLine();
			Connection minConnection;
			minConnection = DriverManager
//					.getConnection("jdbc:sqlserver://JOHN-LAPPY;databaseName=Lektion_03_tidsregistrering;user=sa;password=8260Viby;");
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Lektion_03_tidsregistrering;user=sa;password=8260Viby");
			//tidsid, starttid, sluttid, beskrivelse, datoregistrering, medarbejdernr, opgavenr
			// 2 prepared statements fix det :P
			String sql = "insert into Tidsregistering values(?,?,?,?,?,?)";
			PreparedStatement prestmt = minConnection.prepareStatement(sql);
			prestmt.clearParameters();
			prestmt.setString(1, startTid);
			prestmt.setString(2, slutTid);
			prestmt.setString(3, beskrivelse);
			if(datoRegIdag == "Nej") {
				prestmt.setString(4, datoReg);
			} else {
				prestmt.setString(4, LocalDate.now().toString());
			}
			
			prestmt.setInt(5, Integer.parseInt(medarbejderNummer.trim()));
			prestmt.setInt(6, Integer.parseInt(opgaveNummer.trim()));
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
