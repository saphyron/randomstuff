package eksemplerUndervisning;

public class Produkt {
	private static int antalProdukt;
	private String navn;
	
	
	public Produkt(String navn) {
		super();
		this.navn = navn;
		antalProdukt++;
	}


	public String getNavn() {
		return navn;
	}


	public void setNavn(String navn) {
		this.navn = navn;
	}


	public static int getAntalProdukt() {
		return antalProdukt;
	}
	
	
	

}
