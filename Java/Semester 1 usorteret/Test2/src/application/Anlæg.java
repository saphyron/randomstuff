package application;

/**
 * Nedavningsklasse med special attributter 
 * som pant (double).
 * Anlæg er speciel fordi den
 * kunden først betaler på samme
 * dag kunnden retunere anlæget.
 * Denne logik sker igennem
 * kvittering.
 *
 * @author Gruppe 5
 * @see    Produkt
 */

public class Anlæg extends Produkt implements java.io.Serializable {
	private static final long serialVersionUID = 123123123;
	// Attributter
	private double pant;

	/**
	 * Skaber en reservering af anlæg med følgende parameter.
	 * 
	 * @param navn               på pruduktet. String
	 * @param datoForAflevering  er afleveringsdatoen. LocalDate.
	 * @param reserveringsStatus er hvis produktet er gået forbi sin leveringsdato.
	 *                           Boolean.
	 * @throws IllegalArgumentException hvis double er negativ.
	 */
	
	public Anlæg(String navn, double pant, ProduktType produktType) {
		super(navn, produktType);
		
		if (pant < 0) {
			throw new IllegalArgumentException("fejl pant må ikke være negativ");
		}
		this.pant = pant;
	}

	@Override
	public String[][] getAttributter() {
		return new String[][] {	{ "Pant", ""+pant} };
	}
	
}
