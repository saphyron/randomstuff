package mini_projekt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MainApp {
	public static void main(String[] args) {
		try {
			BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Intast CPR nummer: ");
			String CPR = inLine.readLine();
			System.out.println("Intast karakter: ");
			String karakter = inLine.readLine();
			System.out.println("Intast FagID:(1,2,3,4,5,6,7) ");
			String fagID = inLine.readLine();
			Connection minConnection;
			minConnection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Karakter_Registrering_System;user=sa;password=8260Viby");
			String sql = "insert into EksamensResultat values(?,?,?,?)";
			PreparedStatement prestmt = minConnection.prepareStatement(sql);
			prestmt.clearParameters();
			prestmt.setString(1, CPR);
			prestmt.setInt(2, Integer.parseInt(karakter.trim()));
			int bestaaet = 0;
			if (Integer.parseInt(karakter.trim()) < 2) {
				bestaaet = 0;
			} else {
				bestaaet = 1;
			}
			prestmt.setInt(3, bestaaet);
			prestmt.setInt(4, Integer.parseInt(fagID.trim()));
			prestmt.executeUpdate();
			System.out.println("Karakter indsat");

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
				System.out.println("CPR-nummer er for langt.");
			} else if (e.getErrorCode() == 547) {
				System.out.println("Ugyldig karakter eller fagID.");
			}
		}	
		catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	}

}
