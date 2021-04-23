package daos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Opgave_6_b {
	public static void main(String[] args) {
		try {
			BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Intast Produkt navn: ");
			String produktNavn = inLine.readLine();
			System.out.println("Intast Salgs dato: ");
			String dato = inLine.readLine();
			Connection minConnection;
			minConnection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Aarhus_Bryghus;user=sa;password=8260Viby");
			String sql = "select pa.Navn, kv.Dato, sum(p.Pris) as NettoPris "
					+ "\n" + "from Kunde k, Kvittering kv, Prisliste pl, Produkttype pt, ProduktAlkohol pa, Kvitteringslinje kl, Pris p, PrisKvitteringslinje pkl "
					+ "\n" + "where k.KundeNummer = kv.Kunde "
					+ "\n" + "and kl.KvitteringID = kv.id "
					+ "\n" + "and kl.id = pkl.KvitteringslinjeID "
					+ "\n" + "and pkl.PrisID = p.id "
					+ "\n" + "and p.Prisliste = pl.Navn "
					+ "\n" + "and p.ProduktID = pa.id "
					+ "\n" + "and pa.Produkttype = pt.id "
					+ "\n" + "and ? = pa.Navn "
					+ "\n" + "and ? = kv.Dato "
					+ "\n" + "Group by pa.Navn, kv.Dato";
			PreparedStatement prestmt = minConnection.prepareStatement(sql);
			prestmt.clearParameters();
			prestmt.setString(1, produktNavn);
			prestmt.setDate(2, Date.valueOf(dato.trim()));
			ResultSet res = prestmt.executeQuery();
			while (res.next()) {
				System.out.println(res.getString(1)+ "\t"  + "\t"  + "\t"  + res.getString(2)+ "\t"  + "\t"  + "\t"  + res.getString(3) );
			}
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
			}
		}	
		catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	}

}
