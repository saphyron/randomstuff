package eksemplerUndervisning;

public class ProduktApp {

	public static void main(String[] args) {
		
		System.out.println("Antal produkter: " + Produkt.getAntalProdukt());
		
		Produkt m�lk = new Produkt("M�lk");
		Produkt cola = new Produkt("Cola");
		Produkt oksek�d = new Produkt("oksek�d");
		Produkt Chocolade = new Produkt("Chocolade");
		
		System.out.println("Antal produkter: " + Produkt.getAntalProdukt());

	}

}
