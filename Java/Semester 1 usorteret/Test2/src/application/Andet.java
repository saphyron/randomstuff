	package application;

/**
 * Nedavningsklasse med special attribut som beskrivelse (String).
 *
 * @author Gruppe 5
 * @see    Produkt
 */

public class Andet extends Produkt implements java.io.Serializable{

	private static final long serialVersionUID = 123123123;
	
	//Da andet er en samlig af produkter har vi valgt at bruge en String til at beskrive deres værdier.
	//Da deres værdier ikke har nogen inflydelse på prisen.
	private String beskrivelse;

	/**
	 * Skabe et produkt af gruppen andet.
	 * @param navn som er en string. Nedarvet fra Produkt klassen.
	 * @param beskrivelse length != 0, != null. Bruges for at beskrive produktet.
	 * @param produktType != null, Produktets tilhørende produkttype.
	 * @throws IllegalArgumentException hvis mindst en af double variablerne er
	 *         negative.
	 * @throws IllegalArgumentException hvis navn er tom eller kun bestående af mellemrum.
	 * @throws IllegalArgumentException hvis navn er null
	 */
	
	public Andet(String navn, ProduktType produktType, String beskrivelse) {
		super(navn, produktType);
		if (beskrivelse == null) {
			throw new IllegalArgumentException("Fejl! Beskrivelsen kan ikke være null.");
		}
		if(beskrivelse.length() == 0) {
			throw new IllegalArgumentException("Fejl! Beskrivelsen kan ikke være tom.");
		}
		//Den tjekker dog kun om beskrivelsen KUN er mellemrum.
		if(beskrivelse.trim().length() == 0) {
			throw new IllegalArgumentException("Fejl! Beskrivelsen er kun mellemrum.");
		}
		if (navn == null) {
			throw new IllegalArgumentException("Fejl! Navn kan ikke være null.");
		}
		if(navn.length() == 0) {
			throw new IllegalArgumentException("Fejl! Navn kan ikke være tom.");
		}
		//Den tjekker dog kun om navn KUN er mellemrum.
		if(navn.trim().length() == 0) {
			throw new IllegalArgumentException("Fejl! Navn er kun mellemrum.");
		}
		this.beskrivelse = beskrivelse;
	}
	
	public String getBeskrivelse() {
		return beskrivelse;
	}
	
	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}
	
	@Override
	public String[][] getAttributter() {
		return new String[][] { { "Beskrivelse", beskrivelse } };
	}
}
