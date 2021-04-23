package opgave02;

public class MainApp {

	public static void main(String[] args) {
		//En ny faelles klasse
		Faelles f1 = new Faelles();
		//Id skal enten være 0 eller 1
		//Der skabes 2 tråde (navn af tråd, faelles klasse der bliver brugt)
		Thread t1 = new Traadeklassen("Monster Tråd 1", f1, 0);
		Thread t2 = new Traadeklassen("Monster Tråd 2", f1, 1);
		//Thread start
		t1.start();
		t2.start();
	}
}
