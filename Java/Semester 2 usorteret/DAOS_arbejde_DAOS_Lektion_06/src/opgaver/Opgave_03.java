package opgaver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Opgave_03 {

	public static void main(String[] args) {
		try {
			System.out.println("Find Medarbejder ");
			BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Intast navn: ");
			String navn = inLine.readLine();
			Connection minConnection;
			minConnection = DriverManager
//					.getConnection("jdbc:sqlserver://JOHN-LAPPY;databaseName=Lektion_03_tidsregistrering;user=sa;password=8260Viby;");
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Lektion_03_tidsregistrering;user=sa;password=8260Viby");
			//telefon på medarbjeder når navn er givet
			String sql = "select mobil from Medarbejder "
					+ "\n" + "where navn = ?";
			PreparedStatement prestmt = minConnection.prepareStatement(sql);
			prestmt.clearParameters();
			prestmt.setString(1, navn);
			
			ResultSet res = prestmt.executeQuery();
			while (res.next()) {
				System.out.println(res.getString(1) );
			}

			if (prestmt != null)
				prestmt.close();
			if (minConnection != null)
				minConnection.close();
		} catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		} 
	}

}
