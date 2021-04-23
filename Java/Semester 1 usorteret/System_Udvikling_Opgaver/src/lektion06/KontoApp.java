package lektion06;

public class KontoApp {

	public static void main(String[] args) {
		Konto konto1 = new Konto("L�nkonto", 1);
		System.out.println("ID " + konto1.getNr());
		System.out.println("Du har en " + konto1.getKontoType());
		System.out.println("Der st�r " + konto1.getSaldo() + " p� din " + konto1.getKontoType());
		System.out.println("Status p� din " + konto1.getKontoType() + " er " + konto1.getStatus());
		System.out.println("- - - - - - - - - - - - - -");
		
		konto1.lukKonto();
		konto1.h�vBel�b(1000);
		System.out.println("- - - - - - - - - - - - - -");
		
		konto1.setStatus("l�st");
		konto1.setKontoType("Opsparingskonto");
		konto1.inds�tBel�b(50000);
		System.out.println("Du har en " + konto1.getKontoType());
		System.out.println("Der st�r " + konto1.getSaldo() + " p� din " + konto1.getKontoType());
		System.out.println("Status p� din " + konto1.getKontoType() + " er " + konto1.getStatus());
		System.out.println("- - - - - - - - - - - - - -");
		
		konto1.h�vBel�b(10000);
		System.out.println("- - - - - - - - - - - - - -");
		
		konto1.setStatus("�ben");
		konto1.h�vBel�b(10000);
		System.out.println("Status p� din " + konto1.getKontoType() + " er " + konto1.getStatus());
		System.out.println("Der st�r " + konto1.getSaldo() + " p� din " + konto1.getKontoType());
	}

}
