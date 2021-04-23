package eksemplerUndervisning;

public class ProduktApp {

	public static void main(String[] args) {
		
		System.out.println("Antal produkter: " + Produkt.getAntalProdukt());
		
		Produkt maelk = new Produkt("Maelk");
		Produkt cola = new Produkt("Cola");
		Produkt oksekoed = new Produkt("oksekoed");
		Produkt Chocolade = new Produkt("Chocolade");
		
		System.out.println("Antal produkter: " + Produkt.getAntalProdukt());

	}

}
