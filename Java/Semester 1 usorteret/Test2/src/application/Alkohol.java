package application;

/**
 * Nedavningsklasse med special attributter som 
 * alkoholprocent (double), volume i liter (double)
 * og pant (double).
 *
 * @author Gruppe 5
 * @see    Produkt
 */

public class Alkohol extends Produkt implements java.io.Serializable{
	
	private static final long serialVersionUID = 123123123;
	//Attributter: alkoholProcent, volume, og pant som alle er double.
	private double alkoholProcent;
	private double volume;
	private double pant;
	
	/**
	 * Til at skabe et produkt af gruppen alkohol.
	 * @param  navn er produktets navn.
	 * @param  liter 0.0001 til x. Produktets liter antal.
	 * @param  pant 0 til x. Produktets pant pris.
	 * @param  produktType != null, Produktets tilhørende produkttype.
	 * @throws IllegalArgumentException hvis mindst en af double variablerne er
	 *         negative.
	 */
	
	public Alkohol(String navn, double alkoholProcent, double volume, double pant, ProduktType produktType) {
		super(navn, produktType);
		if(alkoholProcent < 0) {
			throw new IllegalArgumentException("Fejl! Alkohol % kan ikke være negativ.");
		}
		if(volume < 0) {
			throw new IllegalArgumentException("Fejl! Volume tal kan ikke være negativ.");
		}
		if(pant < 0) {
			throw new IllegalArgumentException("Fejl! Pant kan ikke være negativ.");
		}
		this.alkoholProcent = alkoholProcent;
		this.volume = volume;
		this.pant = pant;
		super.setGebyr(pant);
	}
	
	/**
	 * @return en double som repræsenterer alkoholprocenten.
	 */
	
	public double getAlkoholProcent() {
		return alkoholProcent;
	}
	
	public void setAlkoholProcent(double alkoholProcent) {
		this.alkoholProcent = alkoholProcent;
	}

	/**
	 * @return en double som repræsenterer volumen (liter).
	 */
	
	public double getVolume() {
		return volume;
	}
	
	public void setVolume(double liter) {
		this.volume = liter;
	}
	
	/**
	 * @return en double som repræsenterer panten af flasken eller lign.
	 */
	
	public double getPant() {
		return pant;
	}
	
	public void setPant(double pant) {
		this.pant = pant;
	}
	
	@Override
	public String[][] getAttributter() {
		return new String[][]{ { "Alkohol %", ""+alkoholProcent },
			{ "Volume", ""+volume },
			{ "Pant", ""+pant } 
		};
	}
}
