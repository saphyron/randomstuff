package lektion06;

public class KontoApp {

	public static void main(String[] args) {
		Konto konto1 = new Konto("Lønkonto", 1);
		System.out.println("ID " + konto1.getNr());
		System.out.println("Du har en " + konto1.getKontoType());
		System.out.println("Der står " + konto1.getSaldo() + " på din " + konto1.getKontoType());
		System.out.println("Status på din " + konto1.getKontoType() + " er " + konto1.getStatus());
		System.out.println("- - - - - - - - - - - - - -");
		
		konto1.lukKonto();
		konto1.hævBeløb(1000);
		System.out.println("- - - - - - - - - - - - - -");
		
		konto1.setStatus("låst");
		konto1.setKontoType("Opsparingskonto");
		konto1.indsætBeløb(50000);
		System.out.println("Du har en " + konto1.getKontoType());
		System.out.println("Der står " + konto1.getSaldo() + " på din " + konto1.getKontoType());
		System.out.println("Status på din " + konto1.getKontoType() + " er " + konto1.getStatus());
		System.out.println("- - - - - - - - - - - - - -");
		
		konto1.hævBeløb(10000);
		System.out.println("- - - - - - - - - - - - - -");
		
		konto1.setStatus("Åben");
		konto1.hævBeløb(10000);
		System.out.println("Status på din " + konto1.getKontoType() + " er " + konto1.getStatus());
		System.out.println("Der står " + konto1.getSaldo() + " på din " + konto1.getKontoType());
	}

}
