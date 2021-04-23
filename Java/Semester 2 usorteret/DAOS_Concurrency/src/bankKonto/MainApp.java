package bankKonto;

public class MainApp {

	public static void main(String[] args) {
		BankKonto bk = new BankKonto();
		Thread t1 = new BankKontoThread(bk);
		Thread t2 = new BankKontoThread(bk);


		t1.start();
		t2.start();
		
		System.out.println(bk.hentKontoBalance());


	}

}
