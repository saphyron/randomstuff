package daos_Lektion08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectSkuespillersAlder {
	
	public static void main(String[] args) {

		try {
			Connection minConnection;
			minConnection = DriverManager
//					.getConnection("jdbc:sqlserver://JOHN-LAPPY;databaseName=Friends;user=sa;password=8260Viby;");
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Friends;user=sa;password=8260Viby");
			Statement stmt = minConnection.createStatement();

			ResultSet res = stmt.executeQuery("select sk.Navn, DATEDIFF(year, sk.Fødselsår, GETDATE()) "
					+ "from Skuespiller sk"
					);
			while (res.next()) {
				System.out.println(res.getString(1)+ "\t"  + "\t"  + "\t"  + res.getString(2) );
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
