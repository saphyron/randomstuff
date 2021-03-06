package daos_Lektion08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectSkuespillersAlderMedInput {

	public static void main(String[] args) {

		try {
			System.out.println("Find Skuespillers Alder. ");
			BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Indtast Skuespillernavn ");
			String navn = inLine.readLine();

			Connection minConnection;
			minConnection = DriverManager
//					.getConnection("jdbc:sqlserver://JOHN-LAPPY;databaseName=Friends;user=sa;password=8260Viby;");
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Friends;user=sa;password=8260Viby");

			String sql = "execute SkueSpillersAlder ?";// preparedStatement
			PreparedStatement prestmt = minConnection.prepareStatement(sql);
			prestmt.clearParameters();

			prestmt.setString(1, navn.trim());
			
			ResultSet res = prestmt.executeQuery();
			while (res.next()) {
				System.out.println(res.getString(1)+ "\t" + "\t" + res.getString(2) );
			}

			if (prestmt != null)
				prestmt.close();
			if (minConnection != null)
				minConnection.close();
		} catch (SQLException e) {
			System.out.println("fejl:  " + e.getMessage());
			System.out.println("fejl:  " + e.getErrorCode());
			if (e.getErrorCode() == 2627) {
				System.out.println("MedlemsID er allerede i brug.");
			} else if (e.getErrorCode() == 8152) {
				System.out.println("Medlemsnavn er for langt.");
			} else if (e.getErrorCode() == 547) {
				System.out.println("Foreign key constrain.");
			}
		}	
		catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	}

}
