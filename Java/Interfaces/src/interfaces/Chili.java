package interfaces;

import java.util.Comparator;

public class Chili implements Measurable, Comparator<String> {
	
	private String navn;
	private double styrke;
	public Chili(String navn, double styke) {
		super();
		this.navn = navn;
		this.styrke = styke;
	}
	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
	public double getStyke() {
		return styrke;
	}
	public void setStyke(double styke) {
		this.styrke = styke;
	}
	
	public double getMeasure() {
		double measure = this.styrke;
		return measure;
	}

	public String toString() {
		return navn + " har en styrke paa " + styrke + " Scoville.";
	}
	
	@Override
	// returnere enten negativ tal, 0 eller positivt tal
	public int compare(String o1, String o2) {
		// ved integer
		// return o1 - o2
		
		// ved String eller andre klasser
		return o1.compareTo(o2);
	}
}
