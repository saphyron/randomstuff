package application;

/**
 * Kulsyre med special attributter som 
 * vægt i kg (double) og pant (dobule) 
 *
 * @author Gruppe 5
 * @see    Produkt
 */

public class Kulsyre extends Produkt implements java.io.Serializable{
	
	private static final long serialVersionUID = 123123123;
	//Attributter:
	private double vægt;
	private double pant;

	/**
	 * For at skabe et produkt af gruppen kulsyre.
	 * @param navn som er en string. Nedarvet fra Produkt klassen.
	 * @param vægt 0 til x. For at beskrive vægten af produktet.
	 * @param pant 0 til x. Produktets pant pris.
	 * @param prisliste for at tilkoble den til en prisliste. Nedarvet fra produkt klassen.
	 * @throws IllegalArgumentException hvis double værdier er negativ
	 */
	public Kulsyre(String navn, double vægt, double pant, ProduktType produktType) {
		super(navn, produktType);
		if(vægt <= 0) {
			throw new IllegalArgumentException("Fejl! Vægten kan ikke være nul eller negativ.");
		}
		if(pant < 0) {
			throw new IllegalArgumentException("Fejl! Pant kan ikke være negativ.");
		}
		this.pant = pant;
		this.vægt = vægt;
	}
	//Getters og Setters
	public double getVægt() {
		return vægt;
	}
	public void setVægt(double vægt) {
		this.vægt = vægt;
	}
	public double getPant() {
		return pant;
	}
	public void setPant(double pant) {
		this.pant = pant;
	}
	@Override
	public String[][] getAttributter() {
		return new String[][] {
				{ "Vægt", ""+vægt},
				{ "Pant", ""+pant}
		};
	}

}
