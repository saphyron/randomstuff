package opgave03;

public class MainApp {

	public static void main(String[] args) {
		//En ny faelles klasse
		Faelles f1 = new Faelles();
		//Der skabes 2 tråde (navn af tråd, faelles klasse der bliver brugt)
		Thread t1 = new Traadeklassen("Monster Tråd 1", f1);
		Thread t2 = new Traadeklassen("Monster Tråd 2", f1);
		//Thread start
		t1.start();
		t2.start();
	}
}
