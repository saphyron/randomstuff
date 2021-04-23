package model;

public class Spiritus extends Varer{
	
	private double alkoholdProcent;

	/**
	 * @param alkoholdProcent
	 */
	public Spiritus(double pris, String navn, String beskrivelse, double alkoholdProcent, Moms moms) {
		super(pris, navn, beskrivelse, moms);
		this.alkoholdProcent = alkoholdProcent;
	}

	public double getAlkoholdProcent() {
		return alkoholdProcent;
	}

	public void setAlkoholdProcent(double alkoholdProcent) {
		this.alkoholdProcent = alkoholdProcent;
	}
	
	

}
