package application;

/*
 * Pris skal forståes
 * som en sammenkobling
 * mellem et produkt
 * og en numerisk pris
 * fra prislisten
 *
 * @author Gruppe 5
 * @see Produkt
 */
import java.text.DecimalFormat;
import java.util.Comparator;

public class Pris implements Comparable<Pris>, java.io.Serializable {
	
	private static final long serialVersionUID = 123123123;
	//Attributter
	private Produkt produkt;
	private double standardPris;
	private Comparator<Pris> comparator = new PrisComparatorStkPrisStigende();
	
	/**
	 * Skaber en pris til et produkt.
	 * @param pris 0 til x. Pris der skal tildeles til et produkt.
	 * @throws IllegalArgumentException hvis pris er negativ.
	 * @throws IllegalArgumentException hvis produkt er null.
	 */
	public Pris(double standardPris, Produkt produkt) {
		if (standardPris < 0) {
			throw new IllegalArgumentException("Fejl! Pris instans kan ikke laves: Input pris er negativ.");
		}
		
		if(produkt == null) {
			throw new IllegalArgumentException("Fejl! Pris instans kan ikke laves: Input produkt er null.");

		}

		
		this.produkt = produkt;
		this.standardPris = standardPris;
	}
	//Getters og Setters
	public Produkt getProdukt() {
		return produkt;
	}
	public void setProdukt(Produkt produkt) {
		this.produkt = produkt;
	}
	public double getStandardPris() { 	
		return standardPris;
	}
	public void setComparator(Comparator<Pris> comparator) {
		this.comparator = comparator;
	}
	@Override
	public String toString() {
		return new DecimalFormat("#.##").format(standardPris) + " kr - " + produkt.getNavn();
	}
	@Override
	public int compareTo(Pris o) {
		return comparator.compare(this, o);
	}
	
}
