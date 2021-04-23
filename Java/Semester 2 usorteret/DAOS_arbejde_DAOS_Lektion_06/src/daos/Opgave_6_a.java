package daos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Opgave_6_a {
	public static void main(String[] args) {
		try {
			BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Intast Produkt navn: ");
			String navn = inLine.readLine();
			System.out.println("Intast Alkohol procent: ");
			String alkoholProcent = inLine.readLine();
			System.out.println("Intast volumen i liter: ");
			String volume = inLine.readLine();
			System.out.println("Indtast pant: ");
			String pant = inLine.readLine();
			System.out.println("ID 1: Flaske ");
			System.out.println("ID 2: Fadøl ");
			System.out.println("ID 3: Spiritus ");
			System.out.println("ID 4: Fustage ");
			System.out.println("ID 5: Kulsyre ");
			System.out.println("ID 6: Malt ");
			System.out.println("ID 7: Beklædning ");
			System.out.println("ID 8: Anlæg ");
			System.out.println("ID 9: Glas ");
			System.out.println("ID 10: Sampakning ");
			System.out.println("ID 11: Rundvisning ");
			System.out.println("ID 12: Klippekort ");
			System.out.println("Indtast produkt ID: ");
			String id = inLine.readLine();
			Connection minConnection;
			minConnection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Aarhus_Bryghus;user=sa;password=8260Viby");
			String sql = "insert into ProduktAlkohol values(?,?,?,?,?)";
			PreparedStatement prestmt = minConnection.prepareStatement(sql);
			prestmt.clearParameters();
			prestmt.setString(1, navn);
			if (Double.parseDouble(alkoholProcent.trim()) < 0) {
				throw new IllegalArgumentException("Fejl! Alkoholprocent er negativ: ");
			} 
			prestmt.setFloat(2, Float.parseFloat(alkoholProcent.trim()));
			if (Double.parseDouble(volume.trim()) < 0) {
				throw new IllegalArgumentException("Fejl! Volumen er negativ: ");
			} 
			prestmt.setFloat(3, Float.parseFloat(volume.trim()));
			if (Double.parseDouble(pant.trim()) < 0) {
				throw new IllegalArgumentException("Fejl! Pant er negativ: ");
			} 
			prestmt.setInt(4, Integer.parseInt(pant.trim()));
			prestmt.setInt(5, Integer.parseInt(id.trim()));
			prestmt.executeUpdate();
			System.out.println("Produkt " + navn + " indsat");

			if (prestmt != null)
				prestmt.close();
			if (minConnection != null)
				minConnection.close();
		} catch (SQLException e) {
			System.out.println("fejl:  " + e.getMessage());
			System.out.println("fejl:  " + e.getErrorCode());
			if (e.getErrorCode() == 208) {
				System.out.println("Forkert database!");
			} else if (e.getErrorCode() == 8152) {
				System.out.println("Navnet er for langt.");
			} else if (e.getErrorCode() == 547) {
				System.out.println("Ugyldig ID nummer.");
			}
		}	
		catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	}

}
