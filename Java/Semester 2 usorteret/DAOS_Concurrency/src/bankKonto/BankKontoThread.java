package bankKonto;

public class BankKontoThread extends Thread {

	private BankKonto bankKonto;
	private int antalRuns = 10;

	public BankKontoThread(BankKonto bankKonto) {
		super();
		this.bankKonto = bankKonto;
	}

	public void run() {
		int tæller = 0;
		while (tæller < antalRuns) {
			try {
				this.sleep(250);
			} catch (Exception e) {
				e.getMessage();
			}
			indsætOgHæv(100);
			tæller++;
		}
		System.out.println("Balance er: " + bankKonto.hentKontoBalance());
	}
	
	public void indsætOgHæv(int value) {
		bankKonto.indsaetKonto(value);
		bankKonto.haeveKonto(value);
	}
}
