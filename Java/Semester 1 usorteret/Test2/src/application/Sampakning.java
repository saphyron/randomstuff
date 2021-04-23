package application;

/**
 * Nedavningsklasse med special attributter som 
 * antal øl (int) og antal glas (int)
 *
 * @author Gruppe 5
 * @see    Produkt
 */

public class Sampakning extends Produkt implements java.io.Serializable  {
	
	//Attributter. Sampakning har en antalØl, antalGlas, som begge er int, og en type som er en String.
	private int antalØl;
	private int antalGlas;
	private static final long serialVersionUID = 123123123;
	
	/**
	 * for at skabe et produkt af gruppen Sampakning.
	 * @param navn som er en string. Nedarvet fra Produkt klassen.
	 * @param antalØl 0 til x. Antal øl i kassen.
	 * @param antalGlas 0 til x. Antal glas i kassen.
	 * @param type != null, length != 0. Hvilken type kasse det er.
	 * @param prisliste for at tilkoble den til en prisliste. Nedarvet fra produkt klassen.
	 * @throws IllegalArgumentException hvis antal øl eller antal glas er negativ.
	 */
	public Sampakning(String navn, int antalØl, int antalGlas, ProduktType produktType) {
		super(navn, produktType);
		if(antalGlas < 0) {
			throw new IllegalArgumentException("Fejl! Antal glas kan ikke være negativ.");
		}
		if(antalØl < 0) {
			throw new IllegalArgumentException("Fejl! Antal øl kan ikke være negativ.");
		}
		this.antalGlas = antalGlas;
		this.antalØl = antalØl;
	}
	//Getters og Setters
	public int getAntalØl() {
		return antalØl;
	}
	
	public void setAntalØl(int antalØl) {
		this.antalØl = antalØl;
	}
	
	public int getAntalGlas() {
		return antalGlas;
	}
	
	public void setAntalGlas(int antalGlas) {
		this.antalGlas = antalGlas;
	}
	
	@Override
	public String[][] getAttributter() {
		return new String[][] {
			{ "Antal øl", ""+antalØl},
			{ "Antal glas", ""+antalGlas}
		};
	}
}
