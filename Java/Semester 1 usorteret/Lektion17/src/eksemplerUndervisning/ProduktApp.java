package eksemplerUndervisning;

public class ProduktApp {

	public static void main(String[] args) {
		
		System.out.println("Antal produkter: " + Produkt.getAntalProdukt());
		
		Produkt mælk = new Produkt("Mælk");
		Produkt cola = new Produkt("Cola");
		Produkt oksekød = new Produkt("oksekæd");
		Produkt Chocolade = new Produkt("Chocolade");
		
		System.out.println("Antal produkter: " + Produkt.getAntalProdukt());

	}

}
