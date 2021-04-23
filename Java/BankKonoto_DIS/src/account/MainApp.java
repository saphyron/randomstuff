package account;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainApp {
	public static boolean kontoChecker = true;
	public int kontoOne = 0;
	public int kontoTwo = 0;
	public double beloeb = 0;
	public double saldoOne;
	public double saldoTwo;
	public static Connection minConnection;

	public static void main(String[] args) {
		try {
			minConnection = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;" + "databaseName=bankkonto;" + 
			"user=sa;" + "password=826066;");
			//minConnection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
			//minConnection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			minConnection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
			//minConnection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			minConnection.setAutoCommit(false);
		} catch (SQLException e) {
			System.out.println("fejl:  " + e.getMessage());
			e.printStackTrace();
		}
		MainApp mapp = new MainApp();
		mapp.overfoerSaldo();
	}

	public void stop() {
		System.out.println("Vil du gerne fortsaette");
		BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
		try {
			String navn = inLine.readLine();
		} catch (IOException e) {
			System.out.println("fejl:  " + e.getMessage());
			e.printStackTrace();
		}
	}
	public void chooseAccounts() {
		try {
			System.out.println("Velkommen til bankens overførelses-application!");
			BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Intast dit kontonummer: ");
			kontoOne = Integer.parseInt(inLine.readLine());
			System.out.println("Intast modtagers kontonummer: ");
			kontoTwo = Integer.parseInt(inLine.readLine());
			System.out.println("Intast beloebet der skal overfoeres: ");
			beloeb = Double.parseDouble(inLine.readLine());
		} catch (NumberFormatException e) {
			System.out.println("fejl:  " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("fejl:  " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void overfoerSaldo() {
		hentBrugere();
		chooseAccounts();
		checkKonto(kontoOne);
		if (!kontoChecker) {
			System.out.println("Konto: " + kontoOne + " eksisterer ikke.");
			return;
		}
		checkKonto(kontoTwo);
		if (!kontoChecker) {
			System.out.println("Konto: " + kontoTwo + " eksisterer ikke.");
			return;
		}
		checkKontoBalance(kontoOne, beloeb);
		if (!kontoChecker) {
			System.out.println("Beloeb er for hoejt: ");
			return;
		}
		beregnBeloebOne(kontoOne, beloeb);
		beregnBeloebTwo(kontoTwo, beloeb);
		stop();
		updaterKontoOne(kontoOne, saldoOne);
		System.out.println();
		System.out.println("Der er haevet: " + beloeb + " paa konti: " + kontoOne + ".");
		updaterKontoTwo(kontoTwo, saldoTwo);
		System.out.println("Der er sat ind: " + beloeb + " paa konti: " + kontoTwo + ".");
		System.out.println();
		
	}
	
	public void beregnBeloebOne(int k1, double beloeb) {
		try {
		String sql = "select saldo from Konto " + "\n" + "where ktoNr = ?";
		PreparedStatement prestmt = minConnection.prepareStatement(sql);
		prestmt.clearParameters();
		prestmt.setInt(1, k1);
		ResultSet res = prestmt.executeQuery();
		double checkDouble = 0;
		while (res.next()) {
			String checker = res.getString(1);
			checkDouble = Double.parseDouble(checker);
		}
		saldoOne = checkDouble - beloeb;
		} catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	}
	public void beregnBeloebTwo(int k2, double beloeb) {
		try {
		String sql = "select saldo from Konto " + "\n" + "where ktoNr = ?";
		PreparedStatement prestmt = minConnection.prepareStatement(sql);
		prestmt.clearParameters();
		prestmt.setInt(1, k2);
		ResultSet res = prestmt.executeQuery();
		double checkDouble = 0;
		while (res.next()) {
			String checker = res.getString(1);
			checkDouble = Double.parseDouble(checker);
		}
		saldoTwo = checkDouble + beloeb;
		} catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	}

	public void checkKonto(int k1) {
		try {
			String sql = "select ktoNr from Konto " + "\n" + "where ktoNr = ?";
			PreparedStatement prestmt = minConnection.prepareStatement(sql);
			prestmt.clearParameters();
			prestmt.setInt(1, k1);
			ResultSet res = prestmt.executeQuery();
			if (!res.next()) {
				kontoChecker = false;
			} else {
				kontoChecker = true;
			}
			while (res.next()) {
				System.out.println(res.getString(1));
			}
			if (prestmt != null)
				prestmt.close();
			
		} catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	}

	public void checkKontoBalance(int k1, double beloeb) {
		try {
			String sql = "select saldo from Konto " + "\n" + "where ktoNr = ?";
			PreparedStatement prestmt = minConnection.prepareStatement(sql);
			prestmt.clearParameters();
			prestmt.setInt(1, k1);
			ResultSet res = prestmt.executeQuery();
			while (res.next()) {
				String checker = res.getString(1);
				double checkDouble = Double.parseDouble(checker);
				if (checkDouble < beloeb) {
					kontoChecker = false;
				} else {
					kontoChecker = true;
				}
			}
			if (prestmt != null)
				prestmt.close();
		} catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	}

	public void updaterKontoOne(int k1, double beloeb) {
		try {
			String sql = "update Konto set saldo = ? " + "\n" + "where ktoNr = ?";
			PreparedStatement prestmt = minConnection.prepareStatement(sql);
			prestmt.clearParameters();
			prestmt.setDouble(1, beloeb);
			prestmt.setInt(2, k1);
			prestmt.executeUpdate();
			if (prestmt != null)
				prestmt.close();
		} catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	}

	public void updaterKontoTwo(int k2, double beloeb) {
		try {
			String sql = "update Konto set saldo = ? " + "\n" + "where ktoNr = ?";
			PreparedStatement prestmt = minConnection.prepareStatement(sql);
			prestmt.clearParameters();
			prestmt.setDouble(1, beloeb);
			prestmt.setInt(2, k2);
			prestmt.executeUpdate();
			minConnection.commit();
			if (prestmt != null)
				prestmt.close();
			if (minConnection != null)
				minConnection.close();
		} catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	}

	public void hentBrugere() {
		try {
			Statement stmt = minConnection.createStatement();
			ResultSet res = stmt.executeQuery("select tekst, saldo from Konto");
			while (res.next()) {
				System.out.println(res.getString(1) + "\t" + res.getString(2));
			}
			if (res != null)
				res.close();
			if (stmt != null)
				stmt.close();
		} catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	}
}