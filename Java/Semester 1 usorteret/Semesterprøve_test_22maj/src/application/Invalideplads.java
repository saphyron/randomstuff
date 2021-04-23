package application;

import java.time.LocalTime;

import application.Parkeringsplads;

public class Invalideplads extends Parkeringsplads{
	
	private double areal;
	
	public Invalideplads(int nummer, double areal) {
		super(nummer);
		this.areal = areal;
		
	}

	public double getAreal() {
		return areal;
	}

	public void setAreal(double areal) {
		this.areal = areal;
	}
	
	public double parkeringsPris(LocalTime slutTidspunkt) {
		double pris = 0;
		pris = super.parkeringsPris(slutTidspunkt) - super.parkeringsPris(slutTidspunkt);
		return pris;
	}

}
