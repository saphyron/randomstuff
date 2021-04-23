package bankKonto;

public class BankKonto {
	
	private double balance;
	private static int kontoNummer;
	
	public BankKonto() {
		balance = 0;
		kontoNummer++;
		
	}
	
	public synchronized void haeveKonto(double haeve) {
		setKontoBalance(balance - haeve);
	}
	
	public synchronized void indsaetKonto(double indsaet) {
		setKontoBalance(balance + indsaet);
	}
	
	public synchronized void setKontoBalance(double amount) {
		balance = amount;
	}

	public double hentKontoBalance() {
		return balance;
	}

	public static int getKontoNummer() {
		return kontoNummer;
	}
	
}
